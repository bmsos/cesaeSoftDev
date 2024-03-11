package extra_vetores_matrizes;

public class ex17 {
    public static void main(String[] args) {
        int[][] m = {
                {7, 0, 9},
                {7, 4, 6},
                {1, 5, 2}
        };

        int maior = m[0][0], menor = m[0][0],
            segundoMaior = m[0][0], segundoMenor = m[0][0];

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (m[i][j] > maior) {
                    maior = m[i][j];
                }
                if (m[i][j] < maior && m[i][j] > segundoMaior) {
                    segundoMaior = m[i][j];
                }
                if (m[i][j] < menor) {
                    menor = m[i][j];
                }
                if (m[i][j] > menor && m[i][j] < segundoMenor) {
                    segundoMenor = m[i][j];
                }
            }
        }

        System.out.println("Maior: " + maior);
        System.out.println("Segundo maior: " + segundoMaior);
        System.out.println("Segundo menor: " + segundoMenor);
        System.out.println("Menor: " + menor);

    }
}
