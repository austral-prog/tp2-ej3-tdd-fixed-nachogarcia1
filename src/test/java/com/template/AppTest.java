package com.template;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    Map<String, Integer> accounts = new HashMap<>(){{
        put("mati", 10);
        put("juan", 20);
    }};


    @Test
    void testDeposit() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit2() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "Jose", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDepositnullnumber() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 0);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDepositinvalidnumber() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -4);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit3() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 20);
        assertEquals(30, updatedAccounts.get("mati"));
    }



    @Test
    void testrwithdrawmati1() {
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }

    @Test
    void testwithdrawmati2() {
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 20);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testwithdrawinvalidamount() {
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", -10);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testwithdrawinvalidname() {
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Jose", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testwithdrawjuan() {
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 5);
        assertEquals(15, updatedAccounts.get("juan"));
    }



    @Test
    void testTransfer() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "mati", 10);
        assertEquals(10, updatedAccounts.get("juan"));
        assertEquals(20, updatedAccounts.get("mati"));
    }

    @Test
    void testTransfer2() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 10);
        assertEquals(30, updatedAccounts.get("juan"));
        assertEquals(0, updatedAccounts.get("mati"));
    }

    @Test
    void testTransfer3() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "jose", "mati", 10);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferirinvalidamount() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "mati", -10);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferir5() {
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "mati", 100);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }


}
