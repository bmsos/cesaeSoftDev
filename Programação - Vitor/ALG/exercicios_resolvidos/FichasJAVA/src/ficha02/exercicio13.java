package ficha02;
import java.util.Scanner;

public class exercicio13 {

    //  Faça um programa que leia um horário no sistema de 24 horas e imprima esse horário no sistema de 12 horas.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int horas, minutos;

        System.out.print("Horas: ");
        horas = input.nextInt();
        System.out.print("Minutos: ");
        minutos = input.nextInt();

        if (horas > 23 ||  minutos > 59) {
            System.out.print("Indique um formato de hora correto (hora: 0 - 23 | minutos: 0 - 59).");
        } else {
            if (horas > 12) {
                horas -= 12;
                System.out.print(horas + ":" + minutos + " PM");
            } else {
                System.out.print(horas + ":" + minutos + " AM");
            }
        }

    }
}
