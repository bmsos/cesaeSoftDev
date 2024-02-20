package ficha02;
import java.util.Scanner;
public class exercicio18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double vencimentoBase = 40, subsidioAlimentacao = 5, retencaoIRS = 0.1,
                encargoFuncionario = 0.11, encargoEmpresa = 0.2375,
                valorLiquidoVencimento, totalSubsidioAlimentacao,
                valorEntregaIRS, totalSegSocial, totalLiquido, vencimentoBruto;

        int codigoFunc, nrDias;


        System.out.print("Indique o código do funcionário: ");
        codigoFunc = input.nextInt();
        System.out.print("Quantos dias trabalhou este mês?: ");
        nrDias = input.nextInt();

        totalSubsidioAlimentacao = subsidioAlimentacao * nrDias;
        vencimentoBruto = vencimentoBase * nrDias;
        valorEntregaIRS = vencimentoBruto * retencaoIRS;
        valorLiquidoVencimento = vencimentoBruto * (1- (retencaoIRS + encargoFuncionario));
        totalSegSocial = vencimentoBruto * (encargoEmpresa + encargoFuncionario);
        totalLiquido = valorLiquidoVencimento + totalSubsidioAlimentacao;

        System.out.println("Código do Funcionário: " + codigoFunc);
        System.out.println("Valor líquido fruto do vencimento: " + valorLiquidoVencimento);
        System.out.println("Total subsídio alimentação: " + totalSubsidioAlimentacao);
        System.out.println("Retenção IRS a entregar ao Estado: " + valorEntregaIRS);
        System.out.println("Valor a entregar à Segurança Social: " + totalSegSocial);
        System.out.println("Valor líquido a receber pelo funcionário: " + totalLiquido);


    }
}
