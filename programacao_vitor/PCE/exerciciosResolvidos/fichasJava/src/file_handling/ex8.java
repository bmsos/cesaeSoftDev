package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("files7/exercicio_08.csv");
        Scanner sc = new Scanner(file);

        sc.nextLine();
        double somaVendas = 0;
        for (int i=0; sc.hasNextLine(); i++) {
            String[] linha = sc.nextLine().split(",");
            double qtd = Double.parseDouble(linha[2]);
            double precoUnitario = Double.parseDouble(linha[3]);
            for (int j=0; j< linha.length; j++) {
                somaVendas += (precoUnitario * qtd) ;
            }
        }

        System.out.println("Total de vendas: " + somaVendas);

        sc.close();
    }
}
