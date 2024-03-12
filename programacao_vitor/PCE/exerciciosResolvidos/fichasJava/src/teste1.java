import java.util.InputMismatchException;
import java.util.Scanner;

public class teste1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        try {
            int[] a = new int[10];
            a[11] = 20;
            // int n = "str";
            //int n = Integer.parseInt("str");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
