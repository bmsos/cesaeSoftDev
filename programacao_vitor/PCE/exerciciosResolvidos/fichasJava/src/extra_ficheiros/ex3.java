package extra_ficheiros;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ex3 {
    static boolean verificarCredenciais (String username, String password) throws FileNotFoundException {
        File fileLoginHotel = new File("filesExtra/Ex_03 Hotel Temático/loginHotel.txt");
        Scanner scLoginHotel = new Scanner(fileLoginHotel);
        while (scLoginHotel.hasNextLine()) {
            String[] credenciais = scLoginHotel.nextLine().split(";");
            if (username.equals(credenciais[0]) && password.equals(credenciais[1])) {
                return true;
            }
        }
        return false;
    }
    static boolean login () throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem-vindo! Inicie sessão para começar:");
        boolean sessaoIniciada = false;
        String tentarNovamente = "";
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
            do {
                tentarNovamente = input.nextLine().toLowerCase();
                if (tentarNovamente.equals("s") || tentarNovamente.equals("n")) {
                    break;
                }
                System.out.print("Resposta inválida.Tentar novamente? (\"s\" - sim | \"n\" - não): ");
            } while (true);
        } while (tentarNovamente.equals("s"));

        return false;
    }
    static int contarLinhas (File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int linhas = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            linhas++;
        }
        return linhas;
    }
    static String autoIncrementarId (File file, String docIdentifier) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        // numero vai ser auto incrementado (atraves do numero do ultimo registo na lista)
        String lastId = "000000";
        while (sc.hasNextLine()) {
            lastId = sc.nextLine().split(";")[0];
        }
        sc.close();
        lastId = lastId.split("-")[1];
        // "0042".split("0") --> {"", "", "42"}
        String[] purificadorNumero = lastId.split("0");      // criar um array para depois poder acrescentar uma quantidade de zeros à esquerda baseada em length da lista -1
        String newId = docIdentifier;
        for (int i = 0; i< purificadorNumero.length-1; i++) {
            newId += "0";
        }
        newId += Integer.toString(Integer.parseInt(purificadorNumero[purificadorNumero.length-1]) + 1);
        return newId;
    }
    static boolean verificarNumQuartoJaExiste (String num) throws FileNotFoundException {
        File fileQuartosHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        Scanner sc = new Scanner(fileQuartosHotel);
        while (sc.hasNextLine()) {
            String numQuarto = sc.nextLine().split(";")[0];
            if (numQuarto.equals(num)) {
                return true;
            }
        }
        return false;
    }

    // 1. gerir bases de dados
        // 1.1. Gerir clientes
            // 1.1.1. Adicionar novo cliente
    static void adicionarNovoCliente () throws IOException {
        File fileClientesHotel = new File("filesExtra/Ex_03 Hotel Temático/clientesHotel.csv");
        Scanner input = new Scanner(System.in);
        FileWriter fw = new FileWriter(fileClientesHotel, true);
        String cliente = "";
        cliente += (autoIncrementarId(fileClientesHotel, "c-") + ";");
        System.out.print("Nome: ");
        cliente += (input.nextLine() + ";");
        System.out.print("Data de nascimento (DD-MM-YYYY): ");
        cliente += (input.nextLine() + ";");
        System.out.print("Telemóvel (9xxxxxxxx): ");
        cliente += (input.nextLine() + ";");
        System.out.print("Email: ");
        cliente += input.nextLine();
        fw.write(cliente);
        fw.close();
        System.out.println("Cliente adicionado\n");
    }
            // 1.1.2. AtualizarContactosCliente
    static void atualizarContactoCliente (String id) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String tipoContacto = "", novoValor="";

        System.out.print("""
           Atualizar contacto:
           1. Email
           2. Telefone
           """);
        int opcaoAtualizarContacto= 0;
        while (opcaoAtualizarContacto< 1 || opcaoAtualizarContacto> 2) {
            System.out.print("Opção (1-2): ");
            opcaoAtualizarContacto= input.nextInt();

            switch (opcaoAtualizarContacto) {
                case 1 -> {
                    System.out.print("Novo Email: ");
                    input.nextLine();
                    novoValor = input.nextLine();
                    tipoContacto = "email";
                }
                case 2 -> {
                    System.out.print("Novo contacto telefónico: ");
                    input.nextLine();
                    novoValor = input.nextLine();
                    tipoContacto = "telefone";
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        File fileClientesHotel = new File("filesExtra/Ex_03 Hotel Temático/clientesHotel.csv");
        Scanner sc = new Scanner(fileClientesHotel);
        String[] dados = new String[contarLinhas(fileClientesHotel)];

        int index = 0;
        while (sc.hasNextLine()) {
            String cliente = sc.nextLine(),
            idCliente = cliente.split(";")[0];
            if (!idCliente.equals(id)) {
                dados[index] = cliente;
            } else {
                String clienteAtualizado = cliente.split(";")[0] + ";" + cliente.split(";")[1] + ";" + cliente.split(";")[2] + ";";
                if (tipoContacto.equals("telefone")) {
                    clienteAtualizado += (novoValor + ";" + cliente.split(";")[4]);
                } else {    // tipoContacto.equals("email")
                    clienteAtualizado += (cliente.split(";")[3] + ";" + novoValor + ";");
                }
                dados[index] = clienteAtualizado;
            }
            index++;
        }

        PrintWriter pw = new PrintWriter(fileClientesHotel);
        for (String e : dados) {
            pw.println(e);
        }
        pw.close();

    }
        // 1.2. Adicionar Tema
    static void adicionarTema (String nome, String multiplicadorPreco) throws IOException {
        File fileTemasHotel = new File("filesExtra/Ex_03 Hotel Temático/temasHotel.csv");
        String id = autoIncrementarId(fileTemasHotel, "t-"),
        novoTema = id + ";" + nome + ";" + multiplicadorPreco;

        FileWriter fw = new FileWriter(fileTemasHotel, true);
        fw.write(novoTema + "\n");
        fw.close();
    }
        // 1.3. Adicionar quarto
    static void adicionarQuarto (String numQuarto, String tema, String tipologia) throws IOException {
        File fileQuartosHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        String novoQuarto = numQuarto + ";" + tema + ";" + tipologia;

        FileWriter fw = new FileWriter(fileQuartosHotel, true);
        fw.write(novoQuarto + "\n");
        fw.close();
    }
        // 1.4. Autenticação
            // 1.4.1. Registar conta
    static void registarConta (String username, String password) throws IOException {
        File fileLoginHotel = new File("filesExtra/Ex_03 Hotel Temático/loginHotel.txt");
        String linha = username + ";" + password;
        FileWriter fw = new FileWriter(fileLoginHotel, true);
        fw.write(linha + "\n");
        fw.close();
    }
            // 1.4.2. Apagar conta
    static void apagarConta (String usernamePretendido) throws FileNotFoundException {
        File fileLoginHotel = new File("filesExtra/Ex_03 Hotel Temático/loginHotel.txt");
        Scanner sc = new Scanner(fileLoginHotel);

        String[] dados = new String[contarLinhas(fileLoginHotel)-1];
        int index = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine(), username = linha.split(";")[0];
            if (!username.equals(usernamePretendido)) {
                dados[index] = linha;
                index++;
            }
        }
        PrintWriter pw = new PrintWriter(fileLoginHotel);
        for (String e : dados) {
            pw.println(e);
        }
        pw.close();
    }
        // 1.5. Adicionar produto
    static void adicionarProduto (String nome, String precoUnitario) throws IOException {
        File fileProdutosHotel = new File("filesExtra/Ex_03 Hotel Temático/produtosHotel.csv");
        String id = autoIncrementarId(fileProdutosHotel, "p-");

        String novoProduto = id + ";" + nome + ";" + precoUnitario + "\n";

        FileWriter fw = new FileWriter(fileProdutosHotel, true);
        fw.write(novoProduto);
        fw.close();

    }
    // 2. Consultar clientes
    static String[] consultarClientes (String tipoConsulta, String valor) throws FileNotFoundException {
        File fileClientesHotel = new File("filesExtra/Ex_03 Hotel Temático/clientesHotel.csv");
        Scanner sc = new Scanner(fileClientesHotel);
        String resultadoPesquisa = "";
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] dadosCliente = linha.split(";");
            String id = dadosCliente[0], telefone = dadosCliente[3], email = dadosCliente[4];
            if (
                    tipoConsulta.equals("id") && valor.equals(id) ||
                    tipoConsulta.equals("telefone") && valor.equals(telefone) ||
                    tipoConsulta.equals("email") && valor.equals(email)
            ) {
                return dadosCliente;
            }
        }
        return new String[5];
    }
    // 3. Consultar quartos disponíveis
    static String[] quartosDisponiveis () throws FileNotFoundException {
        File fileQuartosHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        Scanner scQuartos = new Scanner(fileQuartosHotel);
        Scanner scReservas = new Scanner(fileReservasHotel);

        String[] quartos = new String[contarLinhas(fileQuartosHotel)],
                reservas = new String[contarLinhas(fileReservasHotel)],
                quartosIndisponiveis = new String[contarLinhas(fileQuartosHotel)];

        int index = 0;
        while (scQuartos.hasNextLine()) {
            quartos[index] = scQuartos.nextLine();
            index++;
        }

        index = 0;
        while (scReservas.hasNextLine()) {
            reservas[index] = scReservas.nextLine();
            index++;
        }

        index = 0;
        for (String quarto : quartos) {
            String numQuarto = quarto.split(";")[0];
            for (String reserva : reservas) {
                if (numQuarto.equals(reserva.split(";")[4])) {
                    quartosIndisponiveis[index] = quarto;
                    index++;
                    break;
                }
            }
        }

        String[] quartosDisponiveis = new String[quartos.length - index];
        index = 0;
        for (String quarto : quartos) {
            if (!Arrays.asList(quartosIndisponiveis).contains(quarto)) {
                quartosDisponiveis[index] = quarto;
                index++;
            }
        }
        scQuartos.close();
        scReservas.close();
        return quartosDisponiveis;
    }
    // 4. Consultar reservas
    static String[] totalReservas () throws FileNotFoundException {
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        Scanner sc = new Scanner(fileReservasHotel);
        String[] totalReservas = new String[contarLinhas(fileReservasHotel)];
        int index = 0;
        while (sc.hasNextLine()) {
            totalReservas[index] = sc.nextLine();
            index++;
        }
        sc.close();
        return totalReservas;
    }
    // 5. Nova reserva
    static void registarReserva (String dataInicio, String dataFim, String cliente, String quarto) throws IOException {
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        String id = autoIncrementarId(fileReservasHotel, "r-a");
        String novaReserva = id + ";" + dataInicio + ";" + dataFim + ";" + cliente + ";" + quarto;

        FileWriter fw = new FileWriter(fileReservasHotel, true);
        fw.write(novaReserva + "\n");
        fw.close();
    }
    // 6. Dashboard
    static int converterDataEmDiasDesde1Janeiro2000 (String data) {
        int totalDias = 0;
        int dia = Integer.parseInt(data.split("/")[0]),
                mes = Integer.parseInt(data.split("/")[1]),
                ano = Integer.parseInt(data.split("/")[2]);

        // adicionar 365 / 366 dias por ano
        for (int i = 2000; i < ano; i++) {
            if (i % 4 == 0) {
                totalDias += 366;
            } else {
                totalDias += 365;
            }
        }

        // adicionar 28/29/30/31 dias por mes
        for (int i = 1; i < mes; i++) {
            switch (i) {
                case 2:
                    if (ano % 4 != 0) {totalDias += 28;} else {totalDias += 29;}
                    break;
                case 4: case 6: case 9: case 11:
                    totalDias += 30;
                    break;
                default: totalDias += 31;
            }
        }

        // adicionar dias restantes
        totalDias += dia;

        return totalDias;
    }
    static double calcularReceitaAnual (String ano) throws FileNotFoundException {
        File fileServicoQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/servicoQuartoHotel.csv");
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        File fileQuartosHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        File fileProdutosHotel = new File("filesExtra/Ex_03 Hotel Temático/produtosHotel.csv");
        File fileTemasHotel = new File("filesExtra/Ex_03 Hotel Temático/temasHotel.csv");

        String[] servicosQuartos = new String[contarLinhas(fileServicoQuartoHotel)];
        String[] reservas = new String[contarLinhas(fileReservasHotel)];
        String[] quartos = new String[contarLinhas(fileQuartosHotel)];
        String[] produtos = new String[contarLinhas(fileProdutosHotel)];
        String[] temas = new String[contarLinhas(fileTemasHotel)];

        Scanner scServicoQuarto = new Scanner(fileServicoQuartoHotel);
        Scanner scReservas = new Scanner(fileReservasHotel);
        Scanner scQuartos = new Scanner(fileQuartosHotel);
        Scanner scProdutos = new Scanner(fileProdutosHotel);
        Scanner scTemas = new Scanner(fileTemasHotel);

        int index = 0;
        while (scServicoQuarto.hasNextLine()) {
            servicosQuartos[index] = scServicoQuarto.nextLine();
            index++;
        }
        index = 0;
        while (scReservas.hasNextLine()) {
            reservas[index] = scReservas.nextLine();
            index++;
        }
        index = 0;
        while (scQuartos.hasNextLine()) {
            quartos[index] = scQuartos.nextLine();
            index++;
        }
        index = 0;
        while (scProdutos.hasNextLine()) {
            produtos[index] = scProdutos.nextLine();
            index++;
        }
        index = 0;
        while (scTemas.hasNextLine()) {
            temas[index] = scTemas.nextLine();
            index++;
        }

        double receitaAnual = 0;

        // 1ª PARTE - Calcular receita anual proveniente dos quartos (precoQuarto * multiplicadorPrecoTema * diasReserva)
        for (String reserva : reservas) {
            String anoReserva = reserva.split(";")[1].split("/")[2];   // reservas em passagem de ano entram na receita do ano de inicio da reserva --> anoReserva = ano da data de inicio
            double precoQuarto = 95, multiplicadorPreco = 1;
            int diasReserva = 0;
            if (anoReserva.equals(ano)) {
                String numQuartoReserva = reserva.split(";")[4],
                dataInicio = reserva.split(";")[1],
                dataFim = reserva.split(";")[2];
                diasReserva = converterDataEmDiasDesde1Janeiro2000(dataFim) - converterDataEmDiasDesde1Janeiro2000(dataInicio);
                for (String quarto : quartos) {     // join do ficheiro reserva com o dos quartos
                    String numQuarto = quarto.split(";")[0],
                    idTemaQuarto = quarto.split(";")[1],
                    tipoQuarto = quarto.split(";")[2];
                    if (numQuarto.equals(numQuartoReserva)) {
                        precoQuarto = switch (tipoQuarto) {
                            case "SUITE" -> 250;
                            case "DOUBLE" -> 110;
                            default -> 95;
                        };
                        for (String tema : temas) {     // join do ficheiro quartos com o dos temas
                            String idTema = tema.split(";")[0];
                            if (idTema.equals(idTemaQuarto)) {
                                multiplicadorPreco = Double.parseDouble(tema.split(";")[2]);
                            }
                        }
                    }
                }
                receitaAnual += precoQuarto * multiplicadorPreco * diasReserva;
            }
        }

        // 2ª PARTE - adicionar à receita anual o valor dos produtos vendidos no serviço de quartos
        // calculo (produtoVendido * qtd) por cada registo de serviço (excluir gorjeta pois assume-se que vai para funcionario)
        for (String servico : servicosQuartos) {
            String idProduto = servico.split(";")[2];
            int qtd = Integer.parseInt(servico.split(";")[3]);
            double precoProduto = 0;
            for (String produto : produtos) {
                String id = produto.split(";")[0];
                if (idProduto.equals(id)) {
                    precoProduto = Double.parseDouble(produto.split(";")[2]);
                }
            }
            receitaAnual += precoProduto * qtd;
        }
        return receitaAnual;
    }
    static double[] calcularDespesaAnual (String ano) throws FileNotFoundException {
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        Scanner scReservas = new Scanner(fileReservasHotel);

        String[] reservas = new String[contarLinhas(fileReservasHotel)];
        int index = 0;
        while (scReservas.hasNextLine()) {
            reservas[index] = scReservas.nextLine();
            index++;
        }
        double despesasLimpeza = 17.5, despesasLuzAgua = 12.75, despesasAdministrativas = 7.25, totalDespesas = 0;
        int dias = 0;
        for (String reserva : reservas) {
            String dataInicio = reserva.split(";")[1],
            dataFim = reserva.split(";")[2],
            anoReserva = dataInicio.split("/")[2];
            if (anoReserva.equals(ano)) {
                dias += (converterDataEmDiasDesde1Janeiro2000(dataFim) - converterDataEmDiasDesde1Janeiro2000(dataInicio));
            }
        }

        despesasLimpeza *= dias;
        despesasLuzAgua *= dias;
        despesasAdministrativas *= dias;
        totalDespesas = despesasLimpeza + despesasLuzAgua + despesasAdministrativas;

        return new double[] {totalDespesas, despesasLimpeza, despesasLuzAgua, despesasAdministrativas};
    }
    static String[] melhorCliente () throws FileNotFoundException {
        File fileClientesHotel = new File("filesExtra/Ex_03 Hotel Temático/clientesHotel.csv");
        return new String[2]; // [0] - cliente | [1] - gasto
    }
    static void mostrarDashboard () throws FileNotFoundException {

        double despesaNoiteLimpeza = 17.5, despesaNoiteLuzAgua = 12.75, despesaNoiteServicosAdministrativos = 7.25;
        System.out.println("-------------------------------------");
        System.out.println("Receita anual: ");
        System.out.printf("\t2022: %s€%n", calcularReceitaAnual("2022"));
        System.out.printf("\t2023: %s€%n", calcularReceitaAnual("2023"));
        System.out.printf("\t2024: %s€%n", calcularReceitaAnual("2024"));
        System.out.println();

        double[][] despesasAnuais = {
                calcularDespesaAnual("2022"),
                calcularDespesaAnual("2023"),
                calcularDespesaAnual("2024")
        };

        System.out.println("Despesa anual: ");
        System.out.printf("\t2022: %s€%n", despesasAnuais[0][0]);
        System.out.printf("\t\tLimpeza: %s€ | Luz/Água: %s€ | Serviços administrativos: %s€%n", despesasAnuais[0][1], despesasAnuais[0][2], despesasAnuais[0][3]);
        System.out.printf("\t2023: %s€%n", despesasAnuais[1][0]);
        System.out.printf("\t\tLimpeza: %s€ | Luz/Água: %s€ | Serviços administrativos: %s€%n", despesasAnuais[1][1], despesasAnuais[1][2], despesasAnuais[1][3]);
        System.out.printf("\t2024: %s€%n", despesasAnuais[2][0]);
        System.out.printf("\t\tLimpeza: %s€ | Luz/Água: %s€ | Serviços administrativos: %s€%n", despesasAnuais[2][1], despesasAnuais[2][2], despesasAnuais[2][3]);
        System.out.println();

        System.out.println("Lucro anual: ");
        System.out.printf("\t2022: %s€%n", calcularReceitaAnual("2022") - calcularDespesaAnual("2022")[0]);
        System.out.printf("\t2023: %s€%n", calcularReceitaAnual("2023") - calcularDespesaAnual("2023")[0]);
        System.out.printf("\t2024: %s€%n", calcularReceitaAnual("2024") - calcularDespesaAnual("2024")[0]);


        System.out.println("-------------------------------------");
    }
    // 7. Mostrar Galeria
    static void mostrarGaleria () throws FileNotFoundException {
        File fileGaleriaFachadaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaFachadaHotel.txt");
        File fileGaleriaQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaQuartoHotel.txt");
        File fileGaleriaSpaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaSpaHotel.txt");

        Scanner scFachada = new Scanner(fileGaleriaFachadaHotel);
        Scanner scQuarto = new Scanner(fileGaleriaQuartoHotel);
        Scanner scSpa = new Scanner((fileGaleriaSpaHotel));

        System.out.println("\n------------------------------- FACHADA -------------------------------------\n");
        while (scFachada.hasNextLine()) {
            System.out.println(scFachada.nextLine());
        }
        System.out.println("\n------------------------------- QUARTO 901 -------------------------------------\n");
        while (scQuarto.hasNextLine()) {
            System.out.println(scQuarto.nextLine());
        }
        System.out.println("\n------------------------------- SPA -------------------------------------\n");
        while (scSpa.hasNextLine()) {
            System.out.println(scSpa.nextLine());
        }
        System.out.println("\n--------------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        try {
            boolean sessaoIniciada = login();
            while (sessaoIniciada) {
                Scanner input = new Scanner(System.in);
                System.out.print("""
                Menu:
                1. Gerir Base de dados
                2. Consultar clientes
                3. Consultar quartos disponiveis
                4. Consultar reservas
                5. Registar nova reserva
                6. Dashboard de Análise
                7. Galeria
                8. Terminar sessão
                """);
                int opcao = 0;
                while (opcao < 1 || opcao > 8) {
                    System.out.print("Opção (1-8): ");
                    opcao = input.nextInt();

                    switch (opcao) {
// 1. Gerir Base de Dados
                        case 1 -> {
                            System.out.print("""
                            \nGerir base de dados:
                            1. Clientes
                            2. Adicionar tema
                            3. Adicionar quarto
                            4. Autenticação
                            5. Adicionar produto
                            """);
                            int opcaoGerirBaseDados = 0;
                            while (opcaoGerirBaseDados < 1 || opcaoGerirBaseDados > 5) {
                                System.out.print("Opção (1-5): ");
                                opcaoGerirBaseDados = input.nextInt();

                                switch (opcaoGerirBaseDados) {
    // 1.1. Gerir clientes
                                    case 1 -> {
                                        System.out.print("""
                                        \nGerir clientes:
                                        1. Adicionar cliente
                                        2. Atualizar contactos do cliente
                                        """);
                                        int opcaoGerirClientes = 0;
                                        while (opcaoGerirClientes < 1 || opcaoGerirClientes > 2) {
                                            System.out.print("Opção (1-2): ");
                                            opcaoGerirClientes = input.nextInt();

                                            switch (opcaoGerirClientes) {
        // 1.1.1. Adicionar cliente
                                                case 1 -> {
                                                    adicionarNovoCliente();
                                                    System.out.println("Cliente adicionado.\n");
                                                }
        // 1.1.2. Atualizar contactos cliente
                                                case 2 -> {
                                                    System.out.print("Id do cliente: ");
                                                    input.nextLine();
                                                    String id = input.nextLine();

                                                    atualizarContactoCliente(id);
                                                    System.out.println("Atualização de dados efetuada\n");
                                                }
                                                default -> System.out.println("Opção inválida.");
                                            }
                                        }
                                    }
    // 1.2. Adicionar tema
                                    case 2 -> {
                                        System.out.print("Nome: ");
                                        input.nextLine();
                                        String nome = input.nextLine();
                                        System.out.print("Multiplicador de preço: ");
                                        String multiplicadorPreco = input.nextLine();

                                        adicionarTema(nome, multiplicadorPreco);
                                        System.out.println("Tema adicionado com sucesso.\n");
                                    }
    // 1.3. Adicionar quarto
                                    case 3 -> {
                                        String numQuarto;
                                        while (true) {
                                            System.out.print("Número do quarto: ");
                                            input.nextLine();
                                            numQuarto = input.nextLine();
                                            if (verificarNumQuartoJaExiste(numQuarto)) {
                                                System.out.println("Número já existe.");
                                            } else {
                                                break;
                                            }
                                        }
                                        System.out.print("Tema: ");
                                        String tema = input.nextLine();
                                        System.out.print("Tipologia: ");
                                        String tipologia = input.nextLine().toUpperCase();

                                        adicionarQuarto(numQuarto, tema, tipologia);
                                        System.out.println("Quarto adicionado com sucesso.\n");
                                    }
    // 1.4. Autenticação
                                    case 4 -> {
                                        System.out.print("""
                                        \nGerir autenticação:
                                        1. Registar conta
                                        2. Apagar conta
                                        """);
                                        int opcaoGerirAutenticacao = 0;
                                        while (opcaoGerirAutenticacao < 1 || opcaoGerirAutenticacao > 2) {
                                            System.out.print("Opção (1-2): ");
                                            opcaoGerirAutenticacao = input.nextInt();
                                            switch (opcaoGerirAutenticacao) {
        // 1.4.1. Registar conta
                                                case 1 -> {
                                                    System.out.print("Username: ");
                                                    input.nextLine();
                                                    String username = input.nextLine();
                                                    System.out.print("Password: ");
                                                    String password = input.nextLine();

                                                    registarConta(username, password);
                                                    System.out.println("Conta registada com sucesso.\n");
                                                }
        // 1.4.2. Apagar conta
                                                case 2 -> {
                                                    System.out.print("Username da conta: ");
                                                    input.nextLine();
                                                    apagarConta(input.nextLine());
                                                    System.out.println("Conta eliminada com sucesso\n");
                                                }
                                                default -> System.out.println("Opção inválida.");
                                            }
                                        }
                                    }
    // 1.5. Adicionar produto
                                    case 5 -> {
                                        System.out.print("Nome do produto: ");
                                        input.nextLine();
                                        String nome = input.nextLine();
                                        System.out.print("Preço unitário: ");
                                        String precoUnitario = input.nextLine();
                                        adicionarProduto(nome, precoUnitario);
                                        System.out.println("Produto adicionado com sucesso.\n");
                                    }
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
// 2. Consultar Clientes
                        case 2 -> {
                            String[] cliente = new String[5];
                            System.out.print("""
                            \nConsultar clientes:
                            1. Por ID
                            2. Por contacto telefonico
                            3. Por email
                            """);
                            int opcaoConsultarClientes = 0;
                            while (opcaoConsultarClientes < 1 || opcaoConsultarClientes > 3) {
                                System.out.print("Opção (1-3): ");
                                opcaoConsultarClientes = input.nextInt();

                                switch (opcaoConsultarClientes) {
    // 2.1. Por ID
                                    case 1 -> {
                                        System.out.print("Id: ");
                                        input.nextLine();
                                        cliente = consultarClientes("id", input.nextLine());
                                    }
    // 2.2. Por telefone
                                    case 2 -> {
                                        System.out.print("Contacto telefónico: ");
                                        input.nextLine();
                                        cliente = consultarClientes("telefone", input.nextLine());
                                    }
    // 2.3. Por email
                                    case 3 -> {
                                        System.out.print("Email: ");
                                        input.nextLine();
                                        cliente = consultarClientes("email", input.nextLine());
                                    }
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                            System.out.printf("""
                            Resultado da pesquisa:
                            Id: %s | Nome: %s | Data de nascimento: %s | Telefone: %s | Email: %s
                            %n""", cliente[0], cliente[1], cliente[2], cliente[3], cliente[4]);
                        }
// 3. Consultar quartos disponíveis
                        case 3 -> {
                            System.out.print("""
                            \nConsultar quartos disponíveis:
                            1. Todos
                            2. Por tema
                            3. Por tipo
                            """);
                            int opcaoConsultarQuartosDisponiveis = 0;
                            while (opcaoConsultarQuartosDisponiveis < 1 || opcaoConsultarQuartosDisponiveis > 3) {
                                System.out.print("Opção (1-3): ");
                                opcaoConsultarQuartosDisponiveis = input.nextInt();

                                switch (opcaoConsultarQuartosDisponiveis) {
    // 3.1. Todos
                                    case 1 -> {
                                        System.out.println("-----------------------");
                                        System.out.println("Quartos disponíveis:");
                                        for (String e : quartosDisponiveis()) {
                                            System.out.println(e);
                                        }
                                        System.out.println("-----------------------\n");
                                    }
    // 3.2. Por tema
                                    case 2 -> {
                                        System.out.print("Tema: ");
                                        input.nextLine();
                                        String tema = input.nextLine();

                                        System.out.println("-----------------------");
                                        System.out.println("Quartos disponíveis com esse tema:");
                                        for (String e : quartosDisponiveis()) {
                                            if(e.split(";")[1].equals(tema)) {
                                                System.out.println(e);
                                            }
                                        }
                                        System.out.println("-----------------------\n");
                                    }
    // 3.3. Por tipo
                                    case 3 -> {
                                        System.out.print("Tipo: ");
                                        input.nextLine();
                                        String tipo = input.nextLine().toUpperCase();

                                        System.out.println("-----------------------");
                                        System.out.println("Quartos disponíveis com esse tema:");
                                        for (String e : quartosDisponiveis()) {
                                            if(e.split(";")[2].equals(tipo)) {
                                                System.out.println(e);
                                            }
                                        }
                                        System.out.println("-----------------------\n");
                                    }
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
// 4. Consultar reservas
                        case 4 -> {
                            System.out.print("""
                            \nConsultar Reservas:
                            1. Histórico de reservas
                            2. Reservas ativas
                            """);
                            int opcaoConsultarReservas = 0;
                            while (opcaoConsultarReservas < 1 || opcaoConsultarReservas > 2) {
                                System.out.print("Opção (1-2): ");
                                opcaoConsultarReservas = input.nextInt();

                                switch (opcaoConsultarReservas) {
        // 4.1. Historico de reservas
                                    case 1 -> {
                                        System.out.println("-----------------------");
                                        System.out.println("Histórico de reservas:");
                                        for (String e : totalReservas()) {
                                            System.out.println(e);
                                        }
                                        System.out.println("-----------------------\n");
                                    }
        // 4.2. Reservas ativas
                                    case 2 -> {
                                        System.out.println("-----------------------");
                                        System.out.println("Reservas ativas:");
                                        LocalDate hoje = LocalDate.now();

                                        for (String e : totalReservas()) {
                                            String[] dataInicioOriginal = e.split(";")[1].split("/");
                                            String[] dataFimOriginal = e.split(";")[2].split("/");

                                            LocalDate dataInicio = LocalDate.parse(dataInicioOriginal[2] + "-" + dataInicioOriginal[1] + "-" + dataInicioOriginal[0]);
                                            LocalDate dataFim = LocalDate.parse(dataFimOriginal[2] + "-" + dataFimOriginal[1] + "-" + dataFimOriginal[0]);
                                            if (dataInicio.isBefore(hoje) && dataFim.isAfter(hoje)) {
                                                System.out.println(e);
                                            }
                                        }
                                        System.out.println("-----------------------\n");
                                    }
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
// 5. Nova reserva
                        case 5 -> {
                            System.out.print("Data de início: ");
                            input.nextLine();
                            String dataInicio = input.nextLine();
                            System.out.print("Data de fim: ");
                            String dataFim = input.nextLine();
                            System.out.print("Cliente: ");
                            String cliente = input.nextLine();
                            System.out.print("Quarto: ");
                            String quarto = input.nextLine();
                            registarReserva(dataInicio, dataFim, cliente, quarto);
                            System.out.println("Reserva criada com sucesso.\n");
                        }
// 6. Dashboard de análise
                        case 6 -> {
                            mostrarDashboard();
                        }
// 7. Galeria
                        case 7 -> {
                            mostrarGaleria();
                        }
                        case 8 -> sessaoIniciada = false;
                        default -> System.out.println("Opção inválida.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}