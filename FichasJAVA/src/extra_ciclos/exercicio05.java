package extra_ciclos;

public class exercicio05 {
    public static void main(String[] args) {
        // 5.1
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.print("\n---------------------------\n");

        // 5.2
        int reps= 1;
        int numToPrint = 1;
        for (int i = 5; i >=1; i--) {

            int j = 1;
            while (j<i) {
                System.out.print(" ");
                j++;
            }

            for (int l = 1; l <= reps; l++) {
                System.out.print(numToPrint);
            }
            reps += 2;
            numToPrint++;
            System.out.println();
        }

        System.out.print("\n---------------------------\n");
        

        // 5.3 - ALT 3
        int linhas = 5;
        reps= 1;

        for (int i = linhas; i >=1; i--) {

            for (int j =1; j<i; j++) {
                System.out.print(" ");
            }

            int incremento = 0;
            for (int k = 1; k < reps; k++) {
                System.out.print(reps - incremento);
                incremento++;
            }

            System.out.print(1);

            incremento = 0;
            for (int f = 1; f < reps; f++) {
                System.out.print(2 + incremento);
                incremento++;
            }

            System.out.println();
            reps++;
        }
    }
}
