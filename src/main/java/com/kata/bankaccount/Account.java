package com.kata.bankaccount;

public class Account {
    private static final String HEADER = "date || amount || balance";
    private Amount balance = new Amount(0);

    private final Transactions transactions = new Transactions();

    public void deposit(Transaction transaction) {
        this.balance = this.balance.plus(transaction.amount());
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdrawal(Transaction transaction) {
        this.balance = this.balance.subtract(transaction.amount());
    }

    public String printStatement() {
        return HEADER + transactions.printStatement();
    }
}
