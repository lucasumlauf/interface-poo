package br.univille.log;

public class LoggerConsole implements Logger {
    @Override
    public void log(Level level, String message) {
        String color;
        switch (level) {
            case DEBUG:
                color = "\u001B[32m"; // Green
                break;
            case WARNING:
                color = "\u001B[33m"; // Yellow
                break;
            case ERROR:
                color = "\u001B[31m"; // Red
                break;
            default:
                color = "\u001B[0m"; // Reset
        }
        System.out.println(color + "[" + level + "] " + message + "\u001B[0m");
    }
}