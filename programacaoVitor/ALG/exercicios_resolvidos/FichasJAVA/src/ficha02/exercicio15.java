package ficha02;

import java.util.Scanner;

public class exercicio15 {

    //  Escreva um programa que leia 3 números, seguidamente deve perguntar ao utilizador se quer ordem crescente
    //  ‘C’ ou decrescente ‘D’, e deve colocar os números no ecrã por ordem decrescente ou crescente de acordo com a escolha.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1, n2, n3, maior=0, menor=0, intermedio=0;

        String ordem;

        System.out.print("Numero 1: ");
        n1 = input.nextInt();
        System.out.print("Numero 2: ");
        n2 = input.nextInt();
        System.out.print("Numero 3: ");
        n3 = input.nextInt();

        input.nextLine();
        System.out.print("Indique a ordem (D - decrescente | C - Crescente): ");
        ordem = input.nextLine();

        if (n1 >= n2 && n1 >= n3) {
            maior = n1;
            if (n2 >= n3) {
                intermedio = n2;
                menor = n3;
            } else {
                intermedio = n3;
                menor = n2;
            }
        }
        if (n2 >= n1 && n2 >= n3) {
            maior = n2;
            if (n1 >= n3) {
                intermedio = n1;
                menor = n3;
            } else {
                intermedio = n3;
                menor = n1;
            }
        }
        if (n3 >= n1 && n3 >= n2) {
            maior = n3;
            if (n1 >= n2) {
                intermedio = n1;
                menor = n2;
            } else {
                intermedio = n2;
                menor = n1;
            }
        }

        switch (ordem) {
            case "D" ->
                    System.out.print(maior + "\t\t" + intermedio + "\t\t" + menor);
            case "C" ->
                    System.out.print(menor + "\t\t" + intermedio + "\t\t" + maior);
            default ->
                    System.out.print("Erro: Indique uma ordem válida (C ou D)");
        }



    }
}
