package com.lld.lowleveldesign.splitwise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Split {
    
    private User user;
    private double oweAmount;
}
