package ficha05;
import java.util.Scanner;
public class ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] lista = new double[10];
        double soma=0, count=0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextDouble();

            soma += lista[i];
            count++;
        }

        System.out.printf("Média: %s", (soma/count));
    }
}
