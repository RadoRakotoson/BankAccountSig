package com.kata.bankaccount;

import java.time.LocalDate;

public record Transaction(LocalDate date, Amount amount, TransactionType transactionType, Amount balance) {

    public com.kata.bankaccount.Transaction setBalance(Amount balance) {
        return new com.kata.bankaccount.Transaction(date, amount, transactionType, balance);
    }

    public String printStatement() {
        Amount amount = this.amount;
        String date = this.date.getDayOfMonth() + "-" + String.format("%02d", this.date.getMonthValue()) + "-" + this.date.getYear();

        String transaction = (this.transactionType == TransactionType.DEBIT ? amount + " || " : " || " + amount);
        return date.trim() + " || " + transaction + " || " + balance;
    }

}
