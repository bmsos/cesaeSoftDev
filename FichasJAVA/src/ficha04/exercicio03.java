package ficha04;
import java.util.Scanner;
public class exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, guess, qtdTentativas=1;

        while (true) {
            System.out.print("""
                        JOGADOR 1
                        Indique o número a adivinhar:""" + " ");
            n = input.nextInt();

            if (n < 0 || n > 100) {
                System.out.println("O número tem de ser entre 0 e 100.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("""
                        JOGADOR 2
                        Adivinhe o número do JOGADOR 1:""" + " ");
            guess = input.nextInt();

            if (guess == n) {
                System.out.println("Adivinhou o número do JOGADOR 1! Precisou de " + qtdTentativas + " tentativas.");
                break;
            } else {
                qtdTentativas += 1;
                if (guess < n) {
                    System.out.println("O número certo é maior que esse");
                } else  {
                    System.out.println("O número certo é menor que esse");
                }
            }
        }





    }
}
