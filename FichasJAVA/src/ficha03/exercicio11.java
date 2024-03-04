package ficha03;
import java.util.Scanner;
public class exercicio11 {

    //  Faça um programa que leia um número inteiro (variável limite), um incremento (variável salto) e imprima os
    //  números inteiros de 0 até limite inclusive, com incremento de salto. Suponha que limite e salto são maiores que zero.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int limite, step, i=0;

        System.out.print("Indique um limite: ");
        limite = input.nextInt();
        System.out.print("Indique o step: ");
        step = input.nextInt();

        while (i <= limite) {
            System.out.println(i);
            i += step;
        }


    }
}
