package extra_ficheiros;

import java.io.*;
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
        String newId = docIdentifier + "-";
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
        cliente += (autoIncrementarId(fileClientesHotel, "c") + ";");
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
        String id = autoIncrementarId(fileTemasHotel, "t"),
        novoTema = id + ";" + nome + ";" + multiplicadorPreco;

        FileWriter fw = new FileWriter(fileTemasHotel, true);
        fw.write(novoTema + "\n");
        fw.close();
    }
        // 1.3. Adicionar quarto
    static void adicionarQuarto (String numQuarto, String tema, String tipologia) throws IOException {
        File fileTemasHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        String novoQuarto = numQuarto + ";" + tema + ";" + tipologia;

        FileWriter fw = new FileWriter(fileTemasHotel, true);
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
        String id = autoIncrementarId(fileProdutosHotel, "p");

        String novoProduto = id + ";" + nome + ";" + precoUnitario + "\n";

        FileWriter fw = new FileWriter(fileProdutosHotel, true);
        fw.write(novoProduto);
        fw.close();

    }
    // 2. Consultar clientes
    static String consultarClientes (String tipoConsulta, String valor) throws FileNotFoundException {
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
                return linha;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        File fileServicoQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/servicoQuartoHotel.csv");
        File fileGaleriaFachadaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaFachadaHotel.txt");
        File fileGaleriaQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaQuartoHotel.txt");
        File fileGaleriaSpaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaSpaHotel.txt");

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
                while (opcao < 1 || opcao > 7) {
                    System.out.print("Opção (1-7): ");
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
                                        String cliente = consultarClientes("id", input.nextLine()),
                                        id = cliente.split(";")[0],
                                        nome = cliente.split(";")[1],
                                        dataNascimento = cliente.split(";")[2],
                                        telefone = cliente.split(";")[3],
                                        email = cliente.split(";")[4];

                                        System.out.printf("""
                                                Resultado da pesquisa:
                                                Id: %s | Nome: %s | Data de nascimento: %s | Telefone: %s | Email: %s
                                                """, id, nome, dataNascimento, telefone, email);
                                    }
    // 2.2. Por telefone
                                    case 2 -> {}
    // 2.3. Por email
                                    case 3 -> {}
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
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
                                    case 1 -> {}
                                    case 2 -> {}
                                    case 3 -> {}
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
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
                                    case 1 -> {}
                                    case 2 -> {}
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
                        case 5 -> {}
                        case 6 -> {}
                        case 7 -> {}
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