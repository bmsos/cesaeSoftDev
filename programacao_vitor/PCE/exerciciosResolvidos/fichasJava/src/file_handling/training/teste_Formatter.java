package file_handling.training;
// 1. Importar File
import java.io.File;
import java.io.FileNotFoundException;
// 3. Importar Formatter
import java.util.Formatter;

public class teste_Formatter {
    public static void main(String[] args) throws FileNotFoundException {
        // 2. Ler um ficheiro com File library
        File file = new File("C:/Users/softdev/Documents/GitHub/cesaeSoftDev/programacao_vitor/PCE/exerciciosResolvidos/fichasJava/files/teste.txt");

        // 4. Instanciar um formatter para o ficheiro em questão
        Formatter formatter = new Formatter(file);

        // 5. Usar o formatter para escrever texto no ficheiro
        formatter.format("e contigo");
        System.out.println("Escreveu no ficheiro");

        // 6. Fechar o ficheiro para poupar recursos
        formatter.close();
    }
}
