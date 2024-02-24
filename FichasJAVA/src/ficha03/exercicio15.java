package ficha03;
import java.util.Scanner;
public class exercicio15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n, fatorial = 1, i = 0;

        System.out.print("Indique um numero: ");
        n = input.nextLong();

        while (i < n) {
            fatorial *= i + 1;
            i += 1;
        }

        System.out.println("Fatorial de " + n + ": " + fatorial);
    }
}
