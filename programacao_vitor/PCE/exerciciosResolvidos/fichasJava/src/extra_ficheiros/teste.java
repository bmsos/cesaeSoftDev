package extra_ficheiros;

import java.time.LocalDate;
import java.util.Arrays;

public class teste {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        LocalDate data = LocalDate.parse("2023-06-02");

        System.out.println(data.isAfter(hoje));
    }
}
