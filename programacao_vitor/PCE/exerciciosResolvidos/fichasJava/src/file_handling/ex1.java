package file_handling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("files/exercicio_01.txt");
        File f2 = new File("files/exercicio_01_Alternativa01.txt");
        File f3 = new File("files/exercicio_01_Alternativa02.txt");
        Scanner sc1 = new Scanner(f1);
        Scanner sc2 = new Scanner(f2);
        Scanner sc3 = new Scanner(f3);

        // File 1
        System.out.println(sc1.nextLine());
        System.out.println("\n-------------------------------------------\n");

        // File 2
        while(sc2.hasNextLine()) {
            String linha = sc2.nextLine();
            if (!linha.isEmpty()) {
                System.out.println(linha);
            }
        }
        System.out.println("\n-------------------------------------------\n");

        // File 3
        while(sc3.hasNextLine()) {
            System.out.println(sc3.nextLine());
        }

        sc1.close();
        sc2.close();
        sc3.close();
    }
}
