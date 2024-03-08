package extra_vetores_matrizes;

public class ex10 {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5, 2, 6, 2, 6, 6, 2, 0};
        int[] duplicados = new int[12];

        int countRepeticoes = 0, valoresRepetidos=0;

        for (int i=0; i<12; i++) {
            for (int j=i+1; j<12; j++) {
                if (lista[i] == lista[j]) {
                    if (lista[i] == 0) {
                        duplicados[countRepeticoes] = lista[i];
                        countRepeticoes++;
                    }
                    boolean jaExiste = false;
                    for (int k=0; k<duplicados.length; k++) {
                        if (lista[i] == duplicados[k]) {
                            jaExiste = true;
                            break;
                        }
                    }
                    if (!jaExiste) {
                        duplicados[countRepeticoes] = lista[i];
                        countRepeticoes++;
                    }
                }
            }
        }
        int[] naoRepetidos = new int[lista.length - countRepeticoes];
        int countNaoRepetidos = 0;
        for (int i=0; i<lista.length; i++) {
            boolean repetido = false;
            for (int j=0; j< countRepeticoes; j++) {
                if (lista[i] == duplicados[j]) {
                    repetido = true;
                }
            }
            if(!repetido) {
                naoRepetidos[countNaoRepetidos] = lista[i];
                countNaoRepetidos++;
            }
        }
        int[] naoRepetidosLimpo = new int[countNaoRepetidos];

        for (int i=0; i<countNaoRepetidos; i++) {
            naoRepetidosLimpo[i] = naoRepetidos[i];
        }

        for (int i=0; i<naoRepetidosLimpo.length; i++) {
            System.out.print(naoRepetidosLimpo[i] + " | ");
        }
    }
}