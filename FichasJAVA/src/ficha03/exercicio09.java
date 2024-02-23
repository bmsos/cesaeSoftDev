package ficha03;
import java.util.Scanner;
public class exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, soma = 0;
        double count = 0, media;

        while(true) {
            System.out.print("Indique um número: ");
            n = input.nextInt();

            if (n == -1) {break;}

            soma += n;
            count += 1;
        }

        media = (soma / count);

        System.out.println("Media: " + media);
    }

}
