package ficha_01;

import java.util.Scanner;

public class exercicio02 {

    //  Escreva um programa que requisite dois valores. O programa deverá utilizá-los como operandos para
    //  as seguintes operações aritméticas: soma, subtração, multiplicação e divisão. Apresente o resultado
    //  das operações e teste os resultados obtidos com vários casos

    public static void main(String[] args) {

        double n1, n2;

        Scanner input = new Scanner(System.in);

        System.out.print("Indique o primeiro número: ");
        n1 = input.nextDouble();
        System.out.print("Indique o segundo número: ");
        n2 = input.nextDouble();

        System.out.println("Soma: " +  (n1 + n2));
        System.out.println("Subtração: " +  (n1 - n2));
        System.out.println("Multiplicação: " +  (n1 * n2));
        System.out.println("Divisão: " +  n1/n2);

    }
}
