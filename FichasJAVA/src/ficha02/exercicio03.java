package ficha02;
import java.util.Scanner;
public class exercicio03 {

    //  Determine e escreva o montante de impostos a pagar sobre um salário anual lido, tendo em conta o seguinte:
    //  a. Salário até 15.000€ inclusive paga taxa de 20%
    //  b. Salário de 15.000€ a 20.000€ inclusive paga taxa de 30%
    //  c. Salário de 20.000€ a 25.000€ inclusive paga taxa de 35%
    //  d. Salário superior a 25.000€ paga taxa de 40%

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
