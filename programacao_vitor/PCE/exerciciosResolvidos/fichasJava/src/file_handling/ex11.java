package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex11 {
    static int contarLinhasFicheiro (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int linhas = 0;
        while(sc.hasNextLine()) {
            sc.nextLine();
            linhas++;
        }
        return linhas;
    }
    public static void main(String[] args) {
        File file = new File("files7/exercicio_11.csv");
        Scanner input = new Scanner(System.in);

        System.out.print("Mes (1-12): ");
        String mesIndicado = input.nextLine();
        System.out.print("Ano (YYYY): ");
        String anoIndicado = input.nextLine();
        String dataIndicada = mesIndicado + "/" + anoIndicado;

        try {
            String[] musicas = new String[contarLinhasFicheiro(file)];
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int index = 0;
            while (sc.hasNextLine()) {
                String linha = sc.nextLine(),
                mes = switch(linha.split(",")[2]) {
                    case "Janeiro" -> "1";
                    case "Fevereiro" -> "2";
                    case "Marco" -> "3";
                    case "Abril" -> "4";
                    case "Maio" -> "5";
                    case "Junho" -> "6";
                    case "Julho" -> "7";
                    case "Agosto" -> "8";
                    case "Setembro" -> "9";
                    case "Outubro" -> "10";
                    case "Novembro" -> "11";
                    default -> "12";
                },
                ano = linha.split(",")[3],
                data = mes + "/" + ano;

                if (data.equals(dataIndicada)) {
                    musicas[index] = linha;
                    index++;
                }
            }
            sc.close();
            System.out.println("\nEventos nesse mês: ");
            for (String elemento : musicas) {
                if (elemento != null) {
                    String[] dados = elemento.split(",");
                    System.out.printf("""
                    Nome: %s | Dia: %s | Lotação: %s
                    """, dados[0], dados[1], dados[4]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
