package ficha05;

import java.util.Scanner;
import java.util.Scanner;
public class ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lista = new int[10];
        int maiorPar=-1;

        for (int i = 0; i < 10; i++) {
            System.out.printf("Número %s: ", i+1);
            lista[i] = input.nextInt();

            if (lista[i] % 2 == 0) {

                if(maiorPar%2!=0){
                    maiorPar = lista[i];
                }

                if (lista[i] > maiorPar) {
                    maiorPar = lista[i];
                }

            }
        }

        if (maiorPar%2!=0) {
            System.out.println("Não foi inserido qualquer número par");
        } else {
            System.out.printf("Maior número par: %s", maiorPar);
        }
    }
}



//        for (int i = 0; i < 10; i++) {
//            System.out.printf("Número %s: ", i+1);
//            lista[i] = input.nextInt();
//
//            if (lista[i] % 2 == 0) {
//
//                if(!hasPair){
//                    hasPair = true;
//                    maiorPar = lista[i];
//                }
//
//                if (lista[i] > maiorPar) {
//                    maiorPar = lista[i];
//                }
//
//            }
//        }