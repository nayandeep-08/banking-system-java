package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import service.transactions; // correct import

public abstract class Account implements Serializable {

    protected String accountNumber;
    protected double balance;

    // List to store transactions
    protected List<transactions> transactions = new ArrayList<>();

    // Constructor
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        balance += amount;

        // record transaction
        transactions.add(new transactions("DEPOSIT", amount, accountNumber));

        System.out.println("Deposited " + amount);
    }

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;

            // record transaction
            transactions.add(new transactions("WITHDRAW", amount, accountNumber));

            System.out.println("Withdrawn " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    // Show transactions
    public void showTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transactions yet");
            return;
        }

        for(transactions t : transactions){
            t.display();
        }
    }
}