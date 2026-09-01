package com.lld.lowleveldesign.splitwise;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public void validateExpenseSplit(List<Split> splitList, double totalAmount) {
        double amountToBePaidByEachUser = totalAmount / splitList.size();
        for(Split split: splitList) {
            if(split.getOweAmount() != amountToBePaidByEachUser) {
                //throw exception
            }
        }
    }
}
