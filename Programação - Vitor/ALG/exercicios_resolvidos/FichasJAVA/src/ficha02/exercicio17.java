package ficha02;
import java.util.Scanner;
public class exercicio17 {

    //  Um banco autoriza a conceção de um crédito especial aos seus clientes, num montante variável com base no seu
    //  saldo médio do último ano. Faça um programa que leia o saldo médio de um cliente e calcule o valor do crédito
    //  especial de acordo com a seguinte tabela. Mostre uma mensagem com o saldo médio e o valor de crédito

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double saldo, credito, valorConcedido;

        System.out.print("Indique o seu saldo médio anual: ");
        saldo = input.nextDouble();

        if (saldo < 0) {
            System.out.print("O saldo não pode ser negativo.");
        } else {
            if (saldo >= 0 && saldo <= 2000) {
                credito = 0;
            } else if (saldo > 2000 && saldo <= 4000) {
                credito = 20;
            } else if (saldo > 4000 && saldo <= 6000) {
                credito = 30;
            } else {
                credito = 40;
            }

            valorConcedido = saldo * (credito / 100);

            System.out.println("Saldo medio: " + saldo + "€");
            System.out.println("Percentagem de crédito: " + credito + "%.");
            System.out.println("Valor concedido: " + valorConcedido + "€");
        }

    }
}
