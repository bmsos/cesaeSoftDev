package ficha03;
import java.util.Scanner;
public class exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1, n2;

        System.out.print("Indique o 1º número: ");
        n1 = input.nextInt();
        System.out.print("Indique o 2º número: ");
        n2 = input.nextInt();

        if (n1 <= n2) {
            while (n1 <= n2) {
                System.out.println(n1);
                n1 += 1;
            }

        } else {
            while (n1 >= n2) {
                System.out.println(n1);
                n1 -= 1;
            }
        }
    }
}