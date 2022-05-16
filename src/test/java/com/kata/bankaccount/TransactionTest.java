package com.kata.bankaccount;

import org.junit.jupiter.api.Test;

import static com.kata.bankaccount.TransactionTestUtils.getTransaction;
import static com.kata.bankaccount.TransactionType.CREDIT;
import static com.kata.bankaccount.TransactionType.DEBIT;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionsTest {

    @Test
    void must_print_all_transaction() {
        Transactions transactions = new Transactions();
        Amount depositAmount = new Amount(1000);
        Amount withdrawalAmount = new Amount(1000);

        transactions.add(getTransaction(depositAmount, "2020-02-10", CREDIT));
        transactions.add(getTransaction(depositAmount, "2020-02-14", DEBIT, depositAmount.subtract(withdrawalAmount)));

        String operationList = """
                
                14-02-2020 || 1000.00 ||  || 0.00
                10-02-2020 ||  || 1000.00 || 1000.00""";
        assertThat(transactions.printStatement()).isEqualTo(operationList);
    }

}
