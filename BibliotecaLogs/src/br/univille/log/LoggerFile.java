package br.univille.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFile implements Logger {
    private final Path filePath;

    public LoggerFile(String filename) {
        this.filePath = Paths.get(filename);
        // Create the file if it does not exist
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de log");
            e.printStackTrace();
        }
    }

    @Override
    public void log(Level level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = timestamp + " [" + level + "] " + message + System.lineSeparator();
        try {
            Files.write(filePath, logMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo");
            e.printStackTrace();
        }
    }
}
