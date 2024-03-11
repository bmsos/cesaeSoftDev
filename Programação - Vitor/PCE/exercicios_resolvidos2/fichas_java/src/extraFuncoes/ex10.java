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
        System.out.println("Área: " + area + " m2");

        System.out.print("Preço do terreno: ");
        double preco = input.nextDouble();

        double valorMetroQuadrado = preco / area;
        System.out.println("Preço por m2: " + valorMetroQuadrado);

        System.out.print("""
                Tipologia:
                1. Urbano
                2. Urbanizável
                3. Rustico
                """);
        int tipologia = input.nextInt();

        boolean abaixo = false, acima = false;
        double diferenca = 0;

        switch (tipologia) {
            case 1 -> {
                if (valorMetroQuadrado < 450) {
                    abaixo = true;
                    diferenca = 450 - valorMetroQuadrado;
                } else if (valorMetroQuadrado > 750) {
                    acima = true;
                    diferenca = valorMetroQuadrado - 750;
                }
            }
            case 2 -> {
                if (valorMetroQuadrado < 150) {
                    abaixo = true;
                    diferenca = 150 - valorMetroQuadrado;
                } else if (valorMetroQuadrado > 500) {
                    acima = true;
                    diferenca = valorMetroQuadrado - 500;
                }
            }
            case 3 -> {
                if (valorMetroQuadrado < 30) {
                    abaixo = true;
                    diferenca = 30 - valorMetroQuadrado;
                } else if (valorMetroQuadrado > 60) {
                    acima = true;
                    diferenca = valorMetroQuadrado - 60;
                }
            }
            default -> {
                System.out.println("Opção inválida");
            }
        }

        if (abaixo) {
            System.out.printf("O valor está %s€ abaixo do valor de mercado%n", diferenca);
        } else if (acima) {
            System.out.printf("O valor está %s€ acima do valor de mercado%n", diferenca);
        } else {
            System.out.println("O preço está dentro do valor de mercado");
        }
    }
}
