package com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.dto;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawalRequest {
    private String accountId;
    private BigDecimal amount;
}
