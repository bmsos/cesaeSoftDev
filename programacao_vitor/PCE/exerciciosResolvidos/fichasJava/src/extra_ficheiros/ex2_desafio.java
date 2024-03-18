package extra_ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex2_desafio {
    static int contarPalavras (File file) throws FileNotFoundException {
        Scanner scCount = new Scanner(file);
        int count = 0;
        while (scCount.hasNext()) {
            scCount.next();
            count++;
        }
        scCount.close();
        return count;
    }
    static String[] dados (File file) throws FileNotFoundException {
        String [] palavras = new String [contarPalavras(file)];
        Scanner sc = new Scanner(file);
        int index = 0;
        while (sc.hasNext()) {
            String palavra = sc.next().replaceAll("[,:;._?!\"]", "");
            palavras[index] = palavra;
            index++;
        }
        return palavras;
    }
    static String[] palavraComMaisOcorrencias (String[] array) {
        int maiorNumOcorrencias = 1;
        String palavraComMaisOcorrencias = "";
        for (int i=0; i< array.length; i++) {
            int countOcorrencias = 1;
            for (int j=i+1; j< array.length; j++) {
                if (array[i].equals(array[j])) {
                    countOcorrencias++;
                }
            }
            if (countOcorrencias > maiorNumOcorrencias) {
                maiorNumOcorrencias = countOcorrencias;
                palavraComMaisOcorrencias = array[i];
            }
        }
        // indice 0 - String palavra | indice 1 - String nº ocorrencias
        return new String[] {palavraComMaisOcorrencias, Integer.toString(maiorNumOcorrencias)};
    }
    static String[] arraySemPalavraMaisComum (String[] arrayOriginal, String palavraMaisComum, int ocorrencias) {
        String[] arraySemPalavraMaisComum = new String[arrayOriginal.length - ocorrencias];
        int index = 0;
        for (String elemento : arrayOriginal) {
            if (!elemento.equals(palavraMaisComum)) {
                arraySemPalavraMaisComum[index] = elemento;
                index++;
            }
        }
        return arraySemPalavraMaisComum;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("filesExtra/exercicio_02.txt");
        try {
            String[] palavras = dados(file);

            for (int i = 1; i <= 10; i++) {
                String[] resultado = palavraComMaisOcorrencias(palavras);
                String palavraMaisComum = resultado[0];
                int ocorrencias = Integer.parseInt(resultado[1]);

                System.out.printf("""
                %sª palavra com mais ocorrencias: %s | Ocorrencias: %s
                """, i, palavraMaisComum, ocorrencias);

                palavras = arraySemPalavraMaisComum(palavras, palavraMaisComum, ocorrencias);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
