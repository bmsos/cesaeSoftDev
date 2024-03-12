package extraFuncoes;

import java.util.Scanner;

public class ex5 {
    static String contarPiada (int n) {
        String[] piadas = {"Piada 1", "Piada 2", "Piada 3", "Piada 4", "Piada 5"};
        if (n < 1) {
            return "Número inválido";
        }
        if (n > 5) {
            return "Só temos " + piadas.length + " piadas";
        }
        return piadas[n-1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Numero da piada: ");
        int n = input.nextInt();

        System.out.println(contarPiada(n));
    }
}
