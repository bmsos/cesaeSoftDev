package ficha02;
import java.util.Scanner;
public class exercicio01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n1, n2, maior;

        System.out.print("Indique um número: ");
        n1 = input.nextInt();
        System.out.print("Indique outro número: ");
        n2 = input.nextInt();

//        if (n1 > n2) {
//            maior = n1;
//        } else {
//            maior = n2;
//        }

        maior = Math.max(n1, n2);


        System.out.print("O maior número é " + maior);

    }
}
