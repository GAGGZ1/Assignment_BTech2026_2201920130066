### README - Simple Banking System

**Project Name**: Simple Banking System using OOP Principles

---

**Description**:  
A simple Banking System implemented using Object-Oriented Programming (OOP) concepts. This system allows a user to:
- Create a bank account with an account number, account holder name, and balance.
- Deposit and withdraw money.
- Check the current balance.
- Ensure withdrawal does not exceed the available balance.

---

**Features**:
- **Deposit**: Adds money to the account.
- **Withdraw**: Removes money from the account with balance check.
- **Check Balance**: Displays the current balance of the account.

---

**OOP Concepts Used**:
1. **Encapsulation**: The `balance` is kept private, and it can only be accessed or modified through methods like `deposit()`, `withdraw()`, and `checkBalance()`.
2. **Abstraction**: Only essential methods for banking operations are exposed.
3. **Modularity**: The `BankAccount` class encapsulates all the banking logic, promoting clean and reusable code.

---

**Java Implementation**:  
```java
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
```

---

**How to Use**:
1. Create a `BankAccount` object with initial details.
2. Call `deposit()`, `withdraw()`, and `checkBalance()` methods for transactions and balance checks.

---

**Technologies Used**:
- Java

---