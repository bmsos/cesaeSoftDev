package extra_condicionais;
import java.util.Scanner;
public class exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ano;
        System.out.print("Ano: ");
        ano = input.nextInt();

        if (ano % 4 == 0) {
            System.out.println("Ano bissexto");
        } else {
            System.out.println("Ano comum");
        }
    }
}
