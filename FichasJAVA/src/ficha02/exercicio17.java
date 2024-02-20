package ficha02;
import java.util.Scanner;
public class exercicio17 {
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
