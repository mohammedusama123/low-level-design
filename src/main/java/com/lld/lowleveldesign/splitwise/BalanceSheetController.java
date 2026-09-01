package com.lld.lowleveldesign.splitwise;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {

        //update the total amount paid of the expense paid by user
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for (Split split : splits) {

            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getOweAmount();

            if (expensePaidBy.getUserId().equals(userOwe.getUserId())) {
                paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalExpense() + oweAmount);
            } else {

                //update the balance of paid user
                paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalGetBack() + oweAmount);

                Balance userOweBalance;
                if (paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                } else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }

                userOweBalance.setTotalGetBack(userOweBalance.getTotalGetBack() + oweAmount);


                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalExpense(oweUserExpenseSheet.getTotalOwe() + oweAmount);
                oweUserExpenseSheet.setTotalExpense(oweUserExpenseSheet.getTotalExpense() + oweAmount);

                Balance userPaidBalance;
                if (oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())) {
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setTotalOwe(userPaidBalance.getTotalOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getTotalGetBack() + " YouOwe:" + balance.getTotalOwe());
        }

        System.out.println("---------------------------------------");

    }

}
