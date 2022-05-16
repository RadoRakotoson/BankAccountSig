package com.kata.bankaccount;

import java.time.LocalDate;

public record Transaction(LocalDate date, Amount amount) {
}
