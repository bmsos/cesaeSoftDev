package ficha05;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril",
                        "Maio", "Junho", "Julho", "Agosto", "Setembro",
                        "Outubro", "Novembro", "Dezembro"};

        double[] comissoes = new double[12];
        double soma=0;

        for (int i = 0; i < 12; i++) {
            System.out.printf("Comissão de %s (€): ", meses[i]);
            comissoes[i] = input.nextDouble();

            soma += comissoes[i];
        }

        System.out.printf("Total anual: %s€", soma);

    }
}
