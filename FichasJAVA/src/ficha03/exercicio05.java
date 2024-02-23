package ficha03;
import java.util.Scanner;
public class exercicio05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n=0, fim;
        String mensagem;

        System.out.print("Indique um número: ");
        fim = input.nextInt();
        System.out.print("Indique uma mensagem: ");
        input.nextLine();
        mensagem = input.nextLine();

        while (n < fim) {

            System.out.println(mensagem);
            n += 1;

        }
    }
}
