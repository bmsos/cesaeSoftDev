package extra_vetores_matrizes;
import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] lista = new int[14];

        for (int i = 0; i <14; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();
        }

        for (int l = 0; l < 14; l++) {
            System.out.print(lista[l] + ", ");
        }
    }
}
