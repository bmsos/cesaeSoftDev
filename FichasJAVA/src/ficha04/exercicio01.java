package ficha04;
import java.util.Objects;
import java.util.Scanner;
public class exercicio01 {

    //  Implemente um programa que peça ao utilizador dois valores e um carácter representando uma das quatro
    //  operações aritméticas (+, -, *, /). Apresente o resultado de aplicar a operação correspondente aos valores. No
    //  final, deverá perguntar ao utilizador se deseja repetir, permitindo-lhe efetuar novos cálculos.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1, n2;
        String operacao, continuar;
        boolean check = true;

        do {
            System.out.print("Indique o 1º número: ");
            n1 = input.nextInt();
            System.out.print("Indique o 2º número: ");
            n2 = input.nextInt();

            input.nextLine();
            System.out.print("Indique a operação (+ - soma | - subtracao | * - multiplicação | / - divisao): ");
            operacao = input.nextLine();

            switch (operacao) {
                case "+" -> System.out.println(String.format("%s + %s = %s", n1, n2, (n1 + n2)));
                case "-" -> System.out.println(String.format("%s - %s = %s", n1, n2, (n1 - n2)));
                case "*" -> System.out.printf(String.format("%s * %s = %s", n1, n2, (n1 * n2)));
                case "/" -> System.out.printf(String.format("%s / %s = %s", n1, n2, (n1 / n2)));
                default -> System.out.println("Indique uma operação válida.");
            }

            while (true) {
                System.out.print("Deseja efetuar novo calculo? (y/n): ");
                continuar = input.nextLine();

                if (continuar.toUpperCase().equals("N")) {
                    check = false;
                    break;
                }

                if (!continuar.toUpperCase().equals("Y")) {
                    System.out.println("Indique se pretende efetuar novo calculo (y) ou não (n).");
                } else {
                    break;
                }
            }

        } while (check);

        //System.out.print("Programa terminado.");
    }
}
