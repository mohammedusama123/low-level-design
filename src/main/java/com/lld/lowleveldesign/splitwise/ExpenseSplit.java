package com.lld.lowleveldesign.splitwise;

import java.util.List;

public interface ExpenseSplit {
    
    void validateExpenseSplit(List<Split> splitList, double totalAmount);
}
