package com.financemanagementapp.entity;

public class ExpenseCategory {
	private int categoryId;
    private String categoryName;
	public ExpenseCategory() {
		super();
	}
	public ExpenseCategory(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "ExpenseCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
    
}
