package extra_vetores_matrizes;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.print("Tamanho do array: ");
//        int size = input.nextInt();
//
//        int [] lista = new int[size];
//
//        for (int i = 0; i <lista.length; i++) {
//            System.out.print("Número: ");
//            lista[i] = input.nextInt();
//        }

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

        for (int i=0; i< count; i++) {
            System.out.print(semN[i] + ", ");
        }
    }
}
