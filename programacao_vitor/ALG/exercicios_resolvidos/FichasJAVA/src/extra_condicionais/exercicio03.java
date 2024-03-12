package extra_condicionais;
import java.util.Scanner;
public class exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valor;

        System.out.print("Valor do produto: ");
        valor = input.nextDouble();

        if (valor > 100) {
            valor *= 0.9;
        }

        System.out.println("Valor final do produto: " + valor);
    }
}
