package ficha05;

public class ex12 {
    public static void main(String[] args) {
        int[] l1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19},
            l2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        int[][] m1 = new int[10][2];

        for (int i=0; i<10; i++) {
            m1[i][0] = l1[i];
            m1[i][1] = l2[i];
        }

        for (int i=0; i<10; i++) {
            for (int j=0; j<2; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

    }
}
