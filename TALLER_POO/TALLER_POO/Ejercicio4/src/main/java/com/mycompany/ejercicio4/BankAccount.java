/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio4;

/**
 *
 * @author sergi
 */
public class BankAccount {

    String accountNumber;
    String holderName;
    double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void showInfo() {
        System.out.println("-- Account Information --");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Holder:         " + holderName);
        System.out.println("Balance:        $" + balance);
    }

    // Método que modifica el estado del objeto
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " completed.");
        } else {
            System.out.println("The deposit amount must be greater than zero.");
        }
    }

    // Método que modifica el estado del objeto
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("The withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " completed.");
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("001-2345", "Carlos Perez", 500000.0);
        account1.showInfo();
        account1.deposit(150000.0);
        account1.withdraw(200000.0);
        account1.showInfo();
    }
}
