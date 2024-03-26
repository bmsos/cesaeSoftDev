import jdk.jshell.execution.Util;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cliente {
    /**
     * Procedimento para mostrar menu de cliente
     * @throws FileNotFoundException caso ficheiro nao encontrado
     */
    static void mostrarMenu () throws FileNotFoundException {
        String[][] vendas = Utils.converterFicheiroEmMatriz(DBFiles.fileVendas);
        Scanner input = new Scanner(System.in);
        boolean sessaoIniciada = true;

        while (sessaoIniciada) {
            System.out.print("""
            Menu de cliente:
            1. Registar cliente
            2. Procurar estacionamento
            3. Mostrar catálogo
            4. Mostrar Catálogos Gráficos
            5. Mostrar Catálogo Editora
            6. Mostrar Catálogo Categoria
            7. Mostrar jogo mais recente
            8. Terminar sessão de cliente
            """);

            int opcao = 0;
            while (opcao < 1 || opcao > 8) {
                System.out.print("Opção (1-8): ");
                String resposta = input.nextLine();
                opcao = Utils.isInt(resposta) ? Integer.parseInt(resposta) : 0;
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = input.nextLine();
                        System.out.print("Contacto telefónico: ");
                        String telefone = input.nextLine();
                        System.out.print("Email: ");
                        String email = input.nextLine();

                        registarCliente(nome, telefone, email);
                    }
                    case 2 -> {
                        procurarEstacionamento();
                        System.out.println("---------------------------");
                    }
                    case 3 -> {
                        System.out.print("""
                        ---------------------------
                        Catálogo de jogos:
                        Nome | Categoria | Editora | Preço (€)
                        """);
                        Utils.imprimirMatriz(getCatalogo(vendas));
                        System.out.println("---------------------------");
                    }
                    case 4 -> {
                        System.out.print("""
                        \tJogos:
                        \t1. Call of Duty
                        \t2. FIFA
                        \t3. Hollow Knight
                        \t4. Minecraft
                        \t5. Mortal Kombat
                        \t6. Overcooked
                        \t7. The Witcher III
                        """);
                        int opcaoArteGrafica = 0;
                        while (opcaoArteGrafica < 1 || opcaoArteGrafica > 8) {
                            System.out.print("\tOpção (1-7): ");
                            String respostaArteGrafica = input.nextLine();
                            opcaoArteGrafica = Utils.isInt(respostaArteGrafica) ? Integer.parseInt(respostaArteGrafica) : 0;
                            switch (opcaoArteGrafica) {
                                case 1 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileCallOfDuty);
                                    System.out.println("---------------------------");
                                }
                                case 2 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileFifa);
                                    System.out.println("---------------------------");
                                }
                                case 3 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileHollowKnight);
                                    System.out.println("---------------------------");
                                }
                                case 4 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileMinecraft);
                                    System.out.println("---------------------------");
                                }
                                case 5 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileMortalKombat);
                                    System.out.println("---------------------------");
                                }
                                case 6 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileOvercooked);
                                    System.out.println("---------------------------");
                                }
                                case 7 -> {
                                    System.out.println("---------------------------");
                                    Utils.imprimirArteGrafica(DBFiles.fileWitcher3);
                                    System.out.println("---------------------------");
                                }
                                default -> System.out.println("\tOpção inválida");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.print("Editora: ");
                        String editora = input.nextLine();

                        System.out.println("---------------------------");
                        System.out.printf("Catálogo da Editora %s:%n", editora);
                        printCatalogoPorCategoria(getCatalogoFiltrado("editora", editora, vendas));
                        System.out.println("---------------------------");
                    }
                    case 6 -> {
                        System.out.print("Categoria: ");
                        String categoria = input.nextLine();

                        System.out.println("---------------------------");
                        System.out.printf("Catálogo da Categoria %s:%n", categoria);
                        printCatalogoPorEditora(getCatalogoFiltrado("categoria", categoria, vendas));
                        System.out.println("---------------------------");
                    }
                    case 7 -> {
                        String[][] catalogo = getCatalogo(vendas);
                        String[] jogoMaisRecente = catalogo[catalogo.length-1];
                        String nome = jogoMaisRecente[0], categoria = jogoMaisRecente[1], editora = jogoMaisRecente[2], preco = jogoMaisRecente[3];

                        System.out.println("---------------------------");
                        System.out.println("Jogo mais recente:");
                        System.out.printf("""
                        Nome: %s
                        Categoria: %s
                        Editora: %s
                        Preço: %s€
                        """, nome, categoria, editora, preco);
                        System.out.println("---------------------------");
                    }
                    case 8 -> {
                        System.out.println("Sessão terminada.\n");
                        sessaoIniciada = false;
                    }
                    default -> System.out.println("Opção inválida");
                }
            }
        }
    }

    /**
     * Simula um novo registo de cliente (apenas imprime os dados)
     * @param nome String
     * @param telefone String
     * @param email String
     * @throws FileNotFoundException
     */
    static void registarCliente (String nome, String telefone, String email) throws FileNotFoundException {
        System.out.println("---------------------------");
        System.out.println("Cliente registado com sucesso.");
        System.out.printf("Nome: %s | Contacto telefónico: %s | Email: %s%n", nome, telefone, email);
        System.out.println("---------------------------");
    }

    /** Procura um lugar vago (triangular e multiplo de 5) e pergunta se cliente quer reservar esse lugar
     * - se sim, imprime "lugar reservado"
     * - se nao, volta a procurar lugar e pergunta se quer reservar
     *  - repete processo ate reservar lugar ou ate chegar ao lugar 121
     */
    static void procurarEstacionamento () {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------");

        boolean lugarReservado = false;
        int n = 1;
        while (!lugarReservado && n <= 121) {
            if (Utils.verificarNumTriangular(n) && n % 5 == 0) {
                System.out.printf("Lugar %s está de vago.%n", n);
                String resposta = Utils.perguntaSimOuNao("Reservar? (s/n): ");
                lugarReservado = resposta.equals("s");
            }
            n++;
        }
        if (lugarReservado) {
            System.out.printf("%nLugar %s foi reservado para si.%n", n-1);
        } else {
            System.out.println("\nNão há mais lugares de vago.");
            String resposta = Utils.perguntaSimOuNao("Voltar a procurar lugar? (s/n): ");
            if (resposta.equals("s")) {
                procurarEstacionamento();
            }
        }
    }

    /**
     * Analisa todos os jogos no ficheiro vendas e retorna-os numa matriz (exclui os duplicados)
     * @param vendas matriz do ficheiro vendas
     * @return String[][] catalogo de jogos
     */
    static String[][] getCatalogo (String[][] vendas) {
        String[][] jogos = new String[vendas.length-1][4];

        // passar jogos para uma matriz (sem duplicados)
        int index = 0;
        for (int i=1; i<vendas.length; i++) {
            String nomeJogo = vendas[i][4], categoria = vendas[i][3], editora = vendas[i][2], preco = vendas[i][5];

            // verificar se jogo já existe na String[][] jogos
            boolean estaEmJogos = false;
            for (String[] jogo : jogos) {
                if (nomeJogo.equals(jogo[0])) {
                    estaEmJogos = true;
                }
            }
            if (!estaEmJogos) { // passar jogo para String[][] jogos (se ja lá nao estiver)
                jogos[index][0] = nomeJogo;
                jogos[index][1] = categoria;
                jogos[index][2] = editora;
                jogos[index][3] = preco;

                index++;
            }
        }

        String[][] catalogo = new String[index][4]; // matriz de retorno (sem os nulls)
        // passar jogos da primeira para a segunda matriz
        for (int i=0; i< catalogo.length; i++) {
            catalogo[i] = jogos[i];
        }

        return catalogo;
    }

    /**
     * Retorna um catalogo filtrado por editora ou categoria
     * @param tipoFiltro String -> "editora": retorna catalogo de uma editora || "categoria": retorna catalogo de uma categoria
     * @param valorFiltro String -> nome da editora ou categoria (dependendo do tipoFiltro)
     * @param vendas matriz do ficheiro vendas
     * @return String[][] catalogo da editora ou categoria pretendida
     */
    static String[][] getCatalogoFiltrado (String tipoFiltro, String valorFiltro, String[][] vendas) {
        // era possivel retornar uma matriz com 3 colunas (sem editora) mas
        // mantive a editora para uniformizar a estrutura de uma matriz para catalogos (4 colunas)
        String[][] jogosFiltrados = new String[vendas.length-1][4];
        int index = 0;
        for (int i=1; i<vendas.length; i++) {
            String nomeJogo = vendas[i][4], categoria = vendas[i][3], editora = vendas[i][2], preco = vendas[i][5];

            // verificar se jogo já existe na String[][] jogosFiltrados
            boolean foiAdicionado = false;
            for (String[] jogo : jogosFiltrados) {
                if (nomeJogo.equals(jogo[0])) {
                    foiAdicionado = true;
                }
            }

            // passar jogo para String[][] jogosFiltrados (se ja lá nao estiver)
            if (!foiAdicionado) {
                if (tipoFiltro.equals("editora") && editora.equals(valorFiltro)) {
                    jogosFiltrados[index][0] = nomeJogo;
                    jogosFiltrados[index][1] = categoria;
                    jogosFiltrados[index][2] = editora;
                    jogosFiltrados[index][3] = preco;

                    index++;
                }
                if (tipoFiltro.equals("categoria") && categoria.equals(valorFiltro)) {
                    jogosFiltrados[index][0] = nomeJogo;
                    jogosFiltrados[index][1] = categoria;
                    jogosFiltrados[index][2] = editora;
                    jogosFiltrados[index][3] = preco;

                    index++;
                }
            }
        }

        String[][] catalogoFiltrado = new String[index][4]; // matriz de retorno (sem os nulls)
        // passar jogos da primeira para a segunda matriz
        for (int i=0; i< catalogoFiltrado.length; i++) {
            catalogoFiltrado[i] = jogosFiltrados[i];
        }

        return catalogoFiltrado;
    }

    /**
     * Imprime um catálogo de forma organizada por categorias
     * @param catalogo - String[][]
     */
    static void printCatalogoPorCategoria (String[][] catalogo) {
        String[] categorias = new String[catalogo.length];

        // 1º PARTE - criar um array com as categorias disponiveis
        int qtdCategorias = 0;
        for (String[] jogo : catalogo) {
            String categoriaJogo = jogo[1];

            // verificar se categoria já existe na String[] categorias
            boolean foiAdicionado = false;
            for (String elemento : categorias) {
                if (categoriaJogo.equals(elemento)) {
                    foiAdicionado = true;
                }
            }

            if (!foiAdicionado) {
                categorias[qtdCategorias] = categoriaJogo;
                qtdCategorias++;
            }
        }

        // 2ª PARTE - Imprimir jogos por categoria
        for (int i=0; i<qtdCategorias; i++) {
            System.out.println(categorias[i] + ": ");
            for (String[] jogo : catalogo) {
                String categoriaJogo = jogo[1];
                if (categoriaJogo.equals(categorias[i])) {
                    System.out.println(jogo[0]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Imprime um catálogo de forma organizada por editoras
     * @param catalogo - String[][]
     */
    static void printCatalogoPorEditora (String[][] catalogo) {
        String[] editoras = new String[catalogo.length];

        // 1º PARTE - criar um array com as editoras disponiveis
        int qtdEditoras = 0;
        for (String[] jogo : catalogo) {
            String editoraJogo = jogo[2];

            // verificar se categoria já existe na String[] editoras
            boolean foiAdicionado = false;
            for (String elemento : editoras) {
                if (editoraJogo.equals(elemento)) {
                    foiAdicionado = true;
                }
            }

            if (!foiAdicionado) {
                editoras[qtdEditoras] = editoraJogo;
                qtdEditoras++;
            }
        }

        // 2ª PARTE - Imprimir jogos por editora
        for (int i=0; i<qtdEditoras; i++) {
            System.out.println(editoras[i] + ": ");
            for (String[] jogo : catalogo) {
                String editoraJogo = jogo[2];
                if (editoraJogo.equals(editoras[i])) {
                    System.out.println(jogo[0]);
                }
            }
            System.out.println();
        }
    }
}
