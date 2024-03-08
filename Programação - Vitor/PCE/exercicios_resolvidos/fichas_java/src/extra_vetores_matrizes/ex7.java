package extra_vetores_matrizes;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = {1, 3, 5, 1, 2, 1},
        semN = new int[lista.length];

        int count = 0;

        System.out.print("Número a remover: ");
        int n = input.nextInt();

        for (int i=0; i< lista.length; i++) {
            if (lista[i] != n) {
                semN[count] = lista[i];
                count++;
            }
        }

        int[] semNLimpo = new int[count];

        for (int i=0; i< count; i++) {
            semNLimpo[i] = semN[i];
        }

        for (int i=0; i< semNLimpo.length; i++) {
            System.out.print(semNLimpo[i] + " | ");
        }

    }
}
