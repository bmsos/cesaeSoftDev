import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
    /**
     * Fazer uma pergunta cuja resposta é sim ("s") ou nao ("n") <br>
     * Força uma resposta válida
     * @param pergunta String
     * @return String resposta -> input relativo à pergunta passada como argumento
     */
    public static String perguntaSimOuNao (String pergunta) {
        Scanner input = new Scanner(System.in);

        String resposta = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.print(pergunta);
            resposta = input.nextLine();
            respostaValida = resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n");

            if (!respostaValida) {
                System.out.println("Resposta inválida.");
            }
        }

        return resposta;
    }

    public static void main(String[] args) {
        System.out.println(perguntaSimOuNao("Reservar? (s/n): "));
    }

    /**
     * Verifica se um input é int parsable
     * @param input String
     * @return true: parsable to int | false : not parsable to int
     */
    public static boolean isInt (String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException erro) {
            return false;
        }
    }
    /**
     * Converte os dados de um ficheiro numa matriz (todas as linhas incluindo cabeçalho)
     * @param file
     * @return String[][] - matriz com os dados do ficheiro
     * @throws FileNotFoundException
     */
    public static String[][] converterFicheiroEmMatriz (File file) throws FileNotFoundException {
        int linhas = 0, colunas=0;
        Scanner scRead = new Scanner(file);
        while (scRead.hasNextLine()) {
            String[] linha = scRead.nextLine().split(";");
            colunas = linha.length;
            linhas++;
        }

        String[][] matriz = new String[linhas][colunas];

        Scanner sc = new Scanner(file);
        for (int i=0; sc.hasNextLine(); i++) {
            String[] linha = sc.nextLine().split(";");
            for (int k=0; k<linha.length; k++) {
                matriz[i][k] = linha[k];
            }
        }
        return matriz;
    }

    /**
     * Imprime uma matriz em formato tabela
     * @param matriz - para usar maioritariamente na visualização de ficheiros
     */
    public static void imprimirMatriz (String[][] matriz) {
        for (String[] linha : matriz) {
            for (String elemento : linha) {
                System.out.printf("%s | ", elemento);
            }
            System.out.println();
        }
    }

    /**
     * Metodo usado para imprimir arte gráfica (catalogo grafico e copyright)
     * @param file ficheiro pretendido
     * @throws FileNotFoundException caso ficheiro nao encontrado
     */
    public static void imprimirArteGrafica (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    /**
     * Verifica se numero passado como argumento é triangular
     * @param n numero a avaliar
     * @return true: é triangular | false: nao é triangular
     */
    public static boolean verificarNumTriangular (int n) {
        int soma = 0;
        for (int i=1; i < n; i++) {
            soma += i;

            if (soma == n) {
                return true;
            }

            if (soma > n) {
                break;
            }
        }
        return false;
    }
}
