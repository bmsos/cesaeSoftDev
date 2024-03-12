package ficha03;

public class exercicio07 {

    //  Faça um programa que imprima os números inteiros de 1 a 100 inclusive, e no final imprima também o valor do
    //  seu somatório. (Não necessita de Scanner ou input do utilizador)

    public static void main(String[] args) {
        int n = 1, soma = 0;

        while (n <= 100) {
            System.out.println(n);
            soma += n;
            n++;
        }

        System.out.println("\nSoma = " + soma);
    }
}
