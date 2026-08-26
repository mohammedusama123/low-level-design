package com.lld.lowleveldesign.loggingsystem;

public interface Appender {
    
    void append(LogMessage logMessage);
}
