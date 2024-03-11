package ficha05;
        import java.util.Scanner;
public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int maior = 0, menor = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print("Número: ");
                matriz[i][j] = input.nextInt();
            }
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(matriz[i][j] + " ");
                if (i==0 && j==0) {
                    maior = matriz[i][j];
                    menor = matriz[i][j];
                } else {
                    if (matriz[i][j] > maior) {
                        maior = matriz[i][j];
                    }
                    if (matriz[i][j] < menor) {
                        menor = matriz[i][j];
                    }
                }
            }
            System.out.println();
        }

        System.out.println("Maior número introduzido: " + maior);
        System.out.println("Menor número introduzido: " + menor);
    }
}
