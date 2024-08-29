package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {


        if (accounts.containsKey(account) && amount > 0) {
            int value = accounts.get(account);
            accounts.put(account,value + amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount){
        if (accounts.containsKey(account) && amount > 0 && accounts.get(account) > 0 && amount <= accounts.get(account)) {
            int value = accounts.get(account);
            accounts.put(account, value - amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String account_1, String account_2, int amount) {
        if (accounts.containsKey(account_1) && accounts.containsKey(account_2) && amount > 0 && accounts.get(account_1) > 0 && account_1 != account_2 && amount <= accounts.get(account_1)) {

            accounts.put(account_1, accounts.get(account_1) - amount);
            accounts.put(account_2, accounts.get(account_2) + amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

}