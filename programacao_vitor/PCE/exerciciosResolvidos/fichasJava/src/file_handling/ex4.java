package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("files/exercicio_04.csv");
        Scanner sc = new Scanner(file);

        String[][] casas = new String[150][150];
        int count = 0;
        while (sc.hasNextLine()) {
            casas[count] = sc.nextLine().split(";");
            count++;
        }

        for (int i=0; i<casas.length; i++) {
            for (int j=0; j<casas[0].length; j++) {
                System.out.print(casas[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
