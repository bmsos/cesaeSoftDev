package extra_ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex2 {
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
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("filesExtra/exercicio_02.txt");
        try {
            String [] palavras = new String [contarPalavras(file)];
            Scanner sc = new Scanner(file);
            int index = 0;
            while (sc.hasNext()) {
                String palavra = sc.next().replaceAll("[,:;._?!\"]", "");
                palavras[index] = palavra;
                index++;
            }

            int maiorNumOcorrencias = 1;
            String palavraComMaisOcorrencias = "";
            for (int i=0; i< palavras.length; i++) {
                int countOcorrencias = 1;
                for (int j=i+1; j< palavras.length; j++) {
                    if (palavras[i].equals(palavras[j])) {
                        countOcorrencias++;
                    }
                }
                if (countOcorrencias > maiorNumOcorrencias) {
                    maiorNumOcorrencias = countOcorrencias;
                    palavraComMaisOcorrencias = palavras[i];
                }
            }
            System.out.println("Palavra com mais ocorrencias: " + palavraComMaisOcorrencias);
            System.out.println("Ocorrencias: " + maiorNumOcorrencias);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
