package ficha03;
import java.util.Scanner;
public class desafio_extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, numeroASomar, i=1;

        System.out.print("Indique um numero: ");
        n = input.nextInt();

        numeroASomar = n;

        // 1º while - qtd de numeros abaixo de n até 2
        while (i <= (n-2)) {
            int j = 1;

            while (j < (n-i)) {
                System.out.println("j: " + j);
                System.out.println("n-i: " + (n-i));
                System.out.println("numero a somar: "+ numeroASomar);
                numeroASomar += numeroASomar;
                System.out.println("numero a somar: "+ numeroASomar);
                j += 1;
            }



            System.out.println("-----------------------------------");
            i += 1;
        }
    }
}



