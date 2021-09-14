package com.algorand.starter.demo.cryptopayment.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypoint {

    @NotNull
    @Size(min = 8, max = 10)
    private String paypointId;
    @NotNull
    @Size(min = 2, max = 2)
    private String countryCode;
    @NotNull
    @Size(min = 1, max = 256)
    private String deviceSerialNumber;
    @NotNull
    private PayPointTerminalType terminalType;
    @Size(min = 6, max = 6)
    private String capabilities;
}