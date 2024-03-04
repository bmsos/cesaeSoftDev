package extra_ciclos;
import java.util.Scanner;
public class exercicio08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1, n2;

        System.out.print("1º número: ");
        n1 = input.nextInt();
        System.out.print("2º número: ");
        n2 = input.nextInt();

        int res = n1;

        for (int i = 0; i < (n2 -1); i++) {
            res *= n1;
        }

        System.out.println("Resultado: " + res);
    }
}
