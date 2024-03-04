package ficha03;
import java.util.Scanner;
public class exercicio05 {

    //  Faça um programa que leia um número inteiro e, de seguida, leia uma mensagem.
    //  Depois imprima a mensagem x vezes, sendo x o número inteiro lido.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n=0, fim;
        String mensagem;

        System.out.print("Indique um número: ");
        fim = input.nextInt();
        System.out.print("Indique uma mensagem: ");
        input.nextLine();
        mensagem = input.nextLine();

        while (n < fim) {

            System.out.println(mensagem);
            n += 1;

        }
    }
}
