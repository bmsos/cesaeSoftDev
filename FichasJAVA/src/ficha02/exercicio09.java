package ficha02;

import java.util.Scanner;

public class exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2, n3;

        System.out.print("Indique o 1º número: ");
        n1 = input.nextInt();
        System.out.print("Indique o 2º número: ");
        n2 = input.nextInt();
        System.out.print("Indique o 3º número: ");
        n3 = input.nextInt();

        if (n1 < n2 && n1 < n3) {
            System.out.print("O menor número é " + n1);
        } else if (n2 < n1 && n2 < n3) {
            System.out.print("O menor número é " + n2);
        } else {
            System.out.print("O menor número é " + n3);
        }
    }
}
