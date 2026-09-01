package com.lld.lowleveldesign.splitwise;

public class User {
    private String id;
    private String name;
    private UserExpenseBalanceSheet balanceSheet;
    
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.balanceSheet = new UserExpenseBalanceSheet();
    }
    public String getUserId() {
        return id;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return balanceSheet;
    }
}
