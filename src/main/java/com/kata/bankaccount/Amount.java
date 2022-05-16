package com.kata.bankaccount;

public record Amount(int value) {

    public Amount plus(Amount toAdd) {
        return new Amount(this.value + toAdd.value());
    }

    public Amount subtract(Amount toRetrieve) {
        return new Amount(this.value - toRetrieve.value());
    }

}
