package ficha05;
import java.util.Scanner;
public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][5];
        int n, count = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<5; j++) {
                System.out.print("Número: ");
                matriz[i][j] = input.nextInt();
            }
        }

        System.out.print("Número a contar: ");
        n = input.nextInt();

        for (int i=0; i<3; i++) {
            for (int j=0; j<5; j++) {
                if (matriz[i][j] == n) {
                    count++;
                }
            }
        }
        System.out.printf("Introduziu o número \"%s\" %s vezes", n, count);
    }
}
