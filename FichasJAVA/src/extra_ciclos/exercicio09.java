package extra_ciclos;
import java.util.Scanner;
public class exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, resto, res= 0;;

        System.out.print("Numero: ");
        n = input .nextInt();

        while (n != 0) {
            resto = n % 10;
            res += resto;
            n /= 10;
        }
        System.out.print("Soma dos algarismos: " + res);
    }
}
