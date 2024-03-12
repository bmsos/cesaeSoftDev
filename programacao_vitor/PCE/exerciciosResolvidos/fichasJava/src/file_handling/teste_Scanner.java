package file_handling;
// 1. Importar File
import java.io.File;

import java.io.FileNotFoundException;
// Importar Scanner
import java.util.Scanner;

public class teste_Scanner {
    public static void main(String[] args) throws FileNotFoundException {
        // 2. Importar ficheiro
        File file = new File("files/teste.txt");

        // 4. Instanciar um leitor scanner para o ficheiro em questão
        Scanner scanner = new Scanner(file);

        // 5. Usar o leitor para ler texto do ficheiro
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        // 6. Fechar o ficheiro para poupar recursos
        scanner.close();
    }
}
