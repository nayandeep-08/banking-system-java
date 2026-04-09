package main;

import model.*;
import java.util.*;
import utils.fileHandler;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ✅ Load data (only once)
        HashMap<String, User> users = fileHandler.loadData();

        while (true) {

            System.out.println("\n1. Create User");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Show Transactions");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = sc.next();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Password: ");
                    String password = sc.next();

                    User newUser = new User(userId, name, password);
                    users.put(userId, newUser);

                    System.out.println("User created successfully!");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String uid = sc.next();

                    if (!users.containsKey(uid)) {
                        System.out.println("User not found!");
                        break;
                    }

                    User existingUser = users.get(uid);

                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");

                    int type = sc.nextInt();

                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();

                    Account acc;

                    if (type == 1) {
                        acc = new SavingsAccount(accNo);
                    } else {
                        acc = new currentaccount(accNo);
                    }

                    existingUser.addAccount(acc);
                    System.out.println("Account created successfully!");
                    break;

                case 3:
                    Account depositAcc = findAccount(sc, users);
                    if (depositAcc == null) break;

                    System.out.print("Enter Amount: ");
                    double depositAmount = sc.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    depositAcc.deposit(depositAmount);
                    break;

                case 4:
                    Account withdrawAcc = findAccount(sc, users);
                    if (withdrawAcc == null) break;

                    System.out.print("Enter Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    withdrawAcc.withdraw(withdrawAmount);
                    break;

                case 5:
                    Account balanceAcc = findAccount(sc, users);
                    if (balanceAcc == null) break;

                    System.out.println("Balance: " + balanceAcc.getBalance());
                    break;

                case 6:
                    Account txAcc = findAccount(sc, users);
                    if (txAcc == null) break;

                    txAcc.showTransactions();
                    break;

                case 7:
                    // ✅ SAVE DATA BEFORE EXIT
                    fileHandler.saveData(users);
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static Account findAccount(Scanner sc, HashMap<String, User> users) {

        System.out.print("Enter User ID: ");
        String userId = sc.next();

        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return null;
        }

        User user = users.get(userId);

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        for (Account acc : user.getAccounts()) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }

        System.out.println("Account not found!");
        return null;
    }
}