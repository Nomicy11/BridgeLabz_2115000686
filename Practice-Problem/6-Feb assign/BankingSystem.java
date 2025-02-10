class BankAccount {
    public String accountNumber;
    public double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

  
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}


class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}


class FixedDepositAccount extends BankAccount {
    private int maturityPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }


    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}


public class BankingSystem {
    public static void main(String[] args) {
    
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 3.5);
        savings.displayAccountDetails();
        savings.displayAccountType();
        System.out.println("----------------------");

        CheckingAccount checking = new CheckingAccount("CA98765", 3000, 1000);
        checking.displayAccountDetails();
        checking.displayAccountType();
        System.out.println("----------------------");

        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD45678", 10000, 12);
        fixedDeposit.displayAccountDetails();
        fixedDeposit.displayAccountType();
    }
}
