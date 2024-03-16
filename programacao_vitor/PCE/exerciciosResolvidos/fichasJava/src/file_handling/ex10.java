package file_handling;

import java.io.*;
import java.util.Scanner;

public class ex10 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File("files7/exercicio_10.csv");

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
                
                Opção (1-5):\s""");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> {
                    int opcaoInner=0;
                    while (opcaoInner < 1 || opcaoInner > 6) {
                        System.out.print("""
                        Pesquisar:
                        1. Mostrar todos os formandos
                        2. Pesquisar formando
                        3. Pesquisar formandos por curso
                        4. Aluno mais velho
                        5. Alunos inscritos em mais do que um curso
                        6. Total de formandos
                        
                        Opção (1-6):\s""");
                        opcaoInner = input.nextInt();

                        switch (opcaoInner) {
                            case 1 -> {
                                try {
                                    Scanner sc = new Scanner(file);
                                    System.out.println("--------------------");
                                    while (sc.hasNextLine()) {
                                        System.out.println(sc.nextLine());
                                    }
                                    System.out.println("--------------------");
                                    sc.close();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 2 -> {
                                System.out.print("Nº matrícula: ");
                                input.nextLine();
                                String matriculaPretendida = input.nextLine();
                                String[] formando = Ex10Funcoes.encontrarFormando(file, matriculaPretendida).split(",");

                                System.out.printf("""
                                ---------------------
                                Formando:
                                Nome: %s
                                Matrícula: %s
                                Curso: %s
                                Email: %s
                                Idade: %s
                                ----------------------
                                """, formando[0], formando[1], formando[2], formando[3] ,formando[4]);
                            }
                            case 3 -> {
                                System.out.print("Curso: ");
                                input.nextLine();
                                String cursoPretendido = input.nextLine();
                                String[] formandos = Ex10Funcoes.formandosPorCurso(file, cursoPretendido);

                                System.out.println("--------------");
                                System.out.println("Formandos inscritos no curso: " + formandos.length);
                                for (String formando : formandos) {
                                    System.out.println(formando);
                                }
                                System.out.println("--------------");
                            }
                            case 4 -> {
                                System.out.println("-------------------------");
                                System.out.println("Aluno mais velho: " + Ex10Funcoes.alunoMaisVelho(file).split(",")[0]);
                                System.out.println("Idade: " + Ex10Funcoes.alunoMaisVelho(file).split(",")[4]);
                                System.out.println("-------------------------");
                            }
                            case 5 -> {
                                System.out.println("--------------------");
                                for (String formando : Ex10Funcoes.inscritosEmMultiplosCursos(file)) {
                                    String nome = formando.split(",")[0];
                                    String matricula = formando.split(",")[1];
                                    System.out.printf("Nome: %s | Matrícula: %s%n", nome, matricula);
                                }
                                System.out.println("--------------------");
                            }
                            case 6 -> {
                                System.out.printf("""
                                    ----------------------------
                                    Total de formandos: %s
                                    ----------------------------
                                    """, (Ex10Funcoes.contarLinhasFicheiro(file) - 1));
                            }
                            default -> System.out.println("Opção inválida\n");
                        }
                    }
                }
                case 2 -> {
                    try {
                        Ex10Funcoes.criarFormando(file);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Nº matrícula: ");
                        input.nextLine();
                        String matriculaPretendida = input.nextLine();

                        Ex10Funcoes.editarFormando(file, matriculaPretendida);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Nº matrícula: ");
                        input.nextLine();
                        String matriculaPretendida = input.nextLine();

                        Ex10Funcoes.eliminarFormando(file, matriculaPretendida);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> repeat = false;
                default -> System.out.println("Opção Inválida\n");
            }
        }
    }
}
