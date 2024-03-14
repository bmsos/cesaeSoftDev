package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex9 {
    static int converterDuracaoEmSegundos (int minutos, int segundos) {
        return (minutos * 60) + segundos;
    }
    static String[] pesquisaPorGenero (File file, String genero) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String[] lista = new String[9];
        return lista;
    }
    static String[] pesquisaPorArtista (File file, String artista) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String[] lista = new String[9];
        return lista;
    }
    static String musicaComMaiorDuracao (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.nextLine();

        int maior = 0;
        while (sc.hasNextLine()) {
            String[] linha = sc.nextLine().split(",");
            int minutos = Integer.parseInt(linha[3].split(":")[0]);
            int segundos = Integer.parseInt(linha[3].split(":")[1]);
            int duracao = converterDuracaoEmSegundos(minutos, segundos);
        }

        return "";
    }
    static String[] musicasComDuracaoSuperior (File file, int duracao) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String[] lista = new String[9];
        return lista;
    }
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
                    genero = input.nextLine();
                    pesquisaPorGenero(file, genero);
                }
                case 2 -> {
                    System.out.print("Artista: ");
                    artista = input.nextLine();
                    pesquisaPorArtista(file, artista);
                }
                case 3 -> {
                    musicaComMaiorDuracao(file);
                }
                case 4 -> {
                    System.out.println("Indique a duração mínima");
                    System.out.print("Minutos: ");
                    int minutos= input.nextInt();
                    System.out.print("Segundos: ");
                    int segundos = input.nextInt();
                    int duracao = converterDuracaoEmSegundos(minutos, segundos);

                    musicasComDuracaoSuperior(file, duracao);
                }
                case 5 -> repeat = false;
                default -> System.out.println("Opção Inválida\n");
            }
        }
    }
}
