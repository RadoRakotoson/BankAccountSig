package com.kata.bankaccount;

import java.time.LocalDate;

public class TransactionTestUtils {
    public static Transaction getTransaction(Amount amount, String date, TransactionType transactionType) {
        return new Transaction(LocalDate.parse(date), amount, transactionType, amount);
    }

    public static Transaction getTransaction(Amount amount, String date, TransactionType transactionType, Amount balance) {
        return new Transaction(LocalDate.parse(date), amount, transactionType, balance);
    }
}
