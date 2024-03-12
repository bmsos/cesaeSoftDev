package extra_ciclos;
import java.util.Scanner;
public class exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, menor = 0, maior=0, repsCount = 1;

        while (true) {
            System.out.print("Indique um número (para sair insira 0): ");
            n = input.nextInt();

            if (n==0) {
                break;
            }

            if(repsCount == 1) {
                maior = n;
                menor = n;
            } else {

                if (n > maior) {
                    maior = n;
                } else if (n < menor) {
                    menor = n;
                } else {
                    continue;
                }
            }

            repsCount++;

        }
        System.out.println("Maior número introduzido: " + maior);
        System.out.println("Menor número introduzido: " + menor);


    }
}
