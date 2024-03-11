package extra_vetores_matrizes;

public class ex14 {
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        },
                m2 = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        },
                m3 = new int[4][3];

        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
