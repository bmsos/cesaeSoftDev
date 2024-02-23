package ficha03;

public class exercicio07 {
    public static void main(String[] args) {
        int n = 1, soma = 0;

        while (n <= 100) {
            System.out.println(n);
            soma += n;
            n += 1;
        }

        System.out.println("\nSoma = " + soma);
    }
}
