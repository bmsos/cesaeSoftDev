package ficha_01;
import java.util.Scanner;
public class exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // calcular area de circunferencia
        // pi * r * r

        double raio, pi=3.14;

        System.out.print("Indique o raio da circunferencia: ");
        raio = input.nextDouble();

        System.out.print("A área é de " + (pi * raio * raio));
    }
}
