package ficha03;
import java.util.Scanner;
public class teste {
    public static void main(String[] args) {
        int i=1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                System.out.println(i + " x " + j + " = " + (i * j));
                j++;
            }
            System.out.println(i);
            i++;
        }


    }
}
