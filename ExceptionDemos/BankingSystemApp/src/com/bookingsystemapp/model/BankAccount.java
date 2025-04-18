package com.bookingsystemapp.model;

public abstract class BankAccount {
	protected long accountNumber;
    protected String accountType;
    protected float balance;
    protected Customer customer;

    public BankAccount() {}

    public BankAccount(long accountNumber, String accountType, float balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public abstract void deposit(float amount);
    public abstract void withdraw(float amount);
    public abstract float calculateInterest();

    public void printAccountInfo() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        if (customer != null) {
            customer.printCustomerInfo();
        }
    }
}
