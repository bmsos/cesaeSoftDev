package ficha02;
import java.util.Scanner;
public class exercicio16 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        int valor, resto, qtdNotas200, qtdNotas100, qtdNotas50, qtdNotas20, qtdNotas10, qtdNotas5;
//
//        System.out.print("Indique um valor que seja multiplo de 5: ");
//        valor = input.nextInt();
//
//        if (valor % 5 != 0) {
//            System.out.print("O valor não é multiplo de 5.");
//        } else {
//            System.out.println("Valor introduzido: " + valor);
//
//            qtdNotas200 = valor / 200;
//            resto = valor % 200;
//            System.out.println("Notas 200: " + qtdNotas200);
//
//            qtdNotas100 = resto / 100;
//            resto %= 100;
//            System.out.println("Notas 100: " + qtdNotas100);
//
//            qtdNotas50 = resto / 50;
//            resto %= 50;
//            System.out.println("Notas 50: " + qtdNotas50);
//
//            qtdNotas20 = resto / 20;
//            resto %= 20;
//            System.out.println("Notas 20: " + qtdNotas20);
//
//            qtdNotas10 = resto / 10;
//            resto %= 10;
//            System.out.println("Notas 10: " + qtdNotas10);
//
//            qtdNotas5 = resto / 5;
//            resto %= 5;
//            System.out.println("Notas 5: " + qtdNotas5);
//
//        }

        int valor, resto;

        System.out.print("Indique um valor que seja multiplo de 5: ");
        valor = input.nextInt();

        if (valor % 5 != 0) {
            System.out.print("O valor não é multiplo de 5.");
        } else {
            System.out.println("Valor introduzido: " + valor);

            System.out.println("Notas 200: " + (valor / 200));
            resto = valor % 200;

            System.out.println("Notas 100: " + (resto / 100));
            resto %= 100;

            System.out.println("Notas 50: " + (resto / 50));
            resto %= 50;

            System.out.println("Notas 20: " + resto / 20);
            resto %= 20;

            System.out.println("Notas 10: " + (resto / 10));
            resto %= 10;

            System.out.println("Notas 5: " + (resto / 5));

        }

    }
}
