package extra_ficheiros;

public class teste {
    public static void main(String[] args) {
        String palavra = "olá,-";
        String REGEX = "^[a-zA-Z0-9]*$";
        System.out.println(palavra.replaceAll("[-,:;._?!]", ""));
    }
}
