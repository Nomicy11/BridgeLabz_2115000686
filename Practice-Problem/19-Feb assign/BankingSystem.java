import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>(); 
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>(); 
    private Queue<String> withdrawalQueue = new LinkedList<>();

   
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

  
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal of " + amount + " processed for account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account: " + accountNumber);
            }
        }
    }

   
    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        
        bank.createAccount("123", 5000.0);
        bank.createAccount("456", 3000.0);
        bank.createAccount("789", 7000.0);

  
        bank.deposit("456", 1000.0);

       
        bank.requestWithdrawal("123");
        bank.requestWithdrawal("456");

      
        bank.processWithdrawals(2000.0);

        
        bank.displaySortedAccounts();
    }
}
