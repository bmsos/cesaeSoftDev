package extra_ficheiros;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        File fileRead = new File("filesExtra/exercicio_01.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Palavra: ");
        String palavra = input.nextLine();

        try{
            Scanner sc = new Scanner(fileRead);
            File fileWrite = new File("filesExtra/exercicio_01_write.txt");
            PrintWriter pw = new PrintWriter(fileWrite);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha.contains(palavra)) {
                    pw.println(linha);
                }
            }

            pw.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
