package extra_ciclos;

public class teste {
    public static void main(String[] args) {
        int reps = 1;
        for (int i = 5; i >=1; i--) {

            int j = 1;
            while (j<i) {
                System.out.print(" ");
                j++;
            }


            System.out.print("*".repeat(reps));
            System.out.println();
            reps += 2;
        }
    }
}
