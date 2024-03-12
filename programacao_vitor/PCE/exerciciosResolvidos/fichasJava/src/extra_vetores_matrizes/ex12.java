package extra_vetores_matrizes;

public class ex12 {
    public static void main(String[] args) {
        int[] l1 = {1, 2, 3, 0, 1, 6, 7, 8},
            l2 = {9, 1, 0, 1, 13, 6, 15, 16},
            listaIguais = new int[8];

        int countIguais = 0;

        for (int i = 0; i < l1.length; i++) {
            boolean valorL2JaAvaliado = false;
                for (int j = 0; j < l2.length; j++) {
                    if (l1[i] == l2[j] && !valorL2JaAvaliado) {
                        listaIguais[countIguais] = l1[i];
                        countIguais++;
                        valorL2JaAvaliado = true;
                    }
                }
        }

        int[] listaIguaisSemRepetidos = new int [countIguais];
        int countIguaisSemRepetidos = 0;

        for (int i=0; i<countIguais; i++) {
            boolean repetido = false;
            for (int j =i+1; j<countIguais; j++) {
                if (listaIguais[i] == listaIguais[j]) {
                    repetido = true;
                }
            }
            if (!repetido) {
                listaIguaisSemRepetidos[countIguaisSemRepetidos] = listaIguais[i];
                countIguaisSemRepetidos++;
            }
        }

        int[] listaIguaisSemRepetidosLimpa = new int[countIguaisSemRepetidos];

        // limpar os zeros e passar os alores para o vetor final
        for (int i=0; i<countIguaisSemRepetidos; i++) {
            listaIguaisSemRepetidosLimpa[i] = listaIguaisSemRepetidos[i];
        }

        // imprimir o vetor final
        for (int i=0; i< listaIguaisSemRepetidosLimpa.length; i++) {
            System.out.print(listaIguaisSemRepetidosLimpa[i] + ", ");
        }


    }
}
