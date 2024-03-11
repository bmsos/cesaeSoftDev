package ficha06;
import java.util.Scanner;
public class ex4 {
    static boolean verificarPar (int n) {
        return n % 2 == 0;
    }

    static boolean verificarPositivo (int n) {
        return n >= 0;
    }

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

    static boolean verificarPerfeito(int n) {
        int soma = 0;
        for (int i=1; i<n; i++) {
            if (n % i == 0) {
                soma += i;
            }
        }
        return soma == n;
    }

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
        Scanner input = new Scanner(System.in);

        boolean outerCheck = true;
        while (outerCheck) {
            System.out.print("Análise de um Número: ");
            int n = input.nextInt();

            boolean innerCheck = true;
            while (innerCheck) {
                System.out.print("""
                Escolher análise:
                1. Par ou Ímpar
                2. Positivo ou Negativo
                3. Primo ou Não Primo
                4. Perfeito ou Não Perfeito
                5. Triangular ou Não Triangular
                6. Trocar de número
                7. Sair
                """);
                int opcao = input.nextInt();

                switch (opcao) {
                    case 1 -> System.out.println(verificarPar(n) + "\n");
                    case 2 -> System.out.println(verificarPositivo(n) + "\n");
                    case 3 -> System.out.println(verificarPrimo(n) + "\n");
                    case 4 -> System.out.println(verificarPerfeito(n) + "\n");
                    case 5 -> System.out.println(verificarTriangular(n) + "\n");
                    case 6 -> {
                        innerCheck = false;
                    }
                    case 7 -> {
                        innerCheck = false;
                        outerCheck = false;
                    }
                    default -> System.out.println("Opção inválida.");
                };
            }
        }
    }
}
