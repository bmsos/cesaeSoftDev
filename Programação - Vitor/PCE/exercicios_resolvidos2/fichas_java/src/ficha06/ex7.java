package ficha06;
import java.util.Scanner;
public class ex7 {

    static void quadrado (String caractere, int linhas, int colunas) {
        for (int i=1; i<=linhas; i++) {
            for (int j=1; j<=colunas; j++) {
                if (i==1 || i==linhas || j==1 || j==colunas) {
                    System.out.print(caractere);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Caractere: ");
        String caractere = input.nextLine();

        System.out.print("Linhas: ");
        int linhas = input.nextInt();

        System.out.print("Colunas: ");
        int colunas = input.nextInt();

        quadrado(caractere, linhas, colunas);
    }
}
