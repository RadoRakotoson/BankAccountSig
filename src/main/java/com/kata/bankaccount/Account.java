package com.kata.bankaccount;

public class Account {
    private int balance = 0;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amount) {
        this.balance -= amount;
    }
}
