package ficha_01;
import java.util.Scanner;
public class exercicio08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int min1, seg1, min2, seg2, min3, seg3, min4, seg4, min5, seg5, somaMins, totalSegundos, horas, minutos, segundos;

        System.out.print("Indique os minutos da musica 1: ");
        min1 = input.nextInt();
        System.out.print("Indique os segundos da musica 1: ");
        seg1 = input.nextInt();
        System.out.print("Indique os minutos da musica 2: ");
        min2 = input.nextInt();
        System.out.print("Indique os segundos da musica 2: ");
        seg2 = input.nextInt();
        System.out.print("Indique os minutos da musica 3: ");
        min3 = input.nextInt();
        System.out.print("Indique os segundos da musica 3: ");
        seg3 = input.nextInt();
        System.out.print("Indique os minutos da musica 4: ");
        min4 = input.nextInt();
        System.out.print("Indique os segundos da musica 4: ");
        seg4 = input.nextInt();
        System.out.print("Indique os minutos da musica 5: ");
        min5 = input.nextInt();
        System.out.print("Indique os segundos da musica 5: ");
        seg5 = input.nextInt();

        somaMins = (min1 + min2 + min3 + min4 + min5) * 60;
        totalSegundos = somaMins + seg1 + seg2 + seg3 + seg4 + seg5;

        horas = totalSegundos / 3600;
        minutos = (totalSegundos / 60) - (horas * 60);
        segundos = totalSegundos - (horas * 3600) - (minutos * 60);

        System.out.println(totalSegundos);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }
}
