package file_handling;

import java.io.*;
import java.util.Scanner;

public class Ex10Funcoes {
    public static int contarLinhasFicheiro (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int linhas = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            linhas++;
        }
        sc.close();
        return linhas;
    }
    static String atribuirNumero (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        // numero vai ser auto incrementado (atraves do numero do ultimo formando na lista)
        String lastNumero = "000000";
        while (sc.hasNextLine()) {
            lastNumero = sc.nextLine().split(",")[1];
        }
        sc.close();

        lastNumero = Integer.toString(Integer.parseInt(lastNumero) + 1);
        return lastNumero;
    }
    public static String alunoMaisVelho (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int maiorIdade = 0;
        String formandoMaisVelho = "";

        sc.nextLine(); // retirar cabeçalho
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            int idade = Integer.parseInt(linha.split(",")[4]);
            if (idade > maiorIdade) {
                maiorIdade = idade;
                formandoMaisVelho = linha;
            }
        }
        return formandoMaisVelho;
    }
    public static String encontrarFormando (File file, String matricula) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        String formando = "";
        sc.nextLine(); // retirar cabeçalho
        while(sc.hasNextLine()) {
            String linha = sc.nextLine(),
                    numero = linha.split(",")[1];

            if (numero.equals(matricula)) {
                formando = linha;
                break;
            }
        }

        return formando;
    }
    public static void criarFormando (File file) throws IOException {
        Scanner input = new Scanner(System.in);
        FileWriter fw = new FileWriter(file, true);
        // criar novo formando atraves de string com dados separados por virgulas
        String formando = "";

        System.out.print("Nome: ");
        formando += (input.nextLine() + ",");
        formando += (atribuirNumero(file) + ",");
        System.out.print("Curso: ");
        formando += (input.nextLine() + ",");
        System.out.print("Email: ");
        formando += (input.nextLine() + ",");
        System.out.print("Idade: ");
        formando += (input.nextLine() + "\n");

        fw.write(formando);
        fw.close();
        System.out.println("\n---------------------\n");
    }
    public  static void editarFormando (File file, String matricula) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(file);
        String[] dados = new String[contarLinhasFicheiro(file)];

        int index = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine(),
                    numero = linha.split(",")[1];

            if(numero.equals(matricula)) {
                System.out.println(linha);
                String formando = "";
                System.out.print("Nome: ");
                formando += (input.nextLine() + ",");
                formando += (numero + ",");
                System.out.print("Curso: ");
                formando += (input.nextLine() + ",");
                System.out.print("Email: ");
                formando += (input.nextLine() + ",");
                System.out.print("Idade: ");
                formando += (input.nextLine());

                dados[index] = formando;
            } else {
                dados[index] = linha;
            }
            index++;
        }
        sc.close();
        PrintWriter pw = new PrintWriter(file);
        for (String elemento : dados) {
            pw.println(elemento);
        }
        pw.close();
    }
    public static void eliminarFormando (File file, String matricula) throws FileNotFoundException {
        Scanner scRead = new Scanner(file);

        int linhas = contarLinhasFicheiro(file);
        while (scRead.hasNextLine()) {
            String numero = scRead.nextLine().split(",")[1];
            if(numero.equals(matricula)) {
                linhas--;
            }
        }

        String[] dados = new String[linhas];
        scRead.close();

        Scanner sc = new Scanner(file);
        int index = 0;
        String linhaEliminada = "";
        while (sc.hasNextLine()) {
            String linha = sc.nextLine(),
                    numero = linha.split(",")[1];

            if(numero.equals(matricula)) {
                linhaEliminada = linha;
            } else {
                dados[index] = linha;
                index++;
            }
        }
        System.out.println("Formando eliminado: \n" + linhaEliminada);
        PrintWriter pw = new PrintWriter(file);
        for (String elemento : dados) {
            pw.println(elemento);
        }
        pw.close();
    }
    public static String[] formandosPorCurso (File file, String cursoPesquisado) throws FileNotFoundException {
        Scanner scRead = new Scanner(file);
        int linhas = 0;
        while(scRead.hasNextLine()) {
            String curso = scRead.nextLine().split(",")[2];
            if (cursoPesquisado.equals(curso)) {
                linhas++;
            }
        }
        scRead.close();

        String[] formandos = new String[linhas];
        Scanner sc = new Scanner(file);
        int index = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine(),
            curso = linha.split(",")[2];

            if (curso.equals(cursoPesquisado)) {
                formandos[index] = linha;
                index++;
            }
        }
        return formandos;
    }
    public static String[] inscritosEmMultiplosCursos (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String[] formandos = new String[contarLinhasFicheiro(file)];
        int index = 0;
        while (sc.hasNextLine()) {
            formandos[index] = sc.nextLine();
            index++;
        }

        String[] temp = new String[formandos.length];
        index = 0;
        for (int i =1; i<formandos.length; i++) {
            for (int j = i+1; j< formandos.length; j++) {
                String matriculaI = formandos[i].split(",")[1],
                matriculaJ = formandos[j].split(",")[1];
                if (matriculaI.equals(matriculaJ)) {
                    boolean existeEmTemp = false;
                    for (String elemento : temp) {
                        if (elemento != null) {
                            String matriculaElemento = elemento.split(",")[1];
                            if (matriculaI.equals(matriculaElemento)) {
                                existeEmTemp = true;
                                break;
                            }
                        }
                    }
                    if (!existeEmTemp) {
                        temp[index] = formandos[i];
                        index++;
                        break;
                    }
                }
            }
        }

        String[] inscritosEmMultiplosCursos = new String[index];
        index = 0;
        for (String elemento : temp) {
            if (elemento != null) {
                inscritosEmMultiplosCursos[index] = elemento;
                index++;
            }
        }

        return inscritosEmMultiplosCursos;
    }
}
