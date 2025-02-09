import java.util.Scanner;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% yearly interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit = 5000; // Overdraft limit for current accounts

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for Current Accounts
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved.");
        } else {
            System.out.println("Loan denied due to low balance.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 2000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Savings Account
        System.out.println("Enter Savings Account details:");
        System.out.print("Account Number: ");
        String savAccNumber = scanner.next();
        System.out.print("Holder Name: ");
        String savHolder = scanner.next();
        System.out.print("Initial Balance: ");
        double savBalance = scanner.nextDouble();
        SavingsAccount savings = new SavingsAccount(savAccNumber, savHolder, savBalance);

        // Creating a Current Account
        System.out.println("\nEnter Current Account details:");
        System.out.print("Account Number: ");
        String curAccNumber = scanner.next();
        System.out.print("Holder Name: ");
        String curHolder = scanner.next();
        System.out.print("Initial Balance: ");
        double curBalance = scanner.nextDouble();
        CurrentAccount current = new CurrentAccount(curAccNumber, curHolder, curBalance);

        System.out.println("\nProcessing Accounts...");
        processAccount(savings);
        processAccount(current);

        System.out.print("\nEnter deposit amount for Savings Account: ");
        double depositAmount = scanner.nextDouble();
        savings.deposit(depositAmount);

        System.out.print("\nEnter withdrawal amount for Current Account: ");
        double withdrawAmount = scanner.nextDouble();
        current.withdraw(withdrawAmount);

        System.out.print("\nEnter loan amount for Current Account: ");
        double loanAmount = scanner.nextDouble();
        current.applyForLoan(loanAmount);

        scanner.close();
    }

    public static void processAccount(BankAccount account) {
        account.displayDetails();
        System.out.println("Yearly Interest Earned: $" + account.calculateInterest());
        System.out.println("----------------------------");
    }
}
