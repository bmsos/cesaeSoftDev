package ficha03;
import java.util.Scanner;
public class exercicio10 {

    //  Faça um programa que leia um número inteiro e imprima os números pares entre 2 e o número lido inclusive.
    //  Suponha que o número lido da entrada será maior que 2.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Indique um número: ");
        int n = input.nextInt(), i = 2;

        while (i <= n) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i += 1;
        }
    }
}
