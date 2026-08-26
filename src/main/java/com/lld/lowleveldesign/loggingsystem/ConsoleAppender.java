package com.lld.lowleveldesign.loggingsystem;

public class ConsoleAppender implements Appender {
    
    private Formatter formatter;
    
    public ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }
    
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }
}
