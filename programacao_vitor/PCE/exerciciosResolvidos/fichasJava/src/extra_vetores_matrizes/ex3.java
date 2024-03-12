package extra_vetores_matrizes;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] lista = new int[10];
        boolean check= false;

        for (int i = 0; i <10; i++) {
            System.out.printf("Número %s: ", i+1);
            lista[i] = input.nextInt();
        }

        System.out.println("Numero a pesquisar: ");
        int n = input.nextInt();

        for (int i = 0; i <10; i++) {
            if (n == lista[i]) {
                check = true;
                break;
            }
        }

        if (check) {
            System.out.printf("O número %s existe no vetor.", n);
        } else {
            System.out.printf("O número %s não existe no vetor.", n);
        }
    }
}
