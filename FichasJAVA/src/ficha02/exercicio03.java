package ficha02;
import java.util.Scanner;
public class exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double salario, imposto;

        System.out.print("Salario: ");
        salario = input.nextDouble();

        if (salario <= 15000) {
            imposto = 0.2;
        } else if (salario > 15000 && salario <= 20000) {
            imposto = 0.3;
        } else if (salario > 20000 && salario <= 25000) {
            imposto =0.35;
        } else {
            imposto = 0.4;
        }

        System.out.print("Paga taxa de " + (int) (imposto * 100) + "%: " + (salario * imposto));
    }
}
