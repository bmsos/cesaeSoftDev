package ficha_01;
import java.util.Scanner;
import java.util.Scanner;

public class exercicio06 {

    //  Escreva um programa que leia dois valores inteiros e os armazene na variáveis valor1 e valor2. Permute
    //  o valor das variáveis e apresente o resultado. De seguida, verifique se consegue efetuar esta troca sem
    //  criar variáveis adicionais

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v1, v2;
        System.out.print("Indique o primeiro valor: ");
        v1 = input.nextInt();
        System.out.print("Indique o segundo valor: ");
        v2 = input.nextInt();

        v1 = v1 + v2;
        v2 = v1 - v2;
        v1 = v1 - v2;

        System.out.println("V1: " + v1);
        System.out.println("V2: " + v2);
    }
}
