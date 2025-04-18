package com.financemanagementapp.main;

import com.financemanagementapp.dao.FinanceRepositoryImpl;
import com.financemanagementapp.dao.IFinanceRepository;
import com.financemanagementapp.entity.User;

public class FinanceApp {
    public static void main(String[] args) {
        

        IFinanceRepository finance = new FinanceRepositoryImpl();
        User user = new User(4, "ramya", "ramya@10", "ramya@gmail.com");
        finance.createUser(user);
        IFinanceRepository finance1 = new FinanceRepositoryImpl();
        finance1.deleteUser(2);
    }
}


