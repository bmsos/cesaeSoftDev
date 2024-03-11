package ficha05;
import java.util.Scanner;
public class ex8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print("Número: ");
                matriz[i][j] = input.nextInt();
            }
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}