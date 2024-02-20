package ficha02;
import java.util.Scanner;
public class exercicio08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nota1, nota2, nota3;
        double notaFinal;

        System.out.print("Indique a 1ª nota: ");
        nota1 = input.nextInt();
        System.out.print("Indique a 2ª nota: ");
        nota2 = input.nextInt();
        System.out.print("Indique a 3ª nota: ");
        nota3 = input.nextInt();

        notaFinal = (nota1 * 0.25) + (nota2 * 0.35) + (nota3 * 0.4);

        if (notaFinal > 9.5) {
            System.out.print("Aprovado com " + notaFinal + " valores.");
        } else {
            System.out.print("Reprovado com " + notaFinal + " valores.");
        }

    }
}
