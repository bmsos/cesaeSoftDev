package ficha04;
import java.util.Scanner;
public class exercicio04 {

    //  Escreva um programa que indique se um número pedido ao utilizador é primo. (Chamamos de número primo um
    //  número natural que só possui dois divisores: 1 e ele mesmo). (Por exemplo: 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, etc…)

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
