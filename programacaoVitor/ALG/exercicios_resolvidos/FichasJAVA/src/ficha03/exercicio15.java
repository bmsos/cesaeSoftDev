package ficha03;
import java.util.Scanner;
public class exercicio15 {

    //  Escreva um programa que calcule e imprima o fatorial de um número inteiro não-negativo n.
    //  Utilize o ciclo while

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n, fatorial = 1, i = 0;

        System.out.print("Indique um numero: ");
        n = input.nextLong();

        while (i < n) {
            fatorial *= i + 1;
            i++;
        }
        System.out.println("Fatorial de " + n + ": " + fatorial);
    }
}
