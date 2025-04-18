package com.bookingsystemapp.model;

public class CurrentAccount extends BankAccount {
	private final float overdraftLimit = 5000f;

    public CurrentAccount(long accountNumber, float balance, Customer customer) {
        super(accountNumber, "Current", balance, customer);
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(float amount) {
        if ((balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " (Overdraft Applied if needed)");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public float calculateInterest() {
        System.out.println("No interest for Current Account.");
        return 0;
    }
	
}
