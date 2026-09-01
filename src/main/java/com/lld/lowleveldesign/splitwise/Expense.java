package com.lld.lowleveldesign.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double expenseAmount;
    private User paidBy;
    private ExpenseSplitType splitType;
    private List<User> userList;
    private List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.id = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidBy = paidByUser;
        this.splitType = splitType;
        this.splitDetails.addAll(splitDetails);

    }
}
