package ficha_01;
import java.util.Scanner;
public class exercicio07 {

    //  Escreva um programa que requisite ao utilizador o preço de 3 produtos adquiridos.
    //  Apresente o valor a pagar, considerando que deverá ter um desconto de 10% sobre o total dos produtos.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double p1, p2, p3;
        System.out.print("Indique o 1º preço: ");
        p1 = input.nextDouble();
        System.out.print("Indique o 2º preço: ");
        p2 = input.nextDouble();
        System.out.print("Indique o 3º preço: ");
        p3 = input.nextDouble();

        System.out.print("O preço total é de " + (p1 + p2 + p3) * 0.9);
    }
}
