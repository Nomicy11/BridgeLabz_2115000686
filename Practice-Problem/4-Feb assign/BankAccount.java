class BankAccount{
	private static String BankName = "Nexus Bank";
	private static int totalAccount = 0;
	
	private final int AccountNumber;
	private String AccountHolderName;
	private double balance;
	
	 public BankAccount(int AccountNumber, String AccountHolderName , double initialBalance){
		
		this.AccountNumber = AccountNumber;
		this.AccountHolderName = AccountHolderName;
		this.balance = initialBalance;
		totalAccount++;
	}
	public static int totalAccounts(){
		return totalAccount;
	}
	
	public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: INR" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
		System.out.println("Current Balance:"+balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: INR" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
		System.out.println("Current Balance:"+balance);
    }
	
	public void display(){
		if(this instanceof BankAccount)
		System.out.println("Account Number: "+this.AccountNumber);
		System.out.println("Account Holder Name: "+this.AccountHolderName);
		System.out.println("Account Balance: "+this.balance);
		
	}
	
	public static void main(String[] args){
		BankAccount obj = new BankAccount(111203,"Nomicy Gupta",1000);
		
		obj.withdraw(898);
		obj.display();
		obj.deposit(1000);
		
	}
	
	
}