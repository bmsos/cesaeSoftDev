package ficha05;

public class ex13 {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int soma=0;

        for (int i=0; i<4; i++) {
            soma += m[i][i];
        }

        System.out.println("Soma: " + soma);
    }
}
