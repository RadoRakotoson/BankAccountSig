package com.kata.bankaccount;

public class Account {
    private Amount balance = new Amount(0);

    public void deposit(Amount depositAmount) {
        this.balance = this.balance.plus(depositAmount);
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdrawal(Amount withdrawalAmount) {
        this.balance = this.balance.subtract(withdrawalAmount);
    }
}
