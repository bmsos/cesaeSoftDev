package ficha03;
import java.util.Scanner;
public class desafio_extra {

    //  Refazer o exercício 15 com a proibição de usar o operador da multiplicação *

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, i;

        System.out.print("Indique um numero: ");
        n = input.nextInt();

        i = n-2;
        long soma = n;
        long valorASomar = n;

        // 1º while - qtd de multiplicacoes
        while (i >= 1) {
            int j = 1;

            // 2º while - Qtd de somas a efetuar (que substituem cada multiplicacao)
            while (j <= i) {
                soma += valorASomar;
                j++;
            }

            valorASomar = soma;
            i--;
        }

        System.out.print("Fatorial de " + n + " = " + soma);
    }
}



