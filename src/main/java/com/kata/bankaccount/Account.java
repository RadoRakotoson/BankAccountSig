package com.kata.bankaccount;

public class Account {
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
}
