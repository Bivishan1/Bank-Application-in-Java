/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Accounts;
import java.util.ArrayList;

/**
 *
 * @author ktbff
 */
public class AccountController {

    ArrayList<Accounts> accounts = new ArrayList<>();

    public boolean addAccount(int accountNumber, String accountName, int accountBalance) {
        Accounts acc = new Accounts(accountNumber, accountName, accountBalance);
        if (findAccount(accountNumber) == null) {
            accounts.add(acc);
            return true;
        }
        return false;
    }

    public Accounts findAccount(int accountNumber) {
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public void checkBalance(int accountNumber) {
        if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            System.out.println("Balance is :" + acc.getAccountBalance());
        } else {
            System.out.println("Account doesn't exist");
        }
    }

    public boolean depositeAmount(int accountNumber, int depositeBalance) {
        if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            acc.setAccountBalance(acc.getAccountBalance() + depositeBalance);
            return true;
        }
        return false;
    }

    public int withdrawAmount(int accountNumber, int withdrawBalance) {
        if (findAccount(accountNumber) != null) {
            Accounts acc = findAccount(accountNumber);
            if (acc.getAccountBalance() > withdrawBalance) {
                acc.setAccountBalance(acc.getAccountBalance() - withdrawBalance);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public int transferAmount(int senderAccountNumber, int receiverAccountNumber, int transferBalance) {
        if ((findAccount(senderAccountNumber) != null) && (findAccount(receiverAccountNumber) != null)) {
            Accounts acc1 = findAccount(senderAccountNumber);
            Accounts acc2 = findAccount(receiverAccountNumber);
            if (acc1.getAccountBalance() > transferBalance) {
                acc1.setAccountBalance(acc1.getAccountBalance() - transferBalance);
                acc2.setAccountBalance(acc2.getAccountBalance() + transferBalance);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
