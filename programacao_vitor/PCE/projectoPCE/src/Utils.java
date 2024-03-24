import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
    /** Converte os dados de um ficheiro numa matriz (todas as linhas incluindo cabeçalho)
     *
     * @param file
     * @return String[][] - matriz com os dados do ficheiro
     * @throws FileNotFoundException
     */
    public static String[][] converterFicheiroEmMatriz (File file) throws FileNotFoundException {
        int linhas = 0, colunas=0;
        Scanner scRead = new Scanner(file);
        while (scRead.hasNextLine()) {
            String[] linha = scRead.nextLine().split(";");
            colunas = linha.length;
            linhas++;
        }

        String[][] matriz = new String[linhas][colunas];

        Scanner sc = new Scanner(file);
        for (int i=0; sc.hasNextLine(); i++) {
            String[] linha = sc.nextLine().split(";");
            for (int k=0; k<linha.length; k++) {
                matriz[i][k] = linha[k];
            }
        }
        return matriz;
    }

    /**
     * Imprime uma matriz em formato tabela
     * @param matriz - para usar maioritariamente na visualização de ficheiros
     */
    public static void imprimirMatriz (String[][] matriz) {
        for (String[] linha : matriz) {
            for (String elemento : linha) {
                System.out.printf("%s | ", elemento);
            }
            System.out.println();
        }
    }
}
