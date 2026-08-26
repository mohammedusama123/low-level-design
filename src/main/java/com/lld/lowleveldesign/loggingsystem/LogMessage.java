package com.lld.lowleveldesign.loggingsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class LogMessage {
    private LogLevel level;
    private String message;
    private LocalDateTime logTime;
    private String threadName;
    private Throwable exception;
    private String loggerName;
    
}
