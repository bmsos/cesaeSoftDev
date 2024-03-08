package ficha06;
import java.util.Scanner;
public class ex2 {
    static int lerIntPositivo () {
        Scanner input = new Scanner(System.in);

        int n=-1;
        while (n <= 0) {
            System.out.print("Número: ");
            n = input.nextInt();
        }

        return n;
    }

    static void printAsteriscos(int n) {
        for (int i=0; i<n; i++) {
            System.out.print("*");
        }
    }

    public static void main(String[] args) {
        printAsteriscos(lerIntPositivo());
    }
}
