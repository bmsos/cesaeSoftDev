package extra_vetores_matrizes;

public class ex16 {
    public static void main(String[] args) {
        int[][] m1 = {
                {3, 2, 1},
                {4, 5, 6},
                {8, 9, 7}
        };
        int maior = m1[0][0], menor = m1[0][0];

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (m1[i][j] > maior) {
                    maior = m1[i][j];
                }
                if (m1[i][j] < menor) {
                    menor = m1[i][j];
                }
            }
        }

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
    }
}
