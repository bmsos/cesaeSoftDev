package ficha02;
import java.util.Scanner;

public class exercicio14 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n1, n2, n3;

        System.out.print("Numero 1: ");
        n1 = input.nextInt();
        System.out.print("Numero 2: ");
        n2 = input.nextInt();
        System.out.print("Numero 3: ");
        n3 = input.nextInt();


        if (n1 >= n2 && n1 >= n3) {
            if (n2 >= n3) {
                System.out.print(n3 + "\t\t" + n2 + "\t\t" + n1);
            } else {
                System.out.print(n2 + "\t\t" + n3 + "\t\t" + n1);
            }
        }

        if (n2 >= n1 && n2 >= n3) {
            if (n1 >= n3) {
                System.out.print(n3 + "\t\t" + n1 + "\t\t" + n2);
            } else {
                System.out.print(n1 + "\t\t" + n3 + "\t\t" + n2);
            }
        }

        if (n3 >= n1 && n3 >= n2) {
            if (n1 > n2) {
                System.out.print(n2 + "\t\t" + n1 + "\t\t" + n3);
            } else {
                System.out.print(n1 + "\t\t" + n2 + "\t\t" + n3);
            }
        }

    }
}
