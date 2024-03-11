package ficha06;

public class ex3 {
    // a
    static boolean verificarPar (int n) {
        return n % 2 == 0;
    }

    // b
    static boolean verificarPositivo (int n) {
        return n >= 0;
    }

    // c
    static boolean verificarPrimo (int n) {
        if (n < 0) {
            n -= (n * 2);
        }

        boolean primo = true;
        for (int i=2;i<n;i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }
        return primo;
    }

    // d
    static boolean verificarPerfeito(int n) {
        int soma = 0;
        for (int i=1; i<n; i++) {
            if (n % i == 0) {
                soma += i;
            }
        }
        return soma == n;
    }

    // e
    static boolean verificarTriangular (int n) {
        int soma = 0;
        for (int i=1; i < n; i++) {
            soma += i;

            if (soma == n) {
                return true;
            }

            if (soma > n) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(verificarPar(3));
//        System.out.println(verificarPositivo(3));
//        System.out.println(verificarPrimo(3));
//        System.out.println(verificarPerfeito(6));
//        System.out.println(verificarTriangular(28));
    }
}
