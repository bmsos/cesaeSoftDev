package extra_ciclos;

public class exercicio02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 255; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

//        for (int i = 3; i <= 255; i += 3) {
//            System.out.println(i);
//        }
    }
}
