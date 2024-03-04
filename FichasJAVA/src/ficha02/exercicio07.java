package ficha02;
import java.util.Scanner;
public class exercicio07 {

    //  Escreva um programa que leia um número, depois apresente se é par ou ímpar.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Indique um número: ");
        n = input.nextInt();

        if (n % 2 == 0) {
            System.out.print("O número é par.");
        } else {
            System.out.print("O número é ímpar.");
        }

    }
}
