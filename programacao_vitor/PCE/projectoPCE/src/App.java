import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
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
            String opcao = input.nextLine();

            try {
                switch (opcao) {
                    case "1" -> {
                        if (Admin.login()) {      // login() já contem a logica necessaria para tratamento de credenciais invalidas
                            Admin.mostrarMenu();
                        }
                    }
                    case "2" -> {
                        Cliente.mostrarMenu();
                    }
                    case "3" -> sair = true;
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
