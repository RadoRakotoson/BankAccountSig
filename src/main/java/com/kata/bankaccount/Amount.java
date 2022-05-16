package com.kata.bankaccount;

import java.text.DecimalFormat;

public record Amount(int value) {

    public Amount plus(Amount toAdd) {
        return new Amount(this.value + toAdd.value());
    }

    public Amount subtract(Amount toRetrieve) {
        return new Amount(this.value - toRetrieve.value());
    }

    public String toDouble() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(value).replace(",", ".");
    }
}
