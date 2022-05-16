package com.kata.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static com.kata.bankaccount.TransactionType.CREDIT;
import static com.kata.bankaccount.TransactionType.DEBIT;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    private Account newAccount;

    @BeforeEach
    void setUp() {
        newAccount = new Account();
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 450, 900})
    void specified_amount_should_be_add_to_current_balance(int amount) {
        Amount depositAmount = new Amount(amount);

        newAccount.deposit(getTransaction(depositAmount, "2022-04-10", CREDIT));

        assertThat(newAccount.getBalance()).isEqualTo(depositAmount);
    }


    @ParameterizedTest
    @CsvSource({"700,300", "250,750", "900,100"})
    void specified_amount_should_be_retrieve_to_current_balance(int amount, int expectAmountValue) {
        Amount initialAmount = new Amount(1000);
        Amount withdrawalAmount = new Amount(amount);

        newAccount.deposit(getTransaction(initialAmount, "2022-04-10", CREDIT));
        newAccount.withdrawal(getTransaction(withdrawalAmount, "2022-04-11", DEBIT));

        assertThat(newAccount.getBalance()).isEqualTo(new Amount(expectAmountValue));
    }

    @Test
    void current_balance_must_be_changed_after_each_transaction() {
        Amount depositAmount = new Amount(200);
        Amount lastDepositAmount = new Amount(1200);
        Amount balanceDeposit = depositAmount.plus(lastDepositAmount);

        newAccount.deposit(getTransaction(depositAmount, "2012-02-10", CREDIT));
        newAccount.deposit(getTransaction(lastDepositAmount, "2012-02-11", CREDIT));

        assertThat(newAccount.getBalance()).isEqualTo(balanceDeposit);
    }

    @Test
    void header_only_shown_when_no_operation_initialized() {
        assertThat(newAccount.printStatement()).isEqualTo("date || debit || credit || balance");
    }

    private Transaction getTransaction(Amount amount, String date, TransactionType transactionType) {
        return new Transaction(LocalDate.parse(date), amount, transactionType, amount);
    }


    @Test
    void must_show_one_operation_when_one_transaction_initialized() {
        Amount depositAmount = new Amount(1000);

        newAccount.deposit(getTransaction(depositAmount, "2012-01-10", CREDIT));

        assertThat(newAccount.printStatement())
                .isEqualTo("date || debit || credit || balance\n10-01-2012 ||  || 1000.00 || 1000.00");
    }

    @Test
    void print_all_operations_initialized() {
        newAccount.deposit(getTransaction(new Amount(1000), "2012-01-10", CREDIT));
        newAccount.deposit(getTransaction(new Amount(2000), "2012-01-13", CREDIT));
        newAccount.withdrawal(getTransaction(new Amount(500), "2012-01-14", DEBIT));

        String statement = newAccount.printStatement();

        assertThat(statement)
                .isEqualTo("""
                        date || debit || credit || balance
                        14-01-2012 || 500.00 ||  || 2500.00
                        13-01-2012 ||  || 2000.00 || 3000.00
                        10-01-2012 ||  || 1000.00 || 1000.00""");
    }

}