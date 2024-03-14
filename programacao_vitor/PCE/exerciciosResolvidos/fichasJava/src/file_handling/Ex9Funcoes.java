package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex9Funcoes {
    public static int converterDuracaoEmSegundos (int minutos, int segundos) {
        return (minutos * 60) + segundos;
    }
    public static String[][] pesquisaPorGeneroOuArtista (File file, String filtro, String valorPretendido) throws FileNotFoundException {
        Scanner scRead = new Scanner(file);
        int colunas = scRead.nextLine().split(",").length;
        // verificar quantas linhas vao haver ----------
        int linhas = 0;
        while(scRead.hasNextLine()) {
            String[] linha = scRead.nextLine().split(",");
            String genero = linha[2], artista = linha[1];
            boolean validacaoGenero = filtro.equals("genero") && genero.equalsIgnoreCase(valorPretendido),
                    validacaoArtista = filtro.equals("artista") && artista.equalsIgnoreCase(valorPretendido);

            if (validacaoGenero || validacaoArtista) {
                linhas++;
            }
        }
        // ----------------------
        scRead.close();

        String[][] lista = new String[linhas][colunas];

        Scanner sc = new Scanner(file);
        int index = 0;
        while(sc.hasNextLine()) {
            String[] linha = sc.nextLine().split(",");
            String genero = linha[2], artista = linha[1];
            boolean validacaoGenero = filtro.equals("genero") && genero.equalsIgnoreCase(valorPretendido),
                    validacaoArtista = filtro.equals("artista") && artista.equalsIgnoreCase(valorPretendido);
            if (validacaoGenero || validacaoArtista) {
                lista[index] = linha;
                index++;
            }
        }
        sc.close();
        return lista;
    }

    public static String[] musicaComMaiorDuracao (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String[] musicaComMaiorDuracao = new String[sc.nextLine().split(",").length];
        int maiorDuracao = 0;
        while (sc.hasNextLine()) {
            String[] linha = sc.nextLine().split(",");
            int minutos = Integer.parseInt(linha[3].split(":")[0]);
            int segundos = Integer.parseInt(linha[3].split(":")[1]);
            int duracao = converterDuracaoEmSegundos(minutos, segundos);

            if (duracao > maiorDuracao) {
                maiorDuracao = duracao;
                musicaComMaiorDuracao = linha;
            }
        }
        sc.close();
        return musicaComMaiorDuracao;
    }
    public static String[][] musicasComDuracaoSuperior (File file, int duracaoMinima) throws FileNotFoundException {
        Scanner scRead = new Scanner(file);
        int colunas = scRead.nextLine().split(",").length;
        // verificar quantas linhas vao haver ----------
        int linhas = 0;
        while(scRead.hasNextLine()) {
            String[] linha = scRead.nextLine().split(",");
            int minutos = Integer.parseInt(linha[3].split(":")[0]);
            int segundos = Integer.parseInt(linha[3].split(":")[1]);
            int duracao = converterDuracaoEmSegundos(minutos, segundos);
            if (duracao >= duracaoMinima) {
                linhas++;
            }
        }
        // ----------------------
        scRead.close();

        String[][] lista = new String[linhas][colunas];

        Scanner sc = new Scanner(file);
        sc.nextLine();
        int index = 0;
        while (sc.hasNextLine()) {
            String[] linha = sc.nextLine().split(",");
            int minutos = Integer.parseInt(linha[3].split(":")[0]);
            int segundos = Integer.parseInt(linha[3].split(":")[1]);
            int duracao = converterDuracaoEmSegundos(minutos, segundos);

            if (duracao >= duracaoMinima) {
                lista[index] = linha;
                index++;
            }
        }
        sc.close();
        return lista;
    }
}
