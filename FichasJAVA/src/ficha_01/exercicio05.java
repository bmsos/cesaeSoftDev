package ficha_01;

import java.util.Scanner;

public class exercicio05 {

    //  Escreva um programa que determine a média aritmética de um conjunto de 3 valores introduzidos pelo
    //  utilizador. Tendo em consideração os valores introduzidos, deverá também apresentar a média
    //  ponderada considerando as seguintes ponderações: 20%, 30%, 50%

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double v1, v2, v3, mediaAritmetica, mediaPonderada;

        System.out.print("Indique o primeiro valor: ");
        v1 = input.nextDouble();
        System.out.print("Indique o segundo valor: ");
        v2 = input.nextDouble();
        System.out.print("Indique o terceiro valor: ");
        v3 = input.nextDouble();

        mediaAritmetica = (v1 + v2 + v3) / 3;

        mediaPonderada = (v1 * 0.2) + (v2 * 0.3) + (v3 * 0.5);

        System.out.println("Media aritmetica: " +  mediaAritmetica);
        System.out.println("Media ponderada: " +  mediaPonderada);


    }
}
