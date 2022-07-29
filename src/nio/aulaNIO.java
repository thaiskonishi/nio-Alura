package nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class aulaNIO {

    public static void main(String[] args) {
        final File fileIO = new File("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras.txt");
        if (fileIO.exists()) {
            System.out.println("Caminho absoluto: " + fileIO.getAbsolutePath());
            System.out.println("Diretorio?: " + fileIO.isDirectory());
            System.out.println("Caminho pai: " + fileIO.getParent());
            if (fileIO.isFile()) {
                System.out.println("Tamanho: " + fileIO.length());
                System.out.println("ultima modificacao: " + fileIO.lastModified());
            } else {
                for (File subfile : fileIO.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }

        final Path pathNIO = Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras.txt");

        final Path pathMeuNIO = Path.of("src/nio/regras.txt");
        System.out.println("meu caminho " + pathMeuNIO);
        try {
            if (Files.exists(pathNIO)) {
                System.out.println("Caminho absoluto NIO: " + pathNIO.toAbsolutePath());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
