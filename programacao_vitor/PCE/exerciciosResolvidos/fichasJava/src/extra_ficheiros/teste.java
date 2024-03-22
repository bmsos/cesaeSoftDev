package extra_ficheiros;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class teste {
    static int daysOnMonth (int mes, int ano){
    if (mes == 2) { // se for fevereiro
        if (ano % 4 == 0) // se o ano for bisexto (fev tem 29 dias)
            return 29;
        else  // se o ano não for bisexto (fev só tem 28 dias)
            return 28;
    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // se for o mes abril, junho, setembro ou novembro só tem 30 dias no maximo
        return 30;
    }
    else {
        return 31;
    }
}

    public static int countDateDays(String start, String end) {
        int diasTotais = 0;
        String[] dataStart = start.split("/");                  // String da data no formato (dd/mm/yyyy) divida pelo delimitador ("/)
        int dayStart = Integer.parseInt(dataStart[0]), monthStart = Integer.parseInt(dataStart[1]), yearStart = Integer.parseInt(dataStart[2]);  // Passa para inteiro os dias, o mes e o ano

        String[] dataEnd = end.split("/");                      // String da data no formato (dd/mm/yyyy) divida pelo delimitador ("/)
        int dayEnd = Integer.parseInt(dataEnd[0]), monthEnd = Integer.parseInt(dataEnd[1]), yearEnd = Integer.parseInt(dataEnd[2]); // Passa para inteiro os dias, o mes e o ano

        int diastotaisStart = daysOnMonth(monthStart, yearStart) - dayStart;  // subtração aos dias maximos do mês do inicio do intervalo o dia da data para verificar quantos dias falta para terminar o mes
        int diastotaisEnd = dayEnd;

        if (yearStart == yearEnd && monthStart == monthEnd){
            diastotaisEnd = daysOnMonth(dayEnd, monthEnd) - dayEnd;          // subtração aos dias maximos do mês do inicio do intervalo o dia da data para verificar quantos dias falta para terminar o mes
            return diastotaisStart - diastotaisEnd + 1;                         // subtraimos a quantidade de dias que falta para terminar o mes em cada dia das datas e subtraimos para ver a diferença dos dias entre as datas
        }
        else if (yearStart == yearEnd){                                     // calculamos os dias totais dos meses entre o mês da data de inicio e o mês da data de fim
            for (int i = monthStart + 1; i < monthEnd; i++){            // caso o mes de fim seja o mês a seguir ao mês de inicio vai retornar 0 dias
                diasTotais += daysOnMonth(i, yearStart);
            }
            return diasTotais + diastotaisStart + diastotaisEnd + 1;
        }
        else {                                                              // caso o ano não seja igual temos de calcular os dias de cada mês entre o mês a seguir ao mes inicial e o mês anterior ao mês final
            for (int i = yearStart; i <= yearEnd; i ++){
                if (i == yearStart){                // se o ano de inicio calculamos os dias apartir do mes a seguir do mes inicial até ao final do ano
                    for (int k = monthStart + 1; k <= 12; k++ ){
                        diasTotais += daysOnMonth(k, i);
                    }
                } else if (i == yearEnd) {          // se o ano de fim calculamos os dias apartir de janeiro até ao mês do fim do intervalo
                    for (int k = 1; k < monthEnd; k++ ){
                        diasTotais += daysOnMonth(k, i);
                    }
                }
                else {                              // caso exista um ou mais anos pelo meio entre a data inicial e a final, calcualos os dias totais do ano
                    for (int k = 1; k <= 12; k++){
                        diasTotais += daysOnMonth(k, i);
                    }
                }
            }
            return diasTotais + diastotaisStart + diastotaisEnd;
        }
    }
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
        String dataInicio = "20/03/2024",
        dataFim = "24/03/2024";

        System.out.println(countDateDays(dataInicio, dataFim));
        System.out.println(converterDataEmDiasDesde1Janeiro2000(dataFim) - converterDataEmDiasDesde1Janeiro2000(dataInicio));

//        System.out.println(ChronoUnit.DAYS.between(hoje, data));
    }
}
