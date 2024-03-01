package extra_ciclos;
import java.util.Scanner;
public class exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        System.out.print("Numero: ");
        n = input .nextInt();

        int reps = (n / 10) + 1;

        System.out.println(n % 10);
    }
}
