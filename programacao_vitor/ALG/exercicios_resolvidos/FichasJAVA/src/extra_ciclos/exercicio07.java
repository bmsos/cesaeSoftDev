package extra_ciclos;
import java.util.Scanner;
public class exercicio07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, qtdPositivos = 0, qtdNegativos = 0;

        while (true) {
            System.out.print("Indique um número (para sair insira 0): ");
            n = input.nextInt();

            if (n==0) {
                break;
            }

            if (n < 0) {
                qtdNegativos++;
            } else {
                qtdPositivos++;
            }

        }
        System.out.println("Números positivos inseridos: " + qtdPositivos);
        System.out.println("Números negativos inseridos: " + qtdNegativos);


    }
}
