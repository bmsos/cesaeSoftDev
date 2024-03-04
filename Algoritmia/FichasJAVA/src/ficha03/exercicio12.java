package ficha03;
import java.util.Scanner;
public class exercicio12 {

    //  Escreva um algoritmo que leia uma quantidade desconhecida de números inteiros positivos fornecidos pelo
    //  utilizador e conte quantos deles estão nos seguintes intervalos: [0.25], [26,50], [51,75] e [76,100].
    //  A entrada de dados deve terminar quando for lido um número negativo.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, soma25=0, soma50=0, soma75=0, soma100=0;

        while (true) {
            System.out.print("Indique um número: ");
            n = input.nextInt();

            if (n < 0) {break;}

            if (n <= 25) {
                soma25 += 1;
            }

            if (n > 25 && n <= 50) {
                soma50 += 1;
            }

            if (n > 50 && n <= 75) {
                soma75 += 1;
            }

            if (n > 75 && n <= 100) {
                soma100 += 1;
            }
        }

        System.out.println("Numeros inseridos no intervalo [0-25]: " + soma25);
        System.out.println("Numeros inseridos no intervalo [25-50]: " + soma50);
        System.out.println("Numeros inseridos no intervalo [50-75]: " + soma75);
        System.out.println("Numeros inseridos no intervalo [75-100]: " + soma100);
    }
}
