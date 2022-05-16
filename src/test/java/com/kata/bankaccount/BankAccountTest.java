package com.kata.bankaccount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @ParameterizedTest
    @ValueSource(ints = {2000, 450, 900})
    void specified_amount_should_be_add_to_current_balance(int amount) {
        Account account = new Account();
        Amount depositAmount = new Amount(amount);

        account.deposit(depositAmount);

        assertThat(account.getBalance()).isEqualTo(depositAmount);
    }


    @ParameterizedTest
    @CsvSource({"700,300", "250,750", "900,100"})
    void specified_amount_should_be_retrieve_to_current_balance(int amount, int expectAmountValue) {
        Account account = new Account();
        account.deposit(new Amount(1000));

        account.withdrawal(new Amount(amount));

        assertThat(account.getBalance()).isEqualTo(new Amount(expectAmountValue));
    }


}