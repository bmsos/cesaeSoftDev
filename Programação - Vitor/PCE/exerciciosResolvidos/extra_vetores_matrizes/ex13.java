package extra_vetores_matrizes;
import java.util.Scanner;
public class ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] m = new int [4][3];

        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                System.out.print("Número: ");
                m[i][j] = input.nextInt();
            }
        }

        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }


    }
}
