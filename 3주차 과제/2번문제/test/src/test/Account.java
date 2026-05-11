package test;

public class Account {
    private double balance;

    public Account(String ownerName, double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액 부족");
        }
    }

    public double getBalance() {
        return balance;
    }
}
