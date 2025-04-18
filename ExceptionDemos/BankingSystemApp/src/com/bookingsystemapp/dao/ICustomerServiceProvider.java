package com.bookingsystemapp.dao;

public interface ICustomerServiceProvider {
	float getAccountBalance(long accountNumber);
    float deposit(long accountNumber, float amount);
    float withdraw(long accountNumber, float amount);
    void transfer(long fromAccount, long toAccount, float amount);
    void getAccountDetails(long accountNumber);
}
