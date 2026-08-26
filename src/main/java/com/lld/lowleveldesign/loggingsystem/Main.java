package com.lld.lowleveldesign.loggingsystem;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Appender> appenderList = new ArrayList<>();
        appenderList.add(new ConsoleAppender(new SimpleFormatter()));
        Logger logger = new Logger(LogLevel.INFO, appenderList);

        logger.info("logging info message");
        logger.debug("debug log");
        logger.warn("warn log");
        Thread.sleep(2000);//allow thread to process all logs in queue
        logger.shutDown();
    }
}
