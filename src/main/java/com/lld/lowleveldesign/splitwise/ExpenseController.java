package com.lld.lowleveldesign.splitwise;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }
    
    public Expense createExpense(String expenseId, String desc, double expenseAmount, User paidBy, List<Split> splitList, ExpenseSplitType splitType) {
        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplitObject(splitType);
        expenseSplit.validateExpenseSplit(splitList, expenseAmount);
        
        Expense expense = new Expense(expenseId, expenseAmount, desc, paidBy, splitType, splitList);
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitList, expenseAmount);
        return expense;
    }
}
