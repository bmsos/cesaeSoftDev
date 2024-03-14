package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File("files/exercicio_09.csv");

        int opcao = 0;
        boolean repeat = true;
        while (repeat) {
            String genero ="", artista ="";
            System.out.print("""
                Menu: 
                1. Pesquisar por género
                2. Pesquisar por artista
                3. Musica com maior duração
                4. Pesquisar por duração
                5. Sair
                
                Opção (1-4):\s""");

            opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.print("Género: ");
                    input.nextLine();
                    genero = input.nextLine();
                    String[][] lista = Ex9Funcoes.pesquisaPorGeneroOuArtista(file, "genero", genero);
                    System.out.print("\n--------------------\n");
                    System.out.println("Resultados da pesquisa: " + lista.length);
                    for (String[] musica : lista) {
                        for (String elemento : musica) {
                            System.out.print(elemento + " | ");
                        }
                        System.out.println();
                    }
                    System.out.print("\n--------------------\n");
                }
                case 2 -> {
                    System.out.print("Artista: ");
                    input.nextLine();
                    artista = input.nextLine();
                    String[][] lista = Ex9Funcoes.pesquisaPorGeneroOuArtista(file, "artista", artista);
                    System.out.print("\n--------------------\n");
                    System.out.println("Resultados da pesquisa: " + lista.length);
                    for (String[] musica : lista) {
                        for (String elemento : musica) {
                            System.out.print(elemento + " | ");
                        }
                        System.out.println();
                    }
                    System.out.print("\n--------------------\n");
                }
                case 3 -> {
                    String[] musica = Ex9Funcoes.musicaComMaiorDuracao(file);
                    System.out.printf("""
                        %nMúsica com maior duração
                        Nome: %s
                        Artista: %s
                        Género: %s
                        Duracao: %s
                        %n ---------------------------- %n
                        """, musica[0], musica[1], musica[2], musica[3]);

                }
                case 4 -> {
                    System.out.println("Indique a duração mínima");
                    System.out.print("Minutos: ");
                    int minutos= input.nextInt();
                    System.out.print("Segundos (restantes): ");
                    int segundos = input.nextInt();
                    int duracao = Ex9Funcoes.converterDuracaoEmSegundos(minutos, segundos);

                    String[][] lista = Ex9Funcoes.musicasComDuracaoSuperior(file, duracao);

                    System.out.print("\n--------------------\n");
                    System.out.println("Resultados da pesquisa: " + lista.length);
                    for (String[] musica : lista) {
                        for (String elemento : musica) {
                            System.out.print(elemento + " | ");
                        }
                        System.out.println();
                    }
                    System.out.print("\n--------------------\n");
                }
                case 5 -> repeat = false;
                default -> System.out.println("Opção Inválida\n");
            }
        }
    }
}
