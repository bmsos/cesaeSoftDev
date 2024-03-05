package ficha03;
import java.util.Scanner;
public class exercicio14 {

    //  Escreva um programa que leia uma sequência de números inteiros do utilizador
    //  e determine se a sequência está em ordem crescente.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, qtd, i = 0, maior = 0;
        boolean crescente = true;

        System.out.print("Quantos números quer inserir?: ");
        qtd = input.nextInt();

        while (i < qtd) {

            System.out.print("Indique um número: ");
            n = input.nextInt();

            if (i == 0) {
                maior = n;
                i += 1;
                continue;
            }

            if (n < maior) {
                crescente = false;
            }

            maior = n;
            i++;
        }

        if (crescente) {
            System.out.println("Crescente.");
        } else {
            System.out.println("Não crescente.");
        }

    }
}
