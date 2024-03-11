package extraFuncoes;

import java.util.Scanner;

public class ex8 {
    static boolean isVogal (String letra) {

        String[] vogais = {"a", "e", "i", "o", "u"};

        for (int i=0; i<5; i++) {
            if (letra.toLowerCase().equals(vogais[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Letra: ");
        String letra = input.nextLine();

        System.out.println(isVogal(letra));
    }
}
