package nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class LeituraArquivo {

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

        // final Path pathMeuNIO = Path.of("src/nio/regras.txt");
        // System.out.println("meu caminho " + pathMeuNIO);

        final Path pathNIO = Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras.txt");
        try {
            if (Files.exists(pathNIO)) {
                System.out.println("Caminho absoluto NIO: " + pathNIO.toAbsolutePath());
                System.out.println("Diretorio?: " + Files.isDirectory(pathNIO));
                System.out.println("Caminho pai: " + pathNIO.getParent());
                if (Files.isRegularFile(pathNIO)) {
                    System.out.println("Tamanho: " + Files.size(pathNIO));
                    System.out.println("ultima modificacao: " + Files.getLastModifiedTime(pathNIO));
                } else {
                    try (Stream<Path> stream = Files.list(pathNIO)) {
                        stream.forEach((p -> System.out.println(" " + p.getFileName())));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // copiar ou mover
        try {
            Files.copy( // move
                    Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras.txt"),
                    Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras_copy.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras.txt"), System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // excluir arquivo
        try {
            Files.deleteIfExists(Path.of("C:\\Users\\F9307280\\code\\Cursos-Alura\\NIO\\nio\\regras_copy.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
