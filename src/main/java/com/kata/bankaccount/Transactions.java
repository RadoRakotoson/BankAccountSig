package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private final List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
