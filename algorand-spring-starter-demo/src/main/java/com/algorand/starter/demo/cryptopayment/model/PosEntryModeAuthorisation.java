package com.algorand.starter.demo.cryptopayment.model;



public enum PosEntryModeAuthorisation {
	
	UNKNOWN("00"), MANUAL("01"), MAG_SWIPE("02"), BARCODE("03"), OCR("04"), CHIP("05"), CTLS_CHIP("07"), MIT_COF("10"), CHIP_FALLBACK("80"), ECOM("81"), CTLS_MAG_STRIPE_CVV("90"),
	CTLS_MAG_SWIPE_PIN("91"), CTLS_MAG_SWIPE_NO_PIN("92"), CTLS_NO_CVV("95"), CTLS_MAG_SIGNATURE("98"), SAME_ORIGINAL("99");

	private final String value;
	
	PosEntryModeAuthorisation(String pem){
		value = pem;
	}
	
	public String getValue() {
		return value;
	}	

}