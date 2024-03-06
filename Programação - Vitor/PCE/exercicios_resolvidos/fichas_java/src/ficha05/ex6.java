package ficha05;
import java.util.Scanner;
public class ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = new int[10];
        int ant=0;
        boolean crescente = true;

        for (int i = 0; i < 10; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();

            if (i==0) {
                ant = lista[i];
                continue;
            }

            if (lista[i] < ant) {
                crescente = false;
            }

            ant = lista[i];
        }

        if (crescente) {
            System.out.println("É crescente");
        } else {
            System.out.println("Não é crescente");
        }
    }
}
