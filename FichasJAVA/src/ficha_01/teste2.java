package ficha_01;
import java.util.Scanner;
public class teste2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int min1, seg1, min2, seg2, totalSegundos, horas, minutos, segundos;

        System.out.print("Indique os minutos da musica 1: ");
        min1 = input.nextInt();
        System.out.print("Indique os segundos da musica 1: ");
        seg1 = input.nextInt();
        System.out.print("Indique os minutos da musica 2: ");
        min2 = input.nextInt();
        System.out.print("Indique os segundos da musica 2: ");
        seg2 = input.nextInt();

        totalSegundos = ((min1 + min2) * 60) + seg1 + seg2;

        horas = totalSegundos / 3600;
        minutos = (totalSegundos % 3600) / 60;
        segundos = (totalSegundos % 3600) % 60;


        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }
}
