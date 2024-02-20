package ficha02;

import java.util.Scanner;

public class exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lugar, pontos;

        System.out.print("Indique o seu lugar: ");
        lugar = input.nextInt();

//        switch (lugar) {
//            case 1:
//                pontos = 10;
//                break;
//            case 2:
//                pontos = 8;
//                break;
//            case 3:
//                pontos = 6;
//                break;
//            case 4:
//                pontos = 5;
//                break;
//            case 5:
//                pontos = 4;
//                break;
//            case 6:
//                pontos = 3;
//                break;
//            case 7:
//                pontos = 2;
//                break;
//            case 8:
//                pontos = 1;
//                break;
//            default:
//                pontos = 0;
//        }

        pontos = switch (lugar) {
            case 1 -> 10;
            case 2 -> 8;
            case 3 -> 6;
            case 4 -> 5;
            case 5 -> 4;
            case 6 -> 3;
            case 7 -> 2;
            case 8 -> 1;
            default -> 0;
        };

        System.out.print("Ganhou " + pontos + " pontos.");
    }
}
