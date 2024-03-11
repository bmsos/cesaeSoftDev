package extra_vetores_matrizes;
import java.util.Scanner;
public class ex8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = {1, 2, 3, 8, 5, 9, 7, 4},
                lista2 = new int[lista.length + 1];

        System.out.print("Valor: ");
        int valor = input.nextInt();

        System.out.print("Posição: ");
        int posicao = input.nextInt();

        lista2[posicao] = valor;

        for (int i=0; i<posicao; i++) {
            lista2[i] = lista[i];
        }

        for (int i=posicao+1;i< lista2.length;i++) {
            lista2[i] = lista[i-1];
        }

        for (int i=0; i<lista2.length; i++) {
            System.out.print(lista2[i] + " | ");
        }

    }
}
