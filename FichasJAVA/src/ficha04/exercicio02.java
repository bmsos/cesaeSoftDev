package ficha04;
import java.util.Scanner;
public class exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao;
        boolean check = true;

        do {
            System.out.println("""
                    Menu:
                    1. Criar
                    2. Atualizar
                    3. Eliminar
                    4. Sair
                    """);

            System.out.print("Selecione a opção pretendida: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção selecionada: Criar.");
                    break;
                case 2:
                    System.out.println("Opção selecionada: Atualizar.");
                    break;
                case 3:
                    System.out.println("Opção selecionada: Eliminar.");
                    break;
                case 4:
                    check = false;
                    System.out.println("Opção selecionada: Sair.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (check);
    }
}