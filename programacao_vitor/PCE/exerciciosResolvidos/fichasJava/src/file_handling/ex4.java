package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("files/exercicio_04.csv");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}
