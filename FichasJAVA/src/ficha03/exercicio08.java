package ficha03;
import java.util.Scanner;
public class exercicio08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, i;

        System.out.print("Indique um número: ");
        n = input.nextInt();

        i = n-5;

        while (i <= n+5) {
            if (i != n) {
                System.out.println(i);
            }

            i += 1;
        }
    }
}
