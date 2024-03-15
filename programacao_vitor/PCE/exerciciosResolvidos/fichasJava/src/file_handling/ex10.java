package file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File("files/exercicio_10.csv");

        int opcao = 0;
        boolean repeat = true;
        while (repeat) {
            System.out.print("""
                Menu: 
                1. Pesquisar
                2. Criar formando
                3. Editar formando
                4. Eliminar Formando
                5. Sair
                
                Opção (1-4):\s""");

            opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {

                }
                case 2 -> {
                    try {
                        FileWriter fw = new FileWriter(file, true);
                        Scanner sc = new Scanner(file);
                        // criar novo formando
                        String formando = "";

                        System.out.print("Nome: ");
                        input.nextLine();
                        formando += (input.nextLine() + ",");

                        // numero vai ser auto incrementado (atraves do numero do ultimo formando na lista)
                        String lastNumero;



                        formando += ( numero + ",");
                        System.out.print("Curso: ");
                        formando += (input.nextLine() + ",");
                        System.out.print("Email: ");
                        formando += (input.nextLine() + ",");
                        System.out.print("Idade: ");
                        formando += (input.nextLine() + "\n");
                        fw.write(formando);
                        fw.close();
                        System.out.println("\n---------------------\n");
                    } catch (IOException e) {
                        System.out.println(e);
                    }

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> repeat = false;
                default -> System.out.println("Opção Inválida\n");
            }
        }
    }
}
