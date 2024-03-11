package extra_vetores_matrizes;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Tamanho do array: ");
        int n = input.nextInt();

        int [] lista = new int[n];

        for (int i = 0; i <lista.length; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();
        }

        for (int i = 0; i <lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
    }
}
