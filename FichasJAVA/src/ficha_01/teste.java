package ficha_01;
import java.util.Scanner;
public class teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int min1, seg1, min2, seg2, min3, seg3, min4, seg4, min5, seg5, somaMins, totalSegundos;

        System.out.print("Indique os minutos da musica 1: ");
        min1 = input.nextInt();
        System.out.print("Indique os segundos da musica 1: ");
        seg1 = input.nextInt();
        System.out.print("Indique os minutos da musica 2: ");
        min2 = input.nextInt();
        System.out.print("Indique os segundos da musica 2: ");
        seg2 = input.nextInt();

        somaMins = (min1 + min2) * 60;
        totalSegundos = somaMins + seg1 + seg2;

        System.out.print(totalSegundos);
    }
}
