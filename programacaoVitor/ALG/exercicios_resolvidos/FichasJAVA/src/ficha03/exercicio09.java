package ficha03;
import java.util.Scanner;
public class exercicio09 {

    //  Faça um programa que vai pedindo números ao utilizador até que este introduza o número -1.
    //  O computador deve dizer a média dos números introduzidos (excluindo o -1).

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n=0, soma = 0;
        double count = 0, media;

        while(n != -1) {
            System.out.print("Indique um número: ");
            n = input.nextInt();

            if (n != -1) {
                soma += n;
                count += 1;
            }
        }

        media = (soma / count);

        System.out.println("Media: " + media);
    }

}
