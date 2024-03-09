package ficha06;

public class ex8 {

    static int[][] somarMatrizes (int[][] m1, int[][] m2) {
        int[][] m3 = new int[m1.length][m1[0].length];

        for (int i=0; i< m3.length; i++) {
            for (int j=0; j< m3[0].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }

    static int somatorioMatrizes (int[][] m1, int[][] m2) {
        int soma = 0;

        for (int i=0; i< m1.length; i++) {
            for (int j=0; j< m1[0].length; j++) {
                soma += m1[i][j] + m2[i][j];
            }
        }

        return soma;
    }

    public static void main(String[] args) {
        int [][] m1 = {
                    {1, 2, 3},
                    {4, 5, 6}
                },
                m2 = {
                    {7, 8, 9},
                    {0, 3, 1}
                },
                matrizesSomadas = somarMatrizes(m1, m2);

        System.out.println("Soma das matrizes: ");
        for (int i=0; i< matrizesSomadas.length; i++) {
            for (int j=0; j< matrizesSomadas[0].length; j++) {
                System.out.print(matrizesSomadas[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Somatório das matrizes: " + somatorioMatrizes(m1, m2));

    }
}
