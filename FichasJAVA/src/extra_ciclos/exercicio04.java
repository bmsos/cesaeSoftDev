package extra_ciclos;

public class exercicio04 {
    public static void main(String[] args) {
        for (int i = 0; i <4; i++) {
            for (int j =0; j<10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n-------------------------------------\n");

        for (int i = 1; i <=5; i++) {
            for (int j =0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n-------------------------------------\n");

//        int reps = 1;
//        for (int i = 5; i >=1; i--) {
//
//            int j = 1;
//            while (j<i) {
//                System.out.print(" ");
//                j++;
//            }
//
//            System.out.print("*".repeat(reps));
//            System.out.println();
//            reps += 2;
//        }

        int reps= 1;
        for (int i = 5; i >=1; i--) {

            for (int j = 1; j<i; j++) {System.out.print(" ");}

            for (int l = 1; l <= reps; l++) {System.out.print("*");}

            reps += 2;
            System.out.println();
        }
    }
}
