package teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LerRegras {

    private String dadosArquivo;

    public LerRegras(String nomeArquivo) throws IOException {
        this.dadosArquivo = leArquivo(nomeArquivo);
    }

    public static String leArquivo(String nomeArquivo) throws IOException {
        String dados;
        Path path = Paths.get(nomeArquivo);
        dados = new String(Files.readString(path));
        return dados;
    }

    public static List<Map<String, String>> buscaPlantacoes(String dados) {

        final String regex = "(\\d{1,2})\\s[A-zçõã]+\\s[de]{1,2}\\s([A-z]+)\\s[A-z]+\\s[a]\\s[A-zâ]+\\s[a-z]+\\s(\\d{1,2})\\s[a-z]+";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(dados);
        List<Map<String, String>> variaveis = new ArrayList<>();

        while (matcher.find()) {

            Map<String, String> plantacao = new HashMap<>();

            for (int i = 1; i <= matcher.groupCount(); i++) {
                String chave = " ";
                if (i == 1) {
                    chave = "qtde";
                }
                if (i == 2) {
                    chave = "azeitona";
                }
                if (i == 3) {
                    chave = "distancia";
                }
                plantacao.put(chave, matcher.group(i));
            }

            variaveis.add(plantacao);
        }
        return variaveis;
    }

    public static Map<String, String> getTempoXToneladas(String dadosArquivo) {
        Map<String, String> tempoXToneladas = new HashMap<>();

        final String regex = "(\\d{1})\\s+[segundos]+\\s[a-z]+\\s[a]\\s(\\d{1})\\s+[toneladas]+";
        final String string = dadosArquivo;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        // while (matcher.find()) {
        // System.out.println("Full match: " + matcher.group(0));

        // for (int i = 1; i <= matcher.groupCount(); i++) {
        // System.out.println("Group " + i + ": " + matcher.group(i));
        // }
        // }

        for (int i = 1; i <= matcher.groupCount(); i++) {
            String chave = "";
            System.out.println("i" + i);
            if (i == 1) {
                System.out.println("tempo");
                System.out.println(matcher.group(i));
                chave = "tempo";
            }
            if (i == 2) {
                System.out.println("toneladas");
                chave = "toneladas";
            }
            System.out.println(matcher.group(i));
            // tempoXToneladas.put(chave, matcher.group(i));
            System.out.println(tempoXToneladas);
        }

        // return tempoXToneladas;
        return null;
    }

    public static void main(String[] args) throws IOException {
        String informacao = leArquivo("regras.txt");
        System.out.println("imprime regras: ");
        System.out.println(informacao);

        List<Map<String, String>> dadosPlantacoes = new ArrayList<>();
        dadosPlantacoes = buscaPlantacoes(informacao);
        System.out.println("imprime dados de plantacoes: " + dadosPlantacoes);

        Map<String, String> tempoXToneladas = new HashMap<>();
        tempoXToneladas = getTempoXToneladas(informacao);
        System.out.println(tempoXToneladas);

    }
}