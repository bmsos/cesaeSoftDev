import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    /**
     * Encapsula a validação de credenciais dentro da funcao login() -
     * criada para possibilitar a reciclagem do scanner do file após login falhado
     * @param username String
     * @param password String
     * @return True: parametros validados | False: parametros nao validados
     * @throws FileNotFoundException ficheiro Admins nao encontrado
     */
    static boolean verificarCredenciais (String username, String password) throws FileNotFoundException {
        Scanner scAdmins = new Scanner(DBFiles.fileAdmins);
        while (scAdmins.hasNextLine()) {
            String[] credenciais = scAdmins.nextLine().split(";");
            if (username.equals(credenciais[0]) && password.equals(credenciais[1])) {
                return true;
            }
        }
        return false;
    }
    /**
     * Inicia processo de login
     * @return True: se login válido || False: se login inválido
     * @throws FileNotFoundException - from verificarCredenciais() - ficheiro de logins não encontrado
     */
    static boolean login() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Inicie sessão para entrar:");

        // verificação de credenciais
        String tentarNovamente;
        do {
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if (verificarCredenciais(username, password)) {
                System.out.println("Sessão iniciada.\n");
                return true;
            }

            System.out.print("Login sem sucesso. Tentar novamente? (\"s\" - sim | \"n\" - não): ");
            tentarNovamente = input.nextLine().toLowerCase();

            // forçar resposta válida à pergunta "Tentar novamente?"
            while (!(tentarNovamente.equals("s") || tentarNovamente.equals("n"))) {
                System.out.print("Resposta inválida. Tentar novamente? (\"s\" - sim | \"n\" - não): ");
                tentarNovamente = input.nextLine().toLowerCase();
            }
        } while(tentarNovamente.equals("s"));

        return false;
    }

    /**
     * Calcular o total de vendas
     * @return int valorTotal
     */
    static double calcularTotalVendas (String[][] vendas) {
        double valorTotal = 0;
        for (int i=1; i<vendas.length; i++) {
            valorTotal += Double.parseDouble(vendas[i][5]);
        }
        return valorTotal;
    }

    /**
     * Calcula o lucro total baseado nas margens de lucro de cada categoria
     * @param vendas matriz do ficheiro vendas
     * @param categorias matriz do ficheiro categorias
     * @return double lucro total
     */
    static double calcularLucroTotal (String[][] vendas, String[][] categorias) {
        double lucro = 0;
        for (int i=1; i<vendas.length; i++) {
            double valorVenda = Double.parseDouble(vendas[i][5]), margemLucro = 0;
            String categoria = vendas[i][3];
            for (int k=1; k<categorias.length; k++) {
                if (categoria.equals(categorias[k][0])) {
                    margemLucro = Double.parseDouble(categorias[k][1]) / 100;
                }
            }
            lucro += valorVenda * margemLucro;
        }
        return lucro;
    }

    /**
     * Apura o jogo mais caro
     * @param vendas matriz do ficheiro vendas
     * @return String[] jogoMaisCaro {nome, categoria, editora, preco}
     */
    static String[] jogoMaisCaro (String[][] vendas) {
        String[] jogoMaisCaro = new String[4];
        String nome = "", categoria = "", editora = "", valor = "";

        // encontrar o maior preco e obter atributos do jogo com esse preço
        double maiorPreco = 0;
        for (int i=1; i<vendas.length; i++) {
            double preco = Double.parseDouble(vendas[i][5]);
            if (preco > maiorPreco) {
                maiorPreco = preco;
                nome = vendas[i][4];
                categoria = vendas[i][3];
                editora = vendas[i][2];
                valor = vendas[i][5];
            }
        }

        // preencher o array jogoMaisCaro com os atributos apurados no passo anterior
        jogoMaisCaro[0] = nome;
        jogoMaisCaro[1] = categoria;
        jogoMaisCaro[2] = editora;
        jogoMaisCaro[3] = valor;

        return jogoMaisCaro;
    }

    /**
     * Retorna todos os compradores dum jogo cujo nome foi passado como argumento
     * @param nomeJogo String
     * @param vendas matriz do ficheiro vendas
     * @param clientes matriz do ficheiro clientes
     * @return String[][] compradores do jogo
     */
    static String[][] compradoresDoJogo (String nomeJogo, String[][] vendas, String[][] clientes) {
        int linhas = 0;
        for (int i=1; i<vendas.length; i++) {
            String nome = vendas[i][4];
            if (nome.equalsIgnoreCase(nomeJogo)) {
                linhas++;
            }
        }

        String[][] compradores = new String[linhas][clientes[0].length];

        int index = 0;
        for (int i=1; i<vendas.length; i++) {
            String nome = vendas[i][4];
            if (nome.equalsIgnoreCase(nomeJogo)) {
                String idCliente = vendas[i][1];
                for (int k=1; k<clientes.length; k++) {
                    String id = clientes[k][0];
                    if (id.equals(idCliente)) {
                        compradores[index] = clientes[k];
                        index++;
                    }
                }
            }
        }

        return compradores;
    }

    /**
     * Retorna o cliente com o ID indicado como argumento
     * @param clientes matriz do ficheiro clientes
     * @param idCliente id do cliente
     * @return String[] cliente
     */
    static String[] pesquisarCliente(String[][] clientes, String idCliente) {
        String[] cliente = new String[clientes[0].length];
        for (int i=1; i<clientes.length; i++) {
            String id = clientes[i][0];
            if(id.equals(idCliente)) {
                cliente = clientes[i];
            }
        }
        return cliente;
    }

    /**
     * Verifica qual/quais os clientes com o maior valor de compras
     * @param vendas matriz do ficheiro vendas
     * @param clientes matriz do ficheiro clientes
     * @return String[][] clientes com o maior gasto em compras
     */
    static String[][] melhoresClientes (String[][] vendas, String[][] clientes) {
        // uma vez que é possivel que multiplos clientes estejam empatados no 1º lugar no ranking de maiores gastos
        // adicionar um coluna para cada registo de venda com o total dos gastos - para se poder mais tarde ver que clientes tiveram esse maior gasto
        String[][] vendasComGastoIndividual = new String[vendas.length-1][vendas[0].length + 1]; // linhas = vendas.length-1 -> para retirar cabeçalho | colunas = vendas[0].length + 1 -> para adicionar coluna dos gastos totais individuais

        // 1ª PARTE
        int index=0;
        double maiorGasto = 0;
        for (int i=1; i<vendas.length; i++) {

            // 1.1. calcular o gasto por cliente (o maior gasto de cada cliente é sempre aquele que é calculado na primeira linha de compra desse cliente)
            double gasto = Double.parseDouble(vendas[i][5]);
            for (int k=i+1; k<vendas.length; k++) {
                if (vendas[i][1].equals(vendas[k][1])) {
                    gasto += Double.parseDouble(vendas[k][5]);
                }
            }

            // 1.2. adicionar o registo de venda (+ totalGastoIndividual) à matriz que vai guardar os gastos de cada cliente
            for (int a=0; a<vendas[0].length; a++) {
                vendasComGastoIndividual[index][a] = vendas[i][a];
            }
            vendasComGastoIndividual[index][vendas[0].length] = Double.toString(gasto);
            index++;

            // 1.3. descobrir qual foi o maior gasto
            if (gasto > maiorGasto) {
                maiorGasto = gasto;
            }
        }

        // 2ª PARTE - cliente(s) que ficaram em 1ª lugar

        // 2.1. Contar nº linhas para a matriz melhoresClientes
        int linhas = 0;
        for (String[] venda : vendasComGastoIndividual) {
            double gasto = Double.parseDouble(venda[6]);
            if (gasto == maiorGasto) {
                linhas++;
            }
        }

        // 2.2. criar a matriz e preenchê-la com o(s) cliente(s) em 1º lugar
        String[][] melhoresClientes = new String[linhas][vendasComGastoIndividual[0].length];
        index = 0;
        for (String[] venda : vendasComGastoIndividual) {
            double gasto = Double.parseDouble(venda[6]);
            if (gasto == maiorGasto) {
                melhoresClientes[index] = venda;
                index++;
            }
        }

        // 3ª PARTE - converter cada linha da matriz melhoresClientes em linhas de clientes
        for (int i=0; i<melhoresClientes.length; i++) {
            String idClienteDaVenda = melhoresClientes[i][1];
            for (int k = 1; k<clientes.length; k++) {
                String idCliente = clientes[k][0];
                if (idClienteDaVenda.equals(idCliente)) {
                    melhoresClientes[i] = clientes[k];
                }
            }
        }

        return melhoresClientes;
    }

    /**
     * Retorna todos os jogos comprados pelo cliente cujo ID foi passado por parametro
     * @param idCliente matriz do ficheiro clientes
     * @param vendas matriz do ficheiro vendas
     * @return String[][] jogos comprados por cliente {nome, categoria, editora, preco}
     */
    static String[][] jogosCompradosPorUmCliente(String idCliente, String[][] vendas) {

        int linhas = 0;
        for (int i=1; i<vendas.length; i++) {
            String idClienteDaVenda = vendas[i][1];
            if (idCliente.equals(idClienteDaVenda)) {
                linhas++;
            }
        }

        String[][] jogos = new String[linhas][4];
        int index = 0;
        for (int i=1; i<vendas.length; i++) {
            String idClienteDaVenda = vendas[i][1];
            if (idCliente.equals(idClienteDaVenda)) {
                jogos[index][0] = vendas[i][4];  // nome
                jogos[index][1] = vendas[i][3];  // categoria
                jogos[index][2] = vendas[i][2];  // editora
                jogos[index][3] = vendas[i][5];  // preco

                index++;
            }
        }

        return jogos;
    }

    /**
     * Encontra a melhor categoria através da receita total * multiplicador
     * @param vendas matriz do ficheiro vendas
     * @param categorias matriz do ficheiro categorias
     * @return String[] melhorCategoria {nomeCategoria, lucroTotalCategoria}
     */
    static String[] melhorCategoria (String[][] vendas, String[][] categorias) {
        String[] melhorCategoria = new String[2];

        double maiorLucroCategoria = 0;
        for (int i = 1; i< vendas.length; i++) {
            String categoria = vendas[i][3];
            double receitaCategoria = Double.parseDouble(vendas[i][5]),
            margemLucro = 1;

            // calcular receita total de cada categoria
            for (int k=i+1; k<vendas.length; k++) {
                if (categoria.equals(vendas[k][3])) {
                    receitaCategoria += Double.parseDouble(vendas[k][5]);
                }
            }
            // verificar qual a margemLucro da categoria
            for (int d=1; d< categorias.length; d++) {
                if (categoria.equals(categorias[d][0])) {
                    margemLucro = Double.parseDouble(categorias[d][1]) / 100;
                }
            }

            double lucroCategoria = receitaCategoria * margemLucro;

            // verificar qual o maior lucro de categoria e atribuir nome e lucroTotal à matriz de retorno
            if (lucroCategoria > maiorLucroCategoria) {
                maiorLucroCategoria = lucroCategoria;
                melhorCategoria[0] = categoria;
                melhorCategoria[1] = Double.toString(lucroCategoria);
            }
        }
        return melhorCategoria;
    }

     /**
     * Avalia quais os 5 jogos que deram mais ou menos lucro (dependendo do @param typeOfSearch) (+ os respetivos lucros)
     * @param typeOfSearch "top" -> Top 5 Jogos | "bottom" -> Bottom 5 jogos
     * @param vendas matriz do ficheiro vendas
     * @param categorias matriz do ficheiro categorias
     * @return String[][] jogos {nome, categoria, editora, lucroTotal}
     */
    static String[][] getTopOrBottom5Jogos (String typeOfSearch, String[][] vendas, String[][] categorias) {
        String[][] jogos = new String[5][4];    // {nome, categoria, editora, lucroJogo} * 5

        int index = 0;
        while (index < 5) { // pára quando o index chegar a 5 (a matriz de retorno está cheia)
            double maiorLucroJogo = 0, lucroJogo = 0,
            menorLucroJogo = Double.parseDouble(vendas[1][5]);   // iniciar menorLucroJogo com a primera receita de vendas (menorLucro nunca vai ser maior);
            String nome = "", categoria = "", editora = "";
            for (int i = 1; i< vendas.length; i++) {
                String nomeJogo = vendas[i][4], categoriaJogo = vendas[i][3];

                // desconsiderar jogo se ja estiver na matriz de retorno
                boolean foiAdicionado = false;
                for (String[] jogo : jogos) {
                    if (nomeJogo.equals(jogo[0])) {
                        foiAdicionado = true;
                        break;
                    }
                }

                if (!foiAdicionado) {

                    // calcular receita total do jogo
                    double receitaJogo = Double.parseDouble(vendas[i][5]), margemLucro = 1;
                    for (int k=i+1; k<vendas.length; k++) {
                        if (nomeJogo.equals(vendas[k][4])) {
                            receitaJogo += Double.parseDouble(vendas[k][5]);
                        }
                    }

                    // verificar margemLucro da respetiva categoria
                    for (int d=1; d< categorias.length; d++) {
                        if (categoriaJogo.equals(categorias[d][0])) {
                            margemLucro = Double.parseDouble(categorias[d][1]) / 100;
                            break;
                        }
                    }

                    lucroJogo = receitaJogo * margemLucro;

                    // apurar o jogo com maior ou menor lucro (dependendo do typeOfSearch) e preencher variaveis com os dados do jogo
                    if (typeOfSearch.equals("top") && lucroJogo > maiorLucroJogo) {
                        maiorLucroJogo = lucroJogo;
                        nome = nomeJogo;
                        categoria = categoriaJogo;
                        editora = vendas[i][2];
                    }
                    if (typeOfSearch.equals("bottom") && lucroJogo < menorLucroJogo) {
                        menorLucroJogo = lucroJogo;
                        nome = nomeJogo;
                        categoria = categoriaJogo;
                        editora = vendas[i][2];
                    }
                }
            }
            // prencher uma posição da matriz de retorno
            jogos[index][0] = nome;
            jogos[index][1] = categoria;
            jogos[index][2] = editora;
            jogos[index][3] = typeOfSearch.equals("top") ? Double.toString(maiorLucroJogo) : Double.toString(menorLucroJogo);
            index++;
        }

        return jogos;
    }

    /**
     * Procedimento para mostrar menu de administrador
     * @throws FileNotFoundException caso ficheiro nao encontrado
     */
    static void mostrarMenuAdmin () throws FileNotFoundException {
        String[][] vendas = Utils.converterFicheiroEmMatriz(DBFiles.fileVendas);
        String[][] clientes = Utils.converterFicheiroEmMatriz(DBFiles.fileClientes);
        String[][] categorias = Utils.converterFicheiroEmMatriz(DBFiles.fileCategorias);

        Scanner input = new Scanner(System.in);
        boolean sessaoIniciada = true;

        while (sessaoIniciada) {
            System.out.print("""
            Menu de administração:
            1.  Consultar ficheiros
            2.  Total de vendas
            3.  Lucro total
            4.  Pesquisar cliente
            5.  Jogo mais caro
            6.  Melhores clientes
            7.  Melhor categoria
            8.  Pesquisar vendas
            9.  Top 5 Jogos
            10. Bottom 5 Jogos
            11. Terminar sessão
            """);
            int opcao = 0;
            while (opcao < 1 || opcao > 11) {
                System.out.print("Opção (1-11): ");
                opcao = input.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.print("""
                        \nConsultar ficheiros:
                        1.  Vendas
                        2.  Clientes
                        3.  Categorias
                        """);
                        int opcaoConsultarFicheiros = 0;
                        while (opcaoConsultarFicheiros < 1 || opcaoConsultarFicheiros > 11) {
                            System.out.print("Opção (1-3): ");
                            opcaoConsultarFicheiros = input.nextInt();
                            switch (opcaoConsultarFicheiros) {
                                case 1 -> {
                                    System.out.println("\nVendas:");
                                    Utils.imprimirMatriz(vendas);
                                    System.out.println();
                                }
                                case 2 -> {
                                    System.out.println("\nClientes:");
                                    Utils.imprimirMatriz(clientes);
                                    System.out.println();
                                }
                                case 3 -> {
                                    System.out.println("\nCategorias:");
                                    Utils.imprimirMatriz(categorias);
                                    System.out.println();
                                }
                                default -> System.out.println("Opção inválida");
                            }
                        }
                    }
                    case 2 -> {
                        System.out.printf("""
                        ---------------------------
                        Vendas efetuadas: %s
                        Valor total das vendas: %s€
                        ---------------------------
                        """, vendas.length - 1, calcularTotalVendas(vendas));
                    }
                    case 3 -> {
                        System.out.printf("""
                        ---------------------------
                        Lucro total: %s€
                        ---------------------------
                        """, calcularLucroTotal(vendas, categorias));
                    }
                    case 4 -> {
                        System.out.print("Id do cliente: ");
                        input.nextLine();   // limpar buffer
                        String idCliente = input.nextLine();

                        String[] cliente = pesquisarCliente(clientes, idCliente);
                        System.out.printf("""
                        ---------------------------
                        Resultado da pesquisa:
                        Id : %s
                        Nome: %s
                        Contacto telefónico: %s
                        Email: %s
                        ---------------------------
                        """, cliente[0], cliente[1], cliente[2], cliente[3]);
                    }
                    case 5 -> {
                        String[] jogoMaisCaro = jogoMaisCaro(vendas);
                        String[][] compradoresJogoMaisCaro = compradoresDoJogo(jogoMaisCaro[0], vendas, clientes);
                        System.out.printf("""
                        ---------------------------
                        Jogo mais caro:
                        Nome : %s
                        Categoria: %s
                        Editora: %s
                        Preço: %s€
                        
                        """, jogoMaisCaro[0], jogoMaisCaro[1], jogoMaisCaro[2], jogoMaisCaro[3]);

                        System.out.printf("Clientes que compraram %s:%n", jogoMaisCaro[0]);
                        for (String[] cliente :  compradoresJogoMaisCaro) {
                            System.out.println(cliente[1]);
                        }
                        System.out.println("---------------------------");

                    }
                    case 6 -> {
                        String[][] melhoresClientes = melhoresClientes(vendas, clientes);
                        System.out.print("""
                        ---------------------------
                        Melhores clientes:
                        """);
                        for (String[] cliente : melhoresClientes) {
                            System.out.printf("Nome: %s | Contacto telefónico: %s | Email: %s%n", cliente[1], cliente[2], cliente[3]);
                            System.out.printf("""
                            Jogos comprados por %s:
                            Nome | Categoria | Editora | Preço (€)
                            """, cliente[1]);
                            Utils.imprimirMatriz(jogosCompradosPorUmCliente(cliente[0], vendas));
                            System.out.println();
                        }
                        System.out.println("---------------------------");
                    }
                    case 7 -> {
                        String[] melhorCategoria = melhorCategoria(vendas, categorias);
                        System.out.printf("""
                        ---------------------------
                        Melhor categoria: %s
                        Lucro gerado: %s€
                        ---------------------------
                        """, melhorCategoria[0], melhorCategoria[1]);

                    }
                    case 8 -> {
                        System.out.print("Nome do jogo: ");
                        input.nextLine();
                        String nomeJogo = input.nextLine();
                        String[][] compradores = compradoresDoJogo(nomeJogo, vendas, clientes);
                        System.out.print("""
                        Compradores:
                        Nome | Contacto Telefónico | Email
                        """);
                        for (String[] cliente : compradores) {
                            System.out.printf("%s | %s | %s%n", cliente[1], cliente[2], cliente[3]);
                        }
                        System.out.println("---------------------------");

                    }
                    case 9 -> {
                        System.out.print("""
                        ---------------------------
                        Top 5 Jogos:
                        Nome | Categoria | Editora | Lucro Gerado (€)
                        """);
                        Utils.imprimirMatriz(getTopOrBottom5Jogos("top", vendas, categorias));
                        System.out.println("---------------------------");
                    }
                    case 10 -> {
                        System.out.print("""
                        ---------------------------
                        Bottom 5 Jogos:
                        Nome | Categoria | Editora | Lucro Gerado (€)
                        """);
                        Utils.imprimirMatriz(getTopOrBottom5Jogos("bottom", vendas, categorias));
                        System.out.println("---------------------------");
                    }
                    case 11 -> {
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

                // forçar resposta valida
                String resposta = "";
                boolean respostaValida = false;
                while (!respostaValida) {
                    System.out.print("Reservar? (s/n): ");
                    resposta = input.nextLine();
                    respostaValida = resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n");

                    if (!respostaValida) {
                        System.out.println("Resposta inválida.");
                    }
                }
                lugarReservado = resposta.equals("s");
            }
            n++;
        }
        if (lugarReservado) {
            System.out.printf("Lugar %s foi reservado para si.%n", n-1);
        } else {
            System.out.println("Não há mais lugares de vago.");

            // forçar resposta válida
            String resposta = "";
            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.print("Voltar a procurar lugar? (s/n): ");
                resposta = input.nextLine();
                respostaValida = resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n");

                if (!respostaValida) {
                    System.out.println("Resposta inválida.");
                }
            }
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

    /**
     * Procedimento para mostrar menu de cliente
     * @throws FileNotFoundException caso ficheiro nao encontrado
     */
    static void mostrarMenuCliente () throws FileNotFoundException {
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
                opcao = input.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        input.nextLine();
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
                            opcaoArteGrafica = input.nextInt();
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
                        input.nextLine();
                        String editora = input.nextLine();

                        System.out.println("---------------------------");
                        System.out.printf("Catálogo da Editora %s:%n", editora);
                        printCatalogoPorCategoria(getCatalogoFiltrado("editora", editora, vendas));
                        System.out.println("---------------------------");
                    }
                    case 6 -> {
                        System.out.print("Categoria: ");
                        input.nextLine();
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean sair = false;
        do {
            System.out.print("""
            Entrar como:
            1. Administrador
            2. Cliente
            3. Sair
            """);

            // validar se input é int-parsable ----------
            int opcao = 0;
            boolean respostaNumerica = false;
            while (!respostaNumerica) {
                System.out.print("Opção (1-3): ");
                try {
                    opcao = input.nextInt();
                    respostaNumerica = true;
                } catch (InputMismatchException erro) {
                    System.out.println("Resposta deve ser numérica.");
                    input.nextLine(); // clean buffer
                }
            }
            // ----------------------------------------

            try {
                switch (opcao) {
                    case 1 -> {
                        if (login()) {      // login() já contem a logica necessaria para tratamento de credenciais invalidas
                            mostrarMenuAdmin();
                        }
                    }
                    case 2 -> {
                        mostrarMenuCliente();
                    }
                    case 3 -> sair = true;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (FileNotFoundException erro) {
                System.out.println("Não foi possível verificar os dados. Estamos a tratar do problema!");
            }
        } while (!sair);

        try {
            Utils.imprimirArteGrafica(DBFiles.fileCopyright);
        } catch (FileNotFoundException erro) {
            System.out.println("---------------------------");
            System.out.println("Desenvolvido por:");
            System.out.println("Bruno Oliveira Santos");
            System.out.println("Software Developer - CESAE");
            System.out.println("---------------------------");
        }


    }
}
