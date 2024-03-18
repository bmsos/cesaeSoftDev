package extra_ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    static String autoIncrementarId (File file) throws FileNotFoundException {
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
        String newId = "c-";
        for (int i = 0; i< purificadorNumero.length-1; i++) {
            newId += "0";
        }
        newId += Integer.toString(Integer.parseInt(purificadorNumero[purificadorNumero.length-1]) + 1);
        return newId;
    }

    // 1. gerir bases de dados
    // 1.1. Gerir clientes
    // 1.1.1. Adicionar novo cliente
    static void adicionarNovoCliente (File file) throws IOException {
        Scanner input = new Scanner(System.in);
        FileWriter fw = new FileWriter(file, true);
        String cliente = "";
        cliente += (autoIncrementarId(file) + ";");
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

    public static void main(String[] args) throws IOException {
        File fileClientesHotel = new File("filesExtra/Ex_03 Hotel Temático/clientesHotel.csv");
        File fileProdutosHotel = new File("filesExtra/Ex_03 Hotel Temático/produtosHotel.csv");
        File fileQuartosHotel = new File("filesExtra/Ex_03 Hotel Temático/quartosHotel.csv");
        File fileReservasHotel = new File("filesExtra/Ex_03 Hotel Temático/reservasHotel.csv");
        File fileServicoQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/servicoQuartoHotel.csv");
        File fileTemasHotel = new File("filesExtra/Ex_03 Hotel Temático/temasHotel.csv");
        File fileGaleriaFachadaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaFachadaHotel.txt");
        File fileGaleriaQuartoHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaQuartoHotel.txt");
        File fileGaleriaSpaHotel = new File("filesExtra/Ex_03 Hotel Temático/galeriaSpaHotel.txt");

//        try {
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
                    System.out.println("Opção (1-7):");
                    opcao = input.nextInt();

                    switch (opcao) {
// 1. Gerir Base de Dados
                        case 1 -> {
                            System.out.print("""
                            Gerir base de dados:
                            1. Clientes
                            2. Adicionar tema
                            3. Adicionar quarto
                            4. Autenticação
                            5. Adicionar produto
                            """);
                            int opcaoGerirBaseDados = 0;
                            while (opcaoGerirBaseDados < 1 || opcaoGerirBaseDados > 5) {
                                System.out.println("Opção (1-5):");
                                opcaoGerirBaseDados = input.nextInt();

                                switch (opcaoGerirBaseDados) {
    // 1.1. Gerir clientes
                                    case 1 -> {
                                        System.out.print("""
                                        Gerir clientes:
                                        1. Adicionar cliente
                                        2. Atualizar contactos do cliente
                                        """);
                                        int opcaoGerirClientes = 0;
                                        while (opcaoGerirClientes < 1 || opcaoGerirClientes > 2) {
                                            System.out.println("Opção (1-2):");
                                            opcaoGerirClientes = input.nextInt();

                                            switch (opcaoGerirClientes) {
        // 1.1.1. Adicionar cliente
                                                case 1 -> {
                                                    adicionarNovoCliente(fileClientesHotel);
                                                }
        // 1.1.1. Atualizar contactos cliente
                                                case 2 -> {}
                                                default -> System.out.println("Opção inválida.");
                                            }
                                        }
                                    }
                                    case 2 -> {}
                                    case 3 -> {}
                                    case 4 -> {
                                        System.out.print("""
                                        Gerir autenticação:
                                        1. Adicionar credenciais
                                        2. Excluir credenciais
                                        """);
                                        int opcaoGerirAutenticacao = 0;
                                        while (opcaoGerirAutenticacao < 1 || opcaoGerirAutenticacao > 2) {
                                            System.out.println("Opção (1-2):");
                                            opcaoGerirAutenticacao = input.nextInt();

                                            switch (opcaoGerirAutenticacao) {
                                                case 1 -> {}
                                                case 2 -> {}
                                                default -> System.out.println("Opção inválida.");
                                            }
                                        }
                                    }
                                    case 5 -> {}
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.print("""
                            Consultar clientes:
                            1. Por ID
                            2. Por contacto telefonico
                            3. Por email
                            """);
                            int opcaoConsultarClientes = 0;
                            while (opcaoConsultarClientes < 1 || opcaoConsultarClientes > 3) {
                                System.out.println("Opção (1-3):");
                                opcaoConsultarClientes = input.nextInt();

                                switch (opcaoConsultarClientes) {
                                    case 1 -> {}
                                    case 2 -> {}
                                    case 3 -> {}
                                    default -> System.out.println("Opção inválida.");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.print("""
                            Consultar quartos disponíveis:
                            1. Todos
                            2. Por tema
                            3. Por tipo
                            """);
                            int opcaoConsultarQuartosDisponiveis = 0;
                            while (opcaoConsultarQuartosDisponiveis < 1 || opcaoConsultarQuartosDisponiveis > 3) {
                                System.out.println("Opção (1-3):");
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
                            Consultar Reservas:
                            1. Histórico de reservas
                            2. Reservas ativas
                            """);
                            int opcaoConsultarReservas = 0;
                            while (opcaoConsultarReservas < 1 || opcaoConsultarReservas > 2) {
                                System.out.println("Opção (1-2):");
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
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
