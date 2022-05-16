package com.kata.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transactions {

    private final List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }


    public String printStatement() {

        StringBuilder builder = new StringBuilder();

        transactions.forEach(transaction -> builder
                .insert(0, "\n")
                .insert(0, transaction.printStatement().trim()));

        return builder.toString();
    }

}
