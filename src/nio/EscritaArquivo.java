package nio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EscritaArquivo {

    public static void main(String[] args) throws Exception {

        final List<String> linhas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            linhas.add("linha " + i);
        }

        // java io - antigo
        final String destino = "src/nio/escrita.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(destino))) {
            for (String linha : linhas) {
                writer.println(linha);
            }
        }

        // java NIO - novo
        Files.write(Path.of("src/nio/escrita.txt"), linhas);
    }
}
