package br.univille.log;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger;

        System.out.println("Escolha o modo de log (console/file):");
        String mode = scanner.nextLine().toLowerCase();

        if (mode.equals("console")) {
            logger = LoggerFactory.onConsole();
        } else if (mode.equals("file")) {
            System.out.println("Digite o nome do arquivo de log:");
            String filename = scanner.nextLine();
            logger = LoggerFactory.onFile(filename);
        } else {
            System.out.println("Modo de log inválido. Encerrando o programa.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("Escolha o nível de log (DEBUG, WARNING, ERROR) ou 'sair' para encerrar:");
            String inputLevel = scanner.nextLine().toUpperCase();

            if (inputLevel.equals("SAIR")) {
                break;
            }

            Level level;
            try {
                level = Level.valueOf(inputLevel);
            } catch (IllegalArgumentException e) {
                System.out.println("Nível de log inválido. Tente novamente.");
                continue;
            }

            System.out.println("Digite a mensagem de log:");
            String message = scanner.nextLine();

            logger.log(level, message);
        }

        scanner.close();
    }
}
