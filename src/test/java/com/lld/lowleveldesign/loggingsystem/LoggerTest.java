package com.lld.lowleveldesign.loggingsystem;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LoggerTest {

    @Test
    void shutDownDoesNotPrintAppendingFailure() {
        ByteArrayOutputStream errorBuffer = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errorBuffer));

        try {
            Logger logger = new Logger(LogLevel.TRACE, List.of(message -> {
            }));
            logger.shutDown();

            String errorOutput = errorBuffer.toString(StandardCharsets.UTF_8);
            assertFalse(errorOutput.contains("appending failed"));
        } finally {
            System.setErr(originalErr);
        }
    }

    @Test
    void shutDownDrainsQueuedMessages() {
        AtomicInteger appendedCount = new AtomicInteger(0);
        Logger logger = new Logger(LogLevel.TRACE, List.of(message -> appendedCount.incrementAndGet()));

        logger.info("first");
        logger.info("second");
        logger.shutDown();

        assertEquals(2, appendedCount.get());
    }
}

