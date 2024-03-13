package file_handling;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        File ficheiro = new File("files/exemplo.txt");
        PrintWriter pw = new PrintWriter(ficheiro);
        pw.println("ola");
        pw.close();
    }
}
