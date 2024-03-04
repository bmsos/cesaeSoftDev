package ficha02;
import java.util.Scanner;
public class exercicio02 {

    //  Determine e escreva o montante de impostos a pagar sobre um salário anual lido, tendo em conta o seguinte:
    //  a. Salário até 15.000€ inclusive paga taxa de 20%
    //  b. Salário superior a 15.000€ paga taxa de 30%

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double salario, impostos;

        System.out.print("Indique o salario: ");
        salario = input.nextDouble();

        if (salario <= 15000) {
            impostos = 0.2;
            System.out.print("Paga taxa de 20%: " + (salario * impostos));
        } else {
            impostos = 0.3;
            System.out.print("Paga taxa de 30%: " + (salario * impostos));
        }


    }
}
