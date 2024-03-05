package ficha_01;

import java.util.Scanner;

public class exercicio01 {

    //  Escreva um programa que faça a soma de dois números introduzidos pelo utilizador. Apresente o
    //  resultado da operação.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n1, n2;

        System.out.print("Indique um número: ");

        n1 = input.nextInt();

        System.out.print("Indique outro número: ");

        n2 = input.nextInt();

        System.out.println("A soma dos números é " + (n1 + n2));

    }
}
