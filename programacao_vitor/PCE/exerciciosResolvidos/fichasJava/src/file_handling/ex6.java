package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("files7/exercicio_06.txt");
        Scanner sc = new Scanner(file);

        int maiorIdade=0; String nomeMaisVelho="";
        for (int i=0; sc.hasNextLine(); i++) {
            String[] linha = sc.nextLine().split(",");
            int idade = Integer.parseInt(linha[1].split(" ")[0]);
            String nome = linha[0];
            if (i==0) {
                maiorIdade = idade;
                nomeMaisVelho = nome;
            } else if (idade > maiorIdade){
                maiorIdade = idade;
                nomeMaisVelho = nome;
            }
        }
        sc.close();

        System.out.printf("%s é a pessoa mais velha, com %s anos de idade.", nomeMaisVelho, maiorIdade);
    }
}
