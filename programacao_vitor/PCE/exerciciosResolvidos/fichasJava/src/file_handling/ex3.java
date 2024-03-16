package file_handling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class ex3 {
    public static void main(String[] args) throws FileNotFoundException {
        File readFile = new File("files7/exercicio_03_Alternativa01.txt");
        File writeFile = new File("files7/ex3_write.txt");
        Scanner sc = new Scanner(readFile);
        PrintWriter pw = new PrintWriter(writeFile);

        while(sc.hasNextLine()) {
            pw.println(sc.nextLine());
        }

        sc.close();
        pw.close();
    }
}
