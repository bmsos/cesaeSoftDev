package extraFuncoes;

import java.util.Scanner;

public class ex3 {
    static double area (double base, double altura) {
        return base * altura;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Altura: ");
        double base = input.nextDouble();
        System.out.print("Base: ");
        double altura = input.nextDouble();

        System.out.print(area(base, altura));
    }
}
