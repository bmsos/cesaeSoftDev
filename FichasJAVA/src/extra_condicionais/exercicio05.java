package extra_condicionais;
import java.util.Scanner;
public class exercicio05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 56, guess;

        System.out.print("Tente adivinhar o número (0-100): ");
        guess = input.nextInt();

        if (guess == n) {
            System.out.println("Adivinhou o número certo!");
        } else {
            if (guess < n) {
                System.out.println("O número certo é maior que esse");
            } else  {
                System.out.println("O número certo é menor que esse");
            }

            System.out.print("Tente adivinhar o número (0-100): ");
            guess = input.nextInt();

            if (guess == n) {
                System.out.println("Adivinhou o número certo!");
            } else {
                if (guess < n) {
                    System.out.println("O número certo é maior que esse");
                } else  {
                    System.out.println("O número certo é menor que esse");
                }
                System.out.println("Não adivinhaste o número. Melhor sorte para a próxima.");
            }

        }


    }
}
