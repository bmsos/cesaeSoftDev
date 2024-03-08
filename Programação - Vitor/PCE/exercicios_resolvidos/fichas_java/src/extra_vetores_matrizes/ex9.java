package extra_vetores_matrizes;

public class ex9 {
    public static void main(String[] args) {

        int[] lista = {2, 1, 4, 5, 3, 8, 7, 0, 9, 6};
        int menor, indiceMenor =0, temp;

        for (int i=0; i<lista.length; i++) {
            menor = lista[i];
            for (int j=i+1;j<lista.length; j++) {
                if (lista[j] < menor) {
                    menor = lista[j];
                    indiceMenor = j;
                }
            }

            if(menor != lista[i]) {
                temp = lista[i];
                lista[i] = menor;
                lista[indiceMenor] = temp;
            }
        }

        for (int i=0; i< lista.length; i++) {
            System.out.print(lista[i] + " | ");
        }
    }
}
