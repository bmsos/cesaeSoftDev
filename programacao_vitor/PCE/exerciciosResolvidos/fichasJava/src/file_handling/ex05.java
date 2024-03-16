package file_handling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) throws FileNotFoundException {
        File file31 = new File("files7/exercicio_05_31.txt");
        File file1999 = new File("files7/exercicio_05_1999.txt");

        Scanner sc31 = new Scanner(file31);
        Scanner sc1999 = new Scanner(file1999);

        int soma = 0;
        while(sc31.hasNextLine()) {
            soma += sc31.nextInt();
        }

        System.out.printf("Soma ficheiro 31: %s%n", soma);

        soma = 0;
        while(sc1999.hasNextLine()) {
            soma += sc1999.nextInt();
        }

        System.out.printf("Soma ficheiro 1999: %s%n", soma);

        sc31.close();
        sc1999.close();
    }
}
