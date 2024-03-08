package extra_vetores_matrizes;

public class ex15 {
    public static void main(String[] args) {
        int linhas = 3, colunas = 3;
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double soma = 0, count = linhas * colunas;

        for (int i=0; i<linhas; i++) {
            for (int j=0; j<colunas; j++) {
                soma += m1[i][j];
            }
        }

        System.out.print("Soma: " + (soma/count));
    }
}
