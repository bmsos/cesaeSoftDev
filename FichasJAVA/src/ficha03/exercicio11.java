package ficha03;
import java.util.Scanner;
public class exercicio11 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int limite, step, i=0;

        System.out.print("Indique um limite: ");
        limite = input.nextInt();
        System.out.print("Indique o step: ");
        step = input.nextInt();

        while (i <= limite) {
            System.out.println(i);
            i += step;
        }


    }
}
