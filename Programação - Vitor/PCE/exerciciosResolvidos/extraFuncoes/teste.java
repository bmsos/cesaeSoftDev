package extraFuncoes;

public class teste {
    public static void main(String[] args) {
        int posicao = 4;

        int count = 1;
        for (int i=0; i<5; i+=2) {
            for (int j=0; j<5; j+=2) {
                if (count == posicao) {
                    System.out.printf("[%s][%s]", i, j);
                }
                count++;
            }
        }
    }
}
