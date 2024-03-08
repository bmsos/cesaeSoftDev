package extra_vetores_matrizes;
import java.util.Scanner;
public class ex18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Linhas: ");
        int linhas = input.nextInt();
        System.out.print("Colunas: ");
        int colunas = input.nextInt();

        int[][] m1 = new int [linhas][colunas];

        for (int i=0; i<linhas; i++) {
            for (int j=0; j<colunas; j++) {
                System.out.print("Número: ");
                m1[i][j] = input.nextInt();
            }
        }

        for (int i=0; i<linhas; i++) {
            for (int j=0; j<colunas; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

        for (int i=0; i<colunas; i++) {
            for (int j=0; j<linhas; j++) {
                System.out.print(m1[j][i] + " ");
            }
            System.out.println();
        }


    }
}
