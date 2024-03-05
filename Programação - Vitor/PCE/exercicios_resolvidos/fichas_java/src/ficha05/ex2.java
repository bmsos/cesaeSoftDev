package ficha05;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] meses = new String[12];
        meses[0] = "Janeiro";
        meses[1] = "Fevereiro";
        meses[2] = "Março";
        meses[3] = "Abril";
        meses[4] = "Maio";
        meses[5] = "Junho";
        meses[6] = "Julho";
        meses[7] = "Agosto";
        meses[8] = "Setembro";
        meses[9] = "Outubro";
        meses[10] = "Novembro";
        meses[11] = "Dezembro";

        double[] comissoes = new double[12];

        for (int i = 0; i < 12; i++) {
            System.out.printf("Comissão de %s (%%): ", meses[i]);
            comissoes[i] = input.nextDouble();
            comissoes[i] /= 100.0;

            System.out.println(comissoes[i]);
        }

    }
}
