package extra_vetores_matrizes;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = {1, 2, 3, 4, 5, 2, 6, 2, 6, 9, 2, 4};
        int[] duplicados = new int[12];

        int count = 0;
        boolean zeroRepete=false;

        for (int i=0; i<12; i++) {
            for (int j=i+1; j<12; j++) {
                if (lista[i] == lista[j]) {
                    if (lista[i] == 0) {
                        duplicados[count] = lista[i];
                        count++;
                    }
                    boolean jaExiste = false;
                    for (int k=0; k<duplicados.length; k++) {
                            if (lista[i] == duplicados[k]) {
                                jaExiste = true;
                                break;
                            }
                    }
                    if (!jaExiste) {
                        duplicados[count] = lista[i];
                        count++;
                    }

                }
            }
        }

        int[]duplicadosLimpo = new int[count];

        for (int j=0; j< duplicadosLimpo.length;j++) {
            duplicadosLimpo[j] = duplicados[j];
            System.out.print(duplicadosLimpo[j] + ", ");
        }

    }
}
