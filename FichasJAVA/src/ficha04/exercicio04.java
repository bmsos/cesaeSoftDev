package ficha04;
import java.util.Scanner;
public class exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        boolean primo = true;
        System.out.print("Indique um número: ");
        n = input.nextInt();

        if (n != 1 && n != 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    primo = false;
                    break;
                }
            }
        }

        if (primo) {
            System.out.println(n + " é um número primo.");
        } else {
            System.out.println(n + " não é um número primo.");
        }
    }
}
