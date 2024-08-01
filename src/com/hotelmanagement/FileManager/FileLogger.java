package com.hotelmanagement.FileManager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {

    private static final Logger logger = Logger.getLogger(FileLogger.class.getName());

    public static void writeInfoLog(String logString) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set up the FileHandler to write logs to a file
                    FileHandler fileHandler = new FileHandler("app.log", true);
                    fileHandler.setFormatter(new SimpleFormatter());

                    // Add the handler to the logger
                    logger.addHandler(fileHandler);
                    logger.setLevel(Level.ALL); // Set the logging level to ALL

                    // Log some messages
                    logger.info(logString);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void writeWarningLog(String logString) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set up the FileHandler to write logs to a file
                    FileHandler fileHandler = new FileHandler("app.log", true);
                    fileHandler.setFormatter(new SimpleFormatter());

                    // Add the handler to the logger
                    logger.addHandler(fileHandler);
                    logger.setLevel(Level.ALL); // Set the logging level to ALL

                    // Log some messages
                    logger.warning(logString);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void writeSevereLog(String logString) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set up the FileHandler to write logs to a file
                    FileHandler fileHandler = new FileHandler("app.log", true);
                    fileHandler.setFormatter(new SimpleFormatter());

                    // Add the handler to the logger
                    logger.addHandler(fileHandler);
                    logger.setLevel(Level.ALL); // Set the logging level to ALL

                    // Log some messages
                    logger.severe(logString);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
