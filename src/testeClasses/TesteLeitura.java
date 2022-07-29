package testeClasses;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {

        // Fluxo de Entrada com Arquivo
        FileInputStream fis = new FileInputStream("regras.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while (linha != null) {

            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();
        // Resumindo:
        /*
         * Primeiro, criamos o fluxo concreto com o arquivo, mas ainda binário, em
         * seguida, conseguimos transforma-los em caracteres, mas apenas a
         * contabilização, por fim, com o BufferedReader, podemos utilizar o método
         * readLine(), que nos permite ler linha a linha.
         */
    }
}
