package com.financemanagementapp.dao;

import java.util.List;

import com.financemanagementapp.entity.Expense;
import com.financemanagementapp.entity.User;

public interface IFinanceRepository {
	void createUser(User user);
    void deleteUser(int userId);
    void createExpense(Expense expense);
    void deleteExpense(int expenseId);
    List<Expense> getAllExpenses(int userId);
    void updateExpense(int userId, Expense expense);
}
