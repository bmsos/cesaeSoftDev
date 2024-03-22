import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class teste {

    public static void main(String[] args) throws FileNotFoundException {
        File fileClientes = new File("database/GameStart_Clientes.csv");
        String[][] matriz = Utils.converterFicheiroEmMatriz(fileClientes);

        for (int i=0; i<matriz.length; i++) {
            System.out.println(matriz[i][1]);

        }
    }
}
