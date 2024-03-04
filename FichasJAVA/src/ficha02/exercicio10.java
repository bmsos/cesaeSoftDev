package ficha02;

import java.util.Scanner;

public class exercicio10 {

    //  Escreva um programa que leia dois números reais e pergunte ao utilizador qual a operação aritmética que quer
    //  realizar e apresente o resultado. O utilizador deve responder usando o símbolo da operação (exemplo: para fazer
    //  a soma, o utilizador deve escrever ‘+’). Se for inválido apresente erro.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2;
        String operacao;

        System.out.print("Indique o primeiro número: ");
        n1 = input.nextDouble();
        System.out.print("Indique o segundo número: ");
        n2 = input.nextDouble();

        // input.nextLine() is necessary before the usage of another input.nextLine string reader
        // consumes de newline character left in the input buffer after the nextInt() method
        // if the nextLine() is called in first place, it's not necessary to call the nextLine before
        input.nextLine();
        System.out.print("Indique a operação matemática pretendida: ");
        operacao = input.nextLine();


        switch (operacao) {
            case "+" -> System.out.print("Resultado: " + n1 + n2);
            case "-" -> System.out.print("Resultado: " + (n1 - n2));
            case "*" -> System.out.print("Resultado: " + (n1 * n2));
            case "/" -> System.out.print("Resultado: " + (n1 / n2));
            default -> System.out.print("Por favr indique a operação apenas através dos respetivos sinais (+, -, *, /)");
        }

        input.close();

        // INACABADO
    }
}
