package ficha02;
import java.util.Scanner;

public class exercicio12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int opcao;

        System.out.print("""
                Selecione a opção pretendida atraves do respetivo numero:
                1 - Criar
                2 - Atualizar
                3 - Eliminar
                4 - Sair
                """);

        opcao = input.nextInt();

        switch (opcao) {
            case 1 -> System.out.print("Opção selecionada: Criar");
            case 2 -> System.out.print("Opção selecionada: Atualizar");
            case 3 -> System.out.print("Opção selecionada: Eliminar");
            case 4 -> System.out.print("");
            default -> System.out.print("Selecione uma das opções disponíveis");
        }

    }
}
