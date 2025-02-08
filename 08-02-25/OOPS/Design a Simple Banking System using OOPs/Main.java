class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;

  public BankAccount(String accountNumber, String accountHolderName, double balance) {
      this.accountNumber = accountNumber;
      this.accountHolderName = accountHolderName;
      this.balance = balance;
  }

  public void deposit(double amount) {
      if (amount > 0) {
          balance += amount;
          System.out.println("Rs. " + amount + " deposited successfully.");
      } else {
          System.out.println("Invalid deposit amount.");
      }
  }

  public void withdraw(double amount) {
      if (amount > 0 && amount <= balance) {
          balance -= amount;
          System.out.println("Rs. " + amount + " withdrawn successfully.");
      } else {
          System.out.println("Insufficient balance or invalid amount.");
      }
  }

  public void checkBalance() {
      System.out.println("Current Balance: Rs. " + balance);
  }
}

public class Main {
  public static void main(String[] args) {
      BankAccount myAccount = new BankAccount("123456789", "Gagan Chauhan", 5000);

      myAccount.checkBalance();
      myAccount.deposit(2000);
      myAccount.withdraw(3000);
      myAccount.checkBalance();
  }
}
