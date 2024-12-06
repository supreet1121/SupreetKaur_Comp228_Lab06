
public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        }
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: $" + amount + " (Insufficient funds)");
        }
    }

    public double getBalance() {
        return balance;
    }
}
