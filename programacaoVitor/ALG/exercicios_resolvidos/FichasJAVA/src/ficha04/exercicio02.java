package ficha04;
import java.util.Scanner;
public class exercicio02 {

    //  Implemente um programa que leia a opção do menu desejada (opções: 1. Criar, 2. Atualizar, 3. Eliminar, 4. Sair).
    //  Se uma das opções 1, 2 e 3 for escolhida, deverá apresentar um texto com a opção escolhida. Caso a escolha
    //  esteja fora das opções válidas, deverá informar o utilizador. De seguida, deverá apresentar novamente o menu
    //  para poder selecionar novas opções até que a opção 4 seja escolhida.

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