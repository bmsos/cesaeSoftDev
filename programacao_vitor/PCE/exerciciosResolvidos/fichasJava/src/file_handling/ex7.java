package file_handling;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ex7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("files7/exercicio_07.txt");
        Scanner sc = new Scanner(file);

        int numLinhas = 0, numPalavras = 0;
        while (sc.hasNextLine()) {
            numPalavras += sc.nextLine().split(" ").length;
            numLinhas++;
        }

        System.out.println(numLinhas);
        System.out.println(numPalavras);

        sc.close();
    }
}
