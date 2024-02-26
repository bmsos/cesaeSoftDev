package extra_condicionais;
import java.util.Scanner;
public class exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int peso;

        System.out.print("Peso: ");
        peso = input.nextInt();

        if (peso <= 0) {
            System.out.println("Indique um peso válido.");
        } else {
            System.out.println("Peso na lua: " + (peso * 0.16));
        }
    }
}
