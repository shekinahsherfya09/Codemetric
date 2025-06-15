import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private double balance;

    public Account(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Amount deposited successfully.");
        } else {
            System.out.println(" Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(" Withdrawal successful.");
        }
    }

    public void checkBalance() {
        System.out.printf("Account Holder: %s | Balance: ₹%.2f%n", accountHolderName, balance);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        int currentAccountIndex = -1;

        while (true) {
            System.out.println("\n======= Basic Banking System =======");
            System.out.println("1. Create New Account");
            System.out.println("2. Switch Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. List All Accounts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // clear newline

            switch (option) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: ₹");
                    double initial = scanner.nextDouble();
                    scanner.nextLine();
                    accounts.add(new Account(name, initial));
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available to switch.");
                    } else {
                        System.out.println("Available accounts:");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.printf("%d. %s%n", i + 1, accounts.get(i).getAccountHolderName());
                        }
                        System.out.print("Enter account number to switch: ");
                        int idx = scanner.nextInt() - 1;
                        if (idx >= 0 && idx < accounts.size()) {
                            currentAccountIndex = idx;
                            System.out.println(" Switched to account: " + accounts.get(currentAccountIndex).getAccountHolderName());
                        } else {
                            System.out.println(" Invalid account number.");
                        }
                    }
                    break;

                case 3:
                    if (currentAccountIndex == -1) {
                        System.out.println(" No account selected. Please switch first.");
                    } else {
                        System.out.print("Enter amount to deposit: ₹");
                        double deposit = scanner.nextDouble();
                        scanner.nextLine();
                        accounts.get(currentAccountIndex).deposit(deposit);
                    }
                    break;

                case 4:
                    if (currentAccountIndex == -1) {
                        System.out.println(" No account selected. Please switch first.");
                    } else {
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdraw = scanner.nextDouble();
                        scanner.nextLine();
                        accounts.get(currentAccountIndex).withdraw(withdraw);
                    }
                    break;

                case 5:
                    if (currentAccountIndex == -1) {
                        System.out.println(" No account selected. Please switch first.");
                    } else {
                        accounts.get(currentAccountIndex).checkBalance();
                    }
                    break;

                case 6:
                    if (accounts.isEmpty()) {
                        System.out.println(" No accounts created yet.");
                    } else {
                        System.out.println("📋 All Accounts:");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.printf("%d. %s%n", i + 1, accounts.get(i).getAccountHolderName());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the banking system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
