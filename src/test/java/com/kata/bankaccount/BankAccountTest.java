package com.kata.bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static com.kata.bankaccount.TransactionType.CREDIT;
import static com.kata.bankaccount.TransactionType.DEBIT;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @ParameterizedTest
    @ValueSource(ints = {2000, 450, 900})
    void specified_amount_should_be_add_to_current_balance(int amount) {
        Account account = new Account();
        Amount depositAmount = new Amount(amount);

        account.deposit(getTransaction(depositAmount, "2022-04-10", CREDIT));

        assertThat(account.getBalance()).isEqualTo(depositAmount);
    }


    @ParameterizedTest
    @CsvSource({"700,300", "250,750", "900,100"})
    void specified_amount_should_be_retrieve_to_current_balance(int amount, int expectAmountValue) {
        Account account = new Account();
        Amount initialAmount = new Amount(1000);
        Amount withdrawalAmount = new Amount(amount);

        account.deposit(getTransaction(initialAmount, "2022-04-10", CREDIT));
        account.withdrawal(getTransaction(withdrawalAmount, "2022-04-11", DEBIT));

        assertThat(account.getBalance()).isEqualTo(new Amount(expectAmountValue));
    }

    @Test
    void current_balance_must_be_changed_after_each_transaction() {
        Account account = new Account();
        Amount depositAmount = new Amount(200);
        Amount lastDepositAmount = new Amount(1200);
        Amount balanceDeposit = depositAmount.plus(lastDepositAmount);

        account.deposit(getTransaction(depositAmount, "2012-02-10", CREDIT));
        account.deposit(getTransaction(lastDepositAmount, "2012-02-11", CREDIT));

        assertThat(account.getBalance()).isEqualTo(balanceDeposit);
    }

    private Transaction getTransaction(Amount amount, String date, TransactionType transactionType) {
        return new Transaction(LocalDate.parse(date), amount, transactionType, amount);
    }


}