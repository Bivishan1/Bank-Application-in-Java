/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.controller.AccountController;
import com.mycompany.controller.UserController;
import java.util.Scanner;

/**
 *
 * @author ktbff
 */
public class MyMainView {

    ;
    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static AccountController ac = new AccountController();
    static UserController uc = new UserController();

    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false;
        while (!exit) {
            if (loginView()) {
                int ch;
                do {
                    System.out.println("Welcome!!!");
                    System.out.println("Enter respective number");
                    System.out.println("1) Add Account");
                    System.out.println("2)Check Balance");
                    System.out.println("3)Deposite Amount");
                    System.out.println("4)Withdraw Amount");
                    System.out.println("5)Transfer Amount");
                    System.out.println("6) Add User");
                    System.out.println("7) Delete User");
                    System.out.println("Press 0 to logout");

                    ch = sc.nextInt();
                    switch (ch) {
                        case 0:
                            break;
                        case 1:
                            addAccountView();
                            break;
                        case 2:
                            checkBalanceView();
                            break;
                        case 3:
                            depositeBalanceView();
                            break;
                        case 4:
                            withdrawBalanceView();
                            break;
                        case 5:
                            transferBalanceView();
                            break;
                        case 6:
                            addUserView();
                            break;
                        case 7:
                            deleteUserView();
                            break;

                        default:
                            System.out.println("Enter appropriate choice");
                    }
                } while (ch != 0);
            }
            System.out.println("Press any key to relogin and n to exit");
            char input = sc.next().charAt(0);
            if (input == 'n') {
                exit = true;
            }
        }
    }

    public static void addAccountView() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Account Name");
        String accountName = sc.next();
        System.out.println("Enter Account Opening Balance");
        int accountBalance = sc.nextInt();
        if (ac.addAccount(accountNumber, accountName, accountBalance)) {
            System.out.println("Account added Sucessfully");
        } else {
            System.out.println("Account already exist");
            ;
        }
    }

    public static void checkBalanceView() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        ac.checkBalance(accountNumber);
    }

    public static void depositeBalanceView() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Deposite Balance");
        int depositeBalance = sc.nextInt();
        if (ac.depositeAmount(accountNumber, depositeBalance)) {
            System.out.println("Deposite sucessful");
        } else {
            System.out.println("Account doesn't exist");
        }
    }

    public static void withdrawBalanceView() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Withdraw Balance");
        int withdrawBalance = sc.nextInt();
        int x = ac.withdrawAmount(accountNumber, withdrawBalance);
        if (x == 1) {
            System.out.println("Withdraw Sucessful");
        } else if (x == -1) {
            System.out.println("Insufficient Balance");
        } else {
            System.out.println("Account Doesn't exist");
        }
    }

    public static void transferBalanceView() {
        System.out.println("Enter  Sender Account Number");
        int accountNumber1 = sc.nextInt();
        System.out.println("Enter Reciever Account Number");
        int accountNumber2 = sc.nextInt();
        System.out.println("Enter trnsfer Balance");
        int transferBalance = sc.nextInt();
        int x = ac.transferAmount(accountNumber1, accountNumber2, transferBalance);
        if (x == 1) {
            System.out.println("Transfer Sucessful");
        } else if (x == -1) {
            System.out.println("Insufficient Balance");
        } else {
            System.out.println("Account Doesn't exist");
        }
    }

    public static boolean loginView() {
        System.out.println("Enter Username: ");
        String userName = sc.next();
        System.out.println("Enter Password: ");
        String passWord = sc.next();
        return uc.login(userName, passWord);

    }

    public static void addUserView() {
        System.out.println("Login again to add user");
        if (loginView()) {
            System.out.println("Enter new username");
            String userName = sc.next();
            System.out.println("Enter new password");
            String passWord = sc.next();
            System.out.println("Enter new password again");
            String temp = sc.next();
            if (passWord.equals(temp)) {
                if (uc.addUser(userName, passWord)) {
                    System.out.println("User added sucessfully");
                } else {
                    System.out.println("Username already exist");
                }
            } else {
                System.out.println("Password didn't match");
            }

        } else {
            System.out.println("Invalid Login");
        }
    }

    public static void deleteUserView() {
        System.out.println("Login again to delete user");
        if (loginView()) {
            System.out.println("Enter username to delete");
            String userName = sc.next();
            if (uc.deleteUser(userName)) {
                System.out.println("Username deleted");
            } else {
                System.out.println("Username doesn't exist");
            }
        }
    }

}
