import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    /**
     * Inicia processo de login
     * @return True: se login válido || False: se login inválido
     * @throws FileNotFoundException - Caso ficheiro de logins não encontrado
     */
    static boolean login() throws FileNotFoundException {
        File fileAdmins = new File("database/GameStart_Admins.csv");
        Scanner scAdmins = new Scanner(fileAdmins);
        Scanner input = new Scanner(System.in);

        System.out.println("Inicie sessão para entrar:");

        String tentarNovamente = "";
        boolean credenciaisValidadas = false;
        do {
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            while (scAdmins.hasNextLine()) {        // loop para validar credenciais
                String[] credenciais = scAdmins.nextLine().split(";");
                if (username.equals(credenciais[0]) && password.equals(credenciais[1])) {
                    credenciaisValidadas = true;
                    break;
                }
            }

            if (!credenciaisValidadas) {
                System.out.print("Login sem sucesso. Tentar novamente? (\"s\" - sim | \"n\" - não): ");
                tentarNovamente = input.nextLine().toLowerCase();

                while (!(tentarNovamente.equals("s") || tentarNovamente.equals("n"))) {       // loop para forçar resposta válida à pergunta "Tentar novamente?"
                    System.out.print("Resposta inválida. Tentar novamente? (\"s\" - sim | \"n\" - não): ");
                    tentarNovamente = input.nextLine().toLowerCase();
                }
            }

        } while(!credenciaisValidadas && tentarNovamente.equals("s"));

        return true;
    }
    public static void main(String[] args) {
        File fileCategorias = new File("database/GameStart_Categorias.csv");
        File fileClientes = new File("database/GameStart_Clientes.csv");
        File fileCopyright = new File("database/GameStart_Copyright.csv");
        File fileVendas = new File("database/GameStart_Vendas.csv");

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("""
        Entrar como: 
        1. administrador
        2. cliente
        Opção (1-2):\s""");
            int tipoVisitante = input.nextInt();

            if (tipoVisitante == 1) {
                login();
            } else {

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
