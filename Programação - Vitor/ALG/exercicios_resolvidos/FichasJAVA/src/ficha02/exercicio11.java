package ficha02;
import java.util.Scanner;

public class exercicio11 {

    //  Implemente um programa que, após pedir ao utilizador o saldo da conta bancária e montante a creditar/debitar
    //  (montante positivo ou negativo, respetivamente), apresente se a operação é válida, ou seja, se o saldo final se
    //  mantém positivo depois da operação. Finalmente, mostre o novo saldo.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double saldo, montante;
        String operacao;

        System.out.print("Qual o seu saldo bancário?: ");
        saldo = input.nextDouble();
        input.nextLine();
        System.out.print("Que operação pretende efetuar?: ");
        operacao = input.nextLine();
        System.out.print("Qual o montante?: ");
        montante = input.nextDouble();


//        if (operacao == "levantamento") {
//            if (saldo >= montante) {
//                saldo -= montante;
//            } else {
//                System.out.print("O seu saldo não permite efetuar o levantamento desse montante.");
//            }
//        } else if (operacao == "deposito") {
//            saldo += montante;
//        }

        switch (operacao) {
            case "levantamento" -> {
                if (saldo >= montante) {
                    saldo -= montante;
                    System.out.println("Valor levantado: " + montante);
                    System.out.println("Saldo atual: " + saldo);
                } else {
                    System.out.print("O seu saldo não permite efetuar o levantamento desse montante.");
                }
            }
            case "deposito" -> {
                saldo += montante;
                System.out.println("Valor depositado: " + montante);
                System.out.println("Saldo atual: " + saldo);
            }
            default ->
                    System.out.print("Por favor indiqe a operação pretendida (depósito / levantamento)");
        }


    }
}
