package com.bankaccountscqrsdemo.bankaccountscqrsdemo.query.repository;

import com.bankaccountscqrsdemo.bankaccountscqrsdemo.query.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
