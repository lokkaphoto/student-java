package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void successfulWithdraw() {
        BankAccount acc = new BankAccount(100);
        acc.withdraw(40);
        assertEquals(60, acc.getBalance());
    }

    @Test
    void rejectsOverdraft() {
        BankAccount acc = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(150));
    }
}