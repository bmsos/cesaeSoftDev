package ficha03;
import java.util.Scanner;
public class exercicio08 {

    //  Faça um programa que leia um número inteiro e imprima os 5 anteriores e os 5 seguintes.
    //  Por exemplo: Leu 15, deve imprimir: 10 11 12 13 14 16 17 18 19 20

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, i;

        System.out.print("Indique um número: ");
        n = input.nextInt();

        i = n-5;

        while (i <= n+5) {
            if (i != n) {
                System.out.println(i);
            }

            i += 1;
        }
    }
}
