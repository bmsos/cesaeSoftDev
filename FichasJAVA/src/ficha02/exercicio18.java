package ficha02;
import java.util.Objects;
import java.util.Scanner;
public class exercicio18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double vencimentoBase=0, subsidioAlimentacao = 7.5, retencaoIRS = 0.1,
                encargoFuncionario = 0.11, encargoEmpresa = 0.2375,
                valorLiquidoVencimento, totalSubsidioAlimentacao,
                valorEntregaIRS, totalSegSocial, totalLiquido, vencimentoBruto;

        int nrDias, codigoFuncionario;

        String cargo;

        System.out.print("Indique o seu código de funcionário): ");
        codigoFuncionario = input.nextInt();
        input.nextLine();
        System.out.print("Indique o seu cargo (E - empregado | C - chefe | A - administrador): ");
        cargo = input.nextLine();
        System.out.print("Quantos dias trabalhou este mês?: ");
        nrDias = input.nextInt();

        switch (cargo) {
            case "E":
                vencimentoBase = 40;
                subsidioAlimentacao = 5;

            case "C":
                vencimentoBase = 60;

            case "A":
                vencimentoBase = 80;
                encargoFuncionario = 0.09;
                encargoEmpresa = 0.21;

            default:
                System.out.print("Por favor indique um cargo válido (E, C, ou D)");
        }

        vencimentoBruto = vencimentoBase * nrDias;

        if (vencimentoBruto > 1000) {
            retencaoIRS = 0.2;
        }

        totalSubsidioAlimentacao = subsidioAlimentacao * nrDias;
        valorEntregaIRS = vencimentoBruto * retencaoIRS;
        totalSegSocial = vencimentoBruto * (encargoEmpresa + encargoFuncionario);
        valorLiquidoVencimento = vencimentoBruto * (1- (retencaoIRS + encargoFuncionario));
        totalLiquido = valorLiquidoVencimento + totalSubsidioAlimentacao;

        System.out.println("Código de funcionário: " + codigoFuncionario);
        System.out.println("Cargo: " + cargo);
        System.out.println("Valor ilíquido fruto do vencimento: " + vencimentoBruto);
        System.out.println("Total subsídio alimentação: " + totalSubsidioAlimentacao);
        System.out.println("Retenção IRS a entregar ao Estado: " + valorEntregaIRS);
        System.out.println("Valor a entregar à Segurança Social: " + totalSegSocial);
        System.out.println("Valor líquido a receber pelo funcionário: " + totalLiquido);


    }
}
