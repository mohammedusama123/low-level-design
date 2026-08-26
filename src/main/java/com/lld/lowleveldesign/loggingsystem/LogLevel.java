package com.lld.lowleveldesign.loggingsystem;

import lombok.Getter;

@Getter
public enum LogLevel {
    
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);
    
    private final int priority;
    
    LogLevel(int priority) {
        this.priority = priority;
    }
}
