package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private final List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }


    public String printStatement() {

        StringBuilder builder = new StringBuilder();

        transactions.forEach(transaction -> builder
                .insert(0, "\n")
                .insert(1, transaction.printStatement().trim()));

        return builder.toString();
    }

}
