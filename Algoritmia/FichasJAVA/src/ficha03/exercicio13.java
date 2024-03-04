package ficha03;
import java.util.Scanner;
public class exercicio13 {

    //  Faça um algoritmo que leia dois números inteiros, representando os valores início e fim de um intervalo e
    //  imprima os múltiplos de 5 entre eles.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, f;

        System.out.print("Indique o inicio: ");
        i = input.nextInt();
        System.out.print("Indique o fim: ");
        f = input.nextInt();

        while(i <= f) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
