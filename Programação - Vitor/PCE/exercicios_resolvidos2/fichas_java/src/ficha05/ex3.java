package ficha05;
import java.util.Scanner;
public class ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = new int[10];
        int maior=0;

        for (int i=0; i<10; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();

            if (i==0) {
                maior = lista[i];
                continue;
            }

            if (lista[i] > maior) {
                maior = lista[i];
            }
        }

        System.out.printf("Maior: %s", maior);
    }
}
