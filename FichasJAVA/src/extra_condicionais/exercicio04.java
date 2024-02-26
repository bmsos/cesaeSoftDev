package extra_condicionais;
import java.util.Scanner;
public class exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String letra;

        System.out.print("Indique uma letra do alfabeto: ");
        letra = input.next().toLowerCase();

        if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")) {
            System.out.println("A letra \"" + letra + "\" é uma vogal");
        } else {
            System.out.println("A letra \"" + letra + "\" é uma consoante");
        }

    }
}
