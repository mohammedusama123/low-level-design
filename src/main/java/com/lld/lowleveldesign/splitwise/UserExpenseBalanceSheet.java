package com.lld.lowleveldesign.splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Balance> userVsBalance;
    private double totalExpense;
    private double totalPayment;
    private double totalOwe;
    private double totalGetBack;
    
    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        this.totalExpense = 0;
        this.totalPayment = 0;
        this.totalGetBack = 0;
        this.totalOwe = 0;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
