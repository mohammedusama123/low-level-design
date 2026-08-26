package com.lld.lowleveldesign.loggingsystem;

public class SimpleFormatter implements Formatter {
    @Override
    public String format(LogMessage logMessage) {
        return String.format(
                "%s [%s] [%s] [%s]",
                logMessage.getLevel(),
                logMessage.getMessage(),
                logMessage.getLogTime(),
                logMessage.getThreadName()
        );
    }
}
