package ficha06;

public class ex5 {

    // a
    static int maior (int[] vetor) {
        int maior = vetor[0];
        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    // b
    static int menor (int[] vetor) {
        int menor = vetor[0];
        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    // c
    static boolean isCrescente (int[] vetor) {

        for (int i=1; i<vetor.length; i++) {
            if (vetor[i] <= vetor[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] vetor = {1, 4, 4, 6, 9};
        System.out.println(maior(vetor));
        System.out.println(menor(vetor));
        System.out.println(isCrescente(vetor));
    }
}
