package ficha03;

public class exercicio02 {

    //  Faça um programa que imprima os números pares no intervalo de 1 a 400 inclusive. (Não necessita de Scanner
    //  ou input do utilizador).

    public static void main(String[] args) {
        int n = 1;

        while (n <= 400) {

            if (n % 2 == 0) {
                System.out.println(n);
            }

            n += 1;
        }
    }
}
