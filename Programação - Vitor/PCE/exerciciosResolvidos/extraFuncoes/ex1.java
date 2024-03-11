package extraFuncoes;
import java.util.Scanner;
public class ex1 {
    static int numMaisPequeno (int n1, int n2, int n3) {
        int menor = n1;

        if (n2 < menor) {
            menor = n2;
        }

        if (n3 < menor) {
            menor = n3;
        }

        return menor;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Número 1: ");
        int n1 = input.nextInt();
        System.out.print("Número 2: ");
        int n2 = input.nextInt();
        System.out.print("Número 3: ");
        int n3 = input.nextInt();

        System.out.print(numMaisPequeno(n1, n2, n3));
    }
}
