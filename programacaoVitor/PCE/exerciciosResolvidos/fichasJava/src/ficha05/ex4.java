package ficha05;
import java.util.Scanner;
public class ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = new int[10];
        int menor=0;

        for (int i=0; i<10; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();

            if (i==0) {
                menor = lista[i];
                continue;
            }

            if (lista[i] < menor) {
                menor = lista[i];
            }
        }

        System.out.printf("Menor: %s", menor);
    }
}
