package file_handling.training;
// 1. Importar File
import java.io.File;
// 3. Importar PrintWriter para escrever em ficheiros
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class teste_PrintWriter {
    public static void main(String[] args) throws FileNotFoundException {
        // 2. Ler um ficheiro com File library
        File file = new File("C:/Users/softdev/Documents/GitHub/cesaeSoftDev/programacao_vitor/PCE/exerciciosResolvidos/fichasJava/files/teste.txt");

        // 4. Instanciar um writer para o ficheiro em questão
        PrintWriter printWriter = new PrintWriter(file);

        // 5. Usar o writer para escrever texto no ficheiro
        printWriter.println("bem");
        System.out.println("Escreveu no ficheiro");

        // 6. Fechar o ficheiro para poupar recursos
        printWriter.close();
    }
}
