package com.kata.bankaccount;

import java.time.LocalDate;

public class InMemoryClock implements Clock {

    private LocalDate now = LocalDate.now();

    public void setNow(LocalDate date) {
        this.now = date;
    }

    @Override
    public LocalDate now() {
        return now;
    }
}
