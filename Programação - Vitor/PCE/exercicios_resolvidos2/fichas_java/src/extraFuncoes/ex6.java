package extraFuncoes;

import java.util.Scanner;

public class ex6 {
    static int somatorioDigitos (int n) {
        if (n == 0) {
            return 0;
        }

        int soma = 0, resto;
        while (n !=0) {
            soma += (n % 10);
            n /= 10;
        }

        return soma;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Numero: ");
        int n = input.nextInt();

        System.out.println(somatorioDigitos(n));
    }
}
