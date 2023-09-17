package base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * Logs info message
     *
     * @param message message you want to log
     */
    public static void info(String message) {
        System.out.println(ANSI_BLACK + dateTimeFormatter.format(LocalDateTime.now()) + ANSI_RESET);
        System.out.println(ANSI_GREEN + "INFO : " + message + ANSI_RESET);
    }

    /**
     * Logs warning message
     *
     * @param message message you want to log
     */
    public static void warning(String message) {
        System.out.println(ANSI_BLACK + dateTimeFormatter.format(LocalDateTime.now()) + ANSI_RESET);
        System.out.println(ANSI_RED + "WARNING : " + message + ANSI_RESET);
    }
}

