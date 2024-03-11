package extra_vetores_matrizes;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] lista = new int[10];

        for (int i = 0; i <10; i++) {
            System.out.printf("Número %s: ", i+1);
            lista[i] = input.nextInt();
        }

        for (int l =9; l >= 0; l--) {
            System.out.print(lista[l] + ", ");
        }

    }
}
