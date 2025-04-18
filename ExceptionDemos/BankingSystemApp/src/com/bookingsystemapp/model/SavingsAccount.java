package com.bookingsystemapp.model;

public class SavingsAccount extends BankAccount {
	private float interestRate;

    public SavingsAccount(long accountNumber, float balance, float interestRate, Customer customer) {
        super(accountNumber, "Savings", balance, customer);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    @Override
    public float calculateInterest() {
        float interest = (balance * interestRate) / 100;
        System.out.println("Interest: $" + interest);
        return interest;
    }
}
