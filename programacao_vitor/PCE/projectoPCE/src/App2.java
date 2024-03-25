import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {
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

            switch (opcao) {
                case 1 -> {
                    try {
                        if (MenuAdmin.login()) {
                            Object MenuAdmin;
                        }
                    } catch (FileNotFoundException erro1) {
                        System.out.println("Erro de conexão ao ficheiro de credenciais.");
                    }
                }
                case 2 -> {}
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        } while (!sair);
    }
}