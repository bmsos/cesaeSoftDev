package extra_vetores_matrizes;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] lista = new int[10];
        boolean check = false;

        for (int i = 0; i <10; i++) {
            System.out.print("Número: ");
            lista[i] = input.nextInt();
        }

        System.out.print("Numero a pesquisar: ");
        int n = input.nextInt();

        for (int i = 0; i <10; i++) {
            if (n == lista[i]) {
                if(!check) {
                    check = true;
                    System.out.println("O valor existe no vector!");
                    System.out.println("No índice " + i);
                } else {
                    System.out.println("No índice " + i);
                }

            }
        }

    }
}
