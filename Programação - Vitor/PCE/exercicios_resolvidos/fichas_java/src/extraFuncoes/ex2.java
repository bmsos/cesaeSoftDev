package extraFuncoes;

import java.util.Scanner;
public class ex2 {
    static double media (int n1, int n2, int n3) {
        double soma = n1 + n2 + n3;

        return soma / 3.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Número 1: ");
        int n1 = input.nextInt();
        System.out.print("Número 2: ");
        int n2 = input.nextInt();
        System.out.print("Número 3: ");
        int n3 = input.nextInt();

        System.out.print(media(n1, n2, n3));
    }
}
