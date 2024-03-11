package extraFuncoes;

import java.util.Scanner;

public class ex9 {
    static String retornarMes (int n) {

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        if (n > 0 && n < 13) {
            return meses[n-1];
        }
        return "Não existe nenhum mês com esse número";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Número: ");
        int n = input.nextInt();

        System.out.println(retornarMes(n));
    }
}
