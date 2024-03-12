package exceptions;
import java.util.Scanner;
public class teste_exceptions {
    static class Excecao extends Exception {
        Excecao (String s) {
            super(s);
        }
    }
    public static void main(String[] args) throws Excecao {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("Numero: ");
            int n = input.nextInt();

            if (n == 0) {
                throw new Excecao("Nao pode ser zero");
            }
        }
    }
}
