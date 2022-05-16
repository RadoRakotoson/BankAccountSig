package com.kata.bankaccount;

import static com.kata.bankaccount.TransactionType.CREDIT;

public class Account {
    private static final String HEADER = "date || debit || credit || balance";
    private Amount balance = new Amount(0);

    private final Transactions transactions = new Transactions();
    private final Clock clock;

    public Account(Clock clock) {
        this.clock = clock;
    }

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


    public void deposit(Amount amount) {
        Transaction transaction = new Transaction(clock.now(), amount, CREDIT, balance.plus(amount));
        deposit(transaction);
    }

    public Transaction getTransaction(int index) {
        return transactions.getBy(index);
    }
}
