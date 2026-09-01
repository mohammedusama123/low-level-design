package com.lld.lowleveldesign.splitwise;

public class ExpenseSplitFactory {
    
    public static ExpenseSplit getExpenseSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case EQUAL -> {
                return new EqualExpenseSplit();
            }
            case UNEQUAL -> {
                return new UnequalExpenseSplit();
            }
            case PERCENTAGE -> {
                return new PercentageExpenseSplit();
            }
            default -> {
                return null;
            }
        }
    }
}
