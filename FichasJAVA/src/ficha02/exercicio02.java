package ficha02;
import java.util.Scanner;
public class exercicio02 {
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
