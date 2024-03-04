package ficha02;
import java.util.Scanner;
public class exercicio05 {

    //  Escreva um programa que leia dois valores numéricos e apresente o menor e depois o maior.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2;

        System.out.print("Indique um numero: ");
        n1 = input.nextDouble();
        System.out.print("Indique outro numero: ");
        n2 = input.nextDouble();

        if (n1 > n2) {
            System.out.print(n2 + "\t\t" + n1);
        } else if (n2 > n1) {
            System.out.print(n1 + "\t\t" + n2);
        } else {
            System.out.print("Os números são iguais.");
        }
    }
}
