import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
    /** Converte os dados de um ficheiro numa matriz
     *
     * @param file
     * @return String[][] - matriz com os dados do ficheiro
     * @throws FileNotFoundException
     */
    static String[][] converterFicheiroEmMatriz (File file) throws FileNotFoundException {
        int linhas = 0, colunas = 0;
        Scanner scRead = new Scanner(file);
        colunas = scRead.nextLine().split(";").length; // remove o cabeçalho e aproveita para definir o nr de colunas
        while (scRead.hasNextLine()) {
            String[] linha = scRead.nextLine().split(";");
            linhas++;
        }

        String[][] matriz = new String[linhas][colunas];

        Scanner sc = new Scanner(file);
        sc.nextLine();  // remover o cabeçalho
        for (int i=0; sc.hasNextLine(); i++) {
            String[] linha = sc.nextLine().split(";");
            for (int k=0; k<linha.length; k++) {
                matriz[i][k] = linha[k];
            }
        }
        return matriz;
    }
}
