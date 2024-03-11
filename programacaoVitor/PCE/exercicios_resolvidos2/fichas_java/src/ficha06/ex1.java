package ficha06;
import java.util.Scanner;

public class ex1 {
    static void fazerBarulho (String animal) {
        String barulho;
        barulho = switch (animal.toLowerCase()) {
            case "cão" -> "Au au";
            case "gato" -> "Au au";
            case "peixe" -> "Au au";
            case "vaca" -> "Au au";
            case "porco" -> "Au au";
            default -> "Animal desconhecido";
        };

        System.out.println(barulho);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Animal: ");
        String animal = input.nextLine();
        fazerBarulho(animal);
    }
}
