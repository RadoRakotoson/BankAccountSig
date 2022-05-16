package com.kata.bankaccount;

public class Account {
    private static final String HEADER = "date || debit || credit || balance";
    private Amount balance = new Amount(0);

    private final Transactions transactions = new Transactions();

    public void deposit(Transaction transaction) {
        this.balance = this.balance.plus(transaction.amount());
        transactions.add(transaction.setBalance(this.balance));
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdrawal(Transaction transaction) {
        this.balance = this.balance.subtract(transaction.amount());
        transactions.add(transaction.setBalance(this.balance));
    }

    public String printStatement() {
        return HEADER + transactions.printStatement();
    }
}
