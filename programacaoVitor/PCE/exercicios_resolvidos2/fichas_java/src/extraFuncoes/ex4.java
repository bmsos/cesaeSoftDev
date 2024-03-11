package extraFuncoes;

import java.util.Scanner;

public class ex4 {
    static void tabuada (int n) {
        for (int i=1; i<=10; i++) {
            System.out.printf("%s x %s = %s%n", n, i, (n*i));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Numero: ");
        int n = input.nextInt();

        tabuada(n);
    }
}
