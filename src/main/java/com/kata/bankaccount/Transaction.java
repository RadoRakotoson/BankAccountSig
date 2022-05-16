package com.kata.bankaccount;

import java.time.LocalDate;

public record Transaction(LocalDate date, Amount amount, TransactionType transactionType, Amount balance) {

    public com.kata.bankaccount.Transaction setBalance(Amount balance) {
        return new com.kata.bankaccount.Transaction(date, amount, transactionType, balance);
    }

}
