import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws FileNotFoundException {
        String[][] a = {
                {"1", "2", "3"},
                {"4", "5", "6"}
            },
        b = {
                {"a", "b"},
                {"c", "d"}
        };

        for (String[] e : a) {
            for (String f : e) {
                System.out.print(f + " | ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i =0; i<a.length; i++) {
            a[i] = b[i];
        }

        for (String[] e : a) {
            for (String f : e) {
                System.out.print(f + " | ");
            }
            System.out.println();
        }
    }
}
