package extra_vetores_matrizes;

public class ex11 {
    public static void main(String[] args) {
        int[] lista = {1, 7, 3, 4, 5, 2, 6, 2, 6, 8, 2, 9, 1, 0, 3};
        int qtdPares=0, qtdImpares=0;
        for (int i=0; i< lista.length; i++) {
            if(lista[i] % 2 == 0) {
                qtdPares++;
            } else {
                qtdImpares++;
            }
        }
        int indicePares=0, indiceImpares=0;
        int[] listaPares = new int[qtdPares], listaImpares = new int[qtdImpares];

        System.out.print("Lista de pares: ");
        for (int i=0; i<lista.length;i++){
            if(lista[i] % 2 == 0) {
                listaPares[indicePares] = lista[i];
                System.out.print(listaPares[indicePares] + " | ");
                indicePares++;
            }
        }

        System.out.print("\nLista de ímpares: ");
        for (int i=0; i<lista.length;i++){
            if(lista[i] % 2 == 1) {
                listaImpares[indiceImpares] = lista[i];
                System.out.print(listaImpares[indiceImpares] + " | ");
                indiceImpares++;
            }
        }

    }
}
