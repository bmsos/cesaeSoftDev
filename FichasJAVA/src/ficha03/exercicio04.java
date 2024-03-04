package ficha03;
import java.util.Scanner;
public class exercicio04 {

    //  Faça um programa que leia um número inteiro e imprima os números inteiros de 0 até este número.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0, fim;
        System.out.print("Indique um número: ");
        fim = input.nextInt();

        while (n <= fim) {

            System.out.println(n);
            n += 1;
        }
    }
}
