package extraFuncoes;
import java.util.Scanner;
public class ex10 {
    static double calcularArea () {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Qual a forma do terreno?
                1. Quadrado
                2. Retangulo
                3. Triangular
                4. Circular
                """);
        int forma = input.nextInt();
        double lado, base, altura, raio;
        switch (forma) {
            case 1 -> {
                System.out.print("Lado: ");
                lado = input.nextDouble();
                return lado * lado;
            }
            case 2 -> {
                System.out.print("Base: ");
                base = input.nextDouble();
                System.out.print("Altura: ");
                altura = input.nextDouble();
                return base * altura;
            }
            case 3 -> {
                System.out.print("Base: ");
                base = input.nextDouble();
                System.out.print("Altura: ");
                altura = input.nextDouble();
                return (base * altura) / 2;
            }
            case 4 -> {
                System.out.print("Raio: ");
                raio = input.nextDouble();
                return 3.14 * raio * raio;
            }
            default -> {
                System.out.println("Escolha inválida");
                return -0.1;
            }

        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double area = calcularArea();

        System.out.print("Preço do terreno: ");
        double preco = input.nextDouble();

        double valorMetroQuadrado = preco / area;

        System.out.print("""
                Tipologia:
                1. Urbano
                2. Urbanizável
                3. Rustico
                """);
        int tipologia = input.nextInt();

        switch (tipologia) {
            case 1 -> {
                if (valorMetroQuadrado >= 450 && valorMetroQuadrado <= 750) {
                    System.out.println("O preço está dentro do valor de mercado");
                } else {
                    System.out.println("O preço está fora do valor de mercado");
                }
            }
            case 2 -> {
                if (valorMetroQuadrado >= 150 && valorMetroQuadrado <= 500) {
                    System.out.println("O preço está dentro do valor de mercado");
                } else {
                    System.out.println("O preço está fora do valor de mercado");
                }
            }
            case 3 -> {
                if (valorMetroQuadrado >= 30 && valorMetroQuadrado <= 60) {
                    System.out.println("O preço está dentro do valor de mercado");
                } else {
                    System.out.println("O preço está fora do valor de mercado");
                }
            }
            default -> {
                System.out.println("Opção inválida");
            }
        }
    }
}
