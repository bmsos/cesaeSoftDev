package ficha06;
import java.util.Scanner;
public class ex6 {
    static int maior (int[] vetor) {
        int maior = vetor[0];
        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    static int menor (int[] vetor) {
        int menor = vetor[0];
        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    static boolean isCrescente (int[] vetor) {

        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] <= vetor[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Análise de um Vetor: ");

        boolean outerCheck = true;
        while (outerCheck) {
            System.out.print("Indique o tamanho do vetor: ");
            int size = input.nextInt();

            int[] vetor = new int[size];
            for (int i=0; i<size; i++) {
                System.out.printf("Número %s: ", (i+1));
                vetor[i] = input.nextInt();
            }

            boolean innerCheck = true;
            while (innerCheck) {
                System.out.print("""
                Escolher análise:
                1. Maior elemento
                2. Menor elemento
                3. Crescente ou Não Crescente
                4. Introduzir outro vetor
                5. Sair
                """);
                int opcao = input.nextInt();

                switch (opcao) {
                    case 1 -> System.out.println(maior(vetor) + "\n");
                    case 2 -> System.out.println(menor(vetor) + "\n");
                    case 3 -> System.out.println(isCrescente(vetor) + "\n");
                    case 4 -> {
                        innerCheck = false;
                    }
                    case 5 -> {
                        innerCheck = false;
                        outerCheck = false;
                    }
                    default -> System.out.println("Opção inválida.");
                };
            }
        }
    }
}
