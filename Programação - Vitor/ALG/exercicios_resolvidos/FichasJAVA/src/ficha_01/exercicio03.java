package ficha_01;

import java.util.Scanner;

public class exercicio03 {

    //  Escreva um programa que calcule e apresente a área e o perímetro de um retângulo.
    //  As dimensões devem ser requisitadas ao utilizador.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double lado, area, perimetro;

        System.out.print("Indique o comprimento dos lados do retângulo:  ");
        lado = input.nextDouble();
        area = lado * lado;
        perimetro = lado * 4;
        System.out.print("A área do retângulo é de " + area + " e o perímetro é de " + perimetro);
    }
}
