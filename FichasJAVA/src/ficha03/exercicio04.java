package ficha03;
import java.util.Scanner;
public class exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0, fim;
        System.out.print("Indique um número: ");
        fim = input.nextInt();

        while (n <= fim) {

            System.out.println(n);
            n += 1;
        }
    }
}
