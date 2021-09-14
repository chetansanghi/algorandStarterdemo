package com.algorand.starter.demo.controller;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.v2.client.common.AlgodClient;
import com.algorand.algosdk.v2.client.common.IndexerClient;
import com.algorand.algosdk.v2.client.common.Response;
import com.algorand.algosdk.v2.client.model.Asset;
import com.algorand.algosdk.v2.client.model.TransactionParametersResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorand.algosdk.v2.client.model.PendingTransactionResponse;
import com.algorand.algosdk.v2.client.model.PostTransactionsResponse;
import com.algorand.algosdk.transaction.SignedTransaction;
import com.algorand.algosdk.transaction.Transaction;
import com.algorand.algosdk.util.Encoder;


import java.util.Date;
import java.util.List;


@RestController
public class AlgorandController {

    @Autowired
    private Account account;
    @Autowired
    private AlgodClient client;
    @Autowired
    private IndexerClient indexer;

    String[] headers = {"X-API-Key"};
    //String[] values = {"OVKYBexVj38K5jEMKTwnk45Cg4hVbzeD1RL8zG60"};
    String[] values = {"<Replace with secret from repository called API_KEY or uncomment the above to use default>"};

    /**
     * A method to retrieve account details as specified in the properties file
     * @return String representing account data
     * @throws Exception
     */
    @GetMapping(path="/account", produces = "application/json; charset=UTF-8")
    public String account() throws Exception {
        return client.AccountInformation(account.getAddress()).execute(headers, values).body().toString();
    }

    /**
     * A method to retrieve specific asset details from an account as specified in the properties file
     * @return String representing account data
     * @throws Exception
     */
    @GetMapping(path="/accountAssetSearch", produces = "application/json; charset=UTF-8")
    public String account(@RequestParam String assetName) throws Exception {
        Asset returnAsset = new Asset();
        List<Asset> createdAssets =
                client.AccountInformation(account.getAddress()).execute(headers, values).body().createdAssets;
        for (Asset asset : createdAssets) {
            if(asset.params.name.equals(assetName)){
             returnAsset = asset;
            }
        }
        return returnAsset.toString();
    }

    /**
     * A method to retrieve asset data from the blockchain
     * @param assetId The asset ID of interest
     * @return String representing the asset datat
     * @throws Exception
     */
    @GetMapping(path="/asset", produces = "application/json; charset=UTF-8")
    public String asset(@RequestParam Long assetId) throws Exception {
        return client.GetAssetByID(assetId).execute(headers, values).body().toString();
    }

    /**
     * A method to retrieve pending transactions against the account configured in the properties file
     * @return String representing the pending transactions
     * @throws Exception
     */
    @GetMapping(path="/pendingTransactions", produces = "application/json; charset=UTF-8")
    public String pendingTransactions() throws Exception {
        return client.GetPendingTransactionsByAddress(account.getAddress()).execute(headers, values).toString();
    }

    /**
     * A method to search for an asset by name using the indexer
     * @param assetName The name of the asset to search for
     * @return String representing the asset details
     * @throws Exception
     */
    @GetMapping(path="/assetSearch", produces = "application/json; charset=UTF-8")
    public String assetSearch(@RequestParam String assetName) throws Exception {
        return indexer.searchForAssets().name(assetName).limit(1L).execute(headers, values).toString();
    }

    /**
     * A method to search for account transactions before a given date using the indexer
     * @param date the date of interest to search before
     * @return String representation of the account transactions
     * @throws Exception
     */
    @GetMapping(path = "/accountTransactionsBefore")
    public String accountTransactionsBeforeDate(@RequestParam Date date) throws Exception {
        return indexer.lookupAccountTransactions(account.getAddress()).beforeTime(date).limit(1L).execute(
                headers, values).toString();
    }
    
    @GetMapping(path = "/balance", produces = "application/json; charset=UTF-8")
    public String checkBalance() throws Exception{
    	Response <com.algorand.algosdk.v2.client.model.Account> respAcct = client.AccountInformation(account.getAddress()).execute(headers, values);
    	if (!respAcct.isSuccessful()) {
    	    throw new Exception(respAcct.message());
    	}
    	com.algorand.algosdk.v2.client.model.Account accountInfo = respAcct.body();
    	System.out.println(String.format("Account Balance: %d microAlgos", accountInfo.amount));
    	return String.format("Account Balance: %d microAlgos", accountInfo.amount);
    }
    
    
    @GetMapping(path = "/submitTransaction", produces = "application/json; charset=UTF-8")
    public String submitTransaction(@RequestParam String targetAccount, @RequestParam Long amount) throws Exception{
    	String response = "UNKNOWN";
    	//SDK example from purestake
        //final String DEST_ADDR = "ZHGZZQ2PIWYRK6MIK44GKO3VGQUC7NS2V3UQ63M3DIMFUFGI4BRWK7WDBU";
    	
    	final String DEST_ADDR = "THQHGD4HEESOPSJJYYF34MWKOI57HXBX4XR63EPBKCWPOJG5KUPDJ7QJCM";

        if( targetAccount == null || targetAccount.isBlank()) {
        	System.out.println("User did not pass target account so using default account");
        	targetAccount = DEST_ADDR;
        }

//    	String targetAccount = DEST_ADDR;
        TransactionParametersResponse params = client.TransactionParams().execute(headers, values).body();
        if( params != null ) {
        	System.out.println("Transaction Parameter Response: " + params.toString());
        }
        //Long amount = 23L;

        Transaction tx = Transaction.PaymentTransactionBuilder().sender(account.getAddress()).receiver(targetAccount).amount(amount).suggestedParams(params).build();
        SignedTransaction signedTx = account.signTransaction(tx);

        // send the transaction to the network
        try {
            String[] txHeaders = {"Content-Type","X-API-Key"};
            String[] txValues = {"application/x-binary","DTKOHdOBDs8OGekEmjH7R3tRkePSIhxC2ESNUXFf"};
            byte[] encodedTxBytes = Encoder.encodeToMsgPack(signedTx);
            PostTransactionsResponse txResponse = client.RawTransaction().rawtxn(encodedTxBytes).execute(txHeaders, txValues).body();
            System.out.println("Successfully sent tx with ID " + txResponse.txId);
            waitForConfirmation(client, txResponse.txId, headers, values);
            response = "SUCCESS: Transferred amount: " + amount + ", from Sender: " + account.getAddress().encodeAsString() + ", to Receiver: " + targetAccount;
        } catch (Exception e) {
            System.err.println("Exception when calling algod#rawTransaction: " + e);
            response = "Error while transferring amount: " + amount + ", from Sender: " + account.getAddress().encodeAsString() + 
            		", to Receiver: " + targetAccount;
        }
        return response;
    }
    
    private void waitForConfirmation(AlgodClient client, String txID, String[] headers, String[] values) throws Exception {
        Long lastRound = client.GetStatus().execute(headers, values).body().lastRound;
        while (true) {
            try {
                // Check the pending tranactions
                PendingTransactionResponse pendingInfo = client.PendingTransactionInformation(txID).execute(headers, values).body();
                if (pendingInfo.confirmedRound != null && pendingInfo.confirmedRound > 0) {
                    System.out.println("Transaction confirmed in round " + pendingInfo.confirmedRound);
                    break;
                }
                lastRound++;
                client.WaitForBlock(lastRound).execute(headers, values);
            } catch (Exception e) {
                throw (e);
            }
        }
    }
    
}
