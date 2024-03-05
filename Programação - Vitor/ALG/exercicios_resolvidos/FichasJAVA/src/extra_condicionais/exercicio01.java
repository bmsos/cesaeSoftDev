package extra_condicionais;
import java.util.Scanner;
public class exercicio01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int idade;

        System.out.print("Idade: ");
        idade = input.nextInt();

        if (idade >= 18) {
            System.out.println("Maior de idade");
        } else if (idade >= 0) {
            System.out.println("Menor de idade");
        } else {
            System.out.println("Indique uma idade válida");
        }
    }
}
