package extra_ficheiros;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class teste {
    static int converterDataEmDiasDesde1Janeiro2000 (String data) {
        int totalDias = 0;
        int dia = Integer.parseInt(data.split("/")[0]),
        mes = Integer.parseInt(data.split("/")[1]),
        ano = Integer.parseInt(data.split("/")[2]);

        // adicionar 365 / 366 dias por ano
        for (int i = 2000; i < ano; i++) {
            if (i % 4 == 0) {
                totalDias += 366;
            } else {
                totalDias += 365;
            }
        }

        // adicionar 28/29/30/31 dias por mes
        for (int i = 1; i < mes; i++) {
            switch (i) {
                case 2:
                    if (ano % 4 != 0) {totalDias += 28;} else {totalDias += 29;}
                    break;
                case 4: case 6: case 9: case 11:
                    totalDias += 30;
                    break;
                default: totalDias += 31;
            }
        }

        // adicionar dias restantes
        totalDias += dia;

        return totalDias;
    }
    public static void main(String[] args) {
        String data1 = "20/03/2024",
        data2 = "24/03/2024";


        int data2EmDias = converterDataEmDiasDesde1Janeiro2000(data2),
        data1EmDias = converterDataEmDiasDesde1Janeiro2000(data1);

        System.out.println(data1EmDias);

//        System.out.println(ChronoUnit.DAYS.between(hoje, data));
    }
}
