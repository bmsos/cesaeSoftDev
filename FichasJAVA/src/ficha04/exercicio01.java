package ficha04;
import java.util.Objects;
import java.util.Scanner;
public class exercicio01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1, n2;
        String operacao, check;

        do {
            System.out.print("Indique o 1º número: ");
            n1 = input.nextInt();
            System.out.print("Indique o 2º número: ");
            n2 = input.nextInt();

            input.nextLine();
            System.out.print("Indique a operação (+ - soma | - subtracao | * - multiplicação | / - divisao): ");
            operacao = input.nextLine();
            input.nextLine();

            switch (operacao) {
                case "+" -> System.out.println(String.format("%s + %s = %s", n1, n2, (n1 + n2)));
                case "-" -> System.out.println(String.format("%s - %s = %s", n1, n2, (n1 - n2)));
                case "*" -> System.out.printf(String.format("%s * %s = %s", n1, n2, (n1 * n2)));
                case "/" -> System.out.printf(String.format("%s / %s = %s", n1, n2, (n1 / n2)));
                default -> System.out.println("Indique uma operação válida.");
            }

            System.out.print("Deseja efetuar novo calculo? (y/n): ");

            check = input.nextLine();

        } while (true);

        //System.out.print("Programa terminado.");
    }
}
