package com.kata.bankaccount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @ParameterizedTest
    @ValueSource(ints = {2000, 450, 900})
    void specified_amount_should_be_add_to_current_balance(int amount) {
        Account account = new Account();
        account.deposit(amount);
        assertThat(account.getBalance()).isEqualTo(amount);
    }

}