package com.bankaccountscqrsdemo.bankaccountscqrsdemo.query.query;

import lombok.Data;

@Data
public class FindAccountByIdQuery {
    private String accountId;
    public FindAccountByIdQuery(String accountId) { this.accountId = accountId; }
}
