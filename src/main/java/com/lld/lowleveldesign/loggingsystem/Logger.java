package com.lld.lowleveldesign.loggingsystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
    private LogLevel minLogLevel;
    private List<Appender> appenders;
    private BlockingQueue<LogMessage> blockingQueue;
    private Thread workerThread;
    private volatile boolean running;
    
    public Logger(LogLevel minLogLevel, List<Appender> appender) {
        this.minLogLevel = minLogLevel;
        this.appenders = appender;
        this.blockingQueue = new LinkedBlockingQueue<>(10_000);
        this.workerThread = new Thread(this::processLogs, "worker thread");
        this.running = true;
        this.workerThread.start();
    }

    private void processLogs() {

        while (running || !blockingQueue.isEmpty()) {

            try {

                LogMessage logMessage =
                        blockingQueue.take();

                for (Appender appender : appenders) {

                    try {

                        appender.append(logMessage);

                    } catch (Exception e) {

                        System.err.println(
                                "Appender failed: "
                                        + e.getMessage()
                        );
                    }
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                break;
            }
        }
    }

    public void info(String logMessage) {
        log(LogLevel.INFO, logMessage, null);
    }
    public void trace(String logMessage) {
        log(LogLevel.TRACE, logMessage, null);
    }
    public void debug(String logMessage) {
        log(LogLevel.DEBUG, logMessage, null);
    }
    public void warn(String logMessage) {
        log(LogLevel.WARN, logMessage, null);
    }
    public void error(String logMessage) {
        log(LogLevel.ERROR, logMessage, null);
    }
    public void error(String logMessage, Throwable throwable) {
        log(LogLevel.ERROR, logMessage, throwable);
    }
    
    private void log(LogLevel level, String logMessage, Throwable throwable) {
        if(level.getPriority() < minLogLevel.getPriority()) {
            return;
        }
        LogMessage message = new LogMessage(level, logMessage, LocalDateTime.now(), Thread.currentThread().getName(), throwable, "worker");
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("interrupted");
        }
    }
    public void shutDown() {
        running = false;
        workerThread.interrupt();
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
