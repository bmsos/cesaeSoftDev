package extraFuncoes;
import java.util.Scanner;
public class ex11 {

    static String[][] novoJogoGalo () {

        // O e X vão ocupar as seguintes posições:
        // [0][0]   [0][2]  [0][4]
        // [2][0]   [2][2]  [2][4]
        // [4][0]   [4][2]  [4][4]

        String[][] jogo = new String[5][5];

        // logica para usar espaços por default
//        for (int i=0; i<5; i+=2) {
//            for (int j=0; j<5; j+=2) {
//                jogo[i][j] = "    ";
//            }
//        }

        // logica para usar "Pn" por default
        int count = 1;
        for (int i=0; i<5; i+=2) {
            for (int j=0; j<5; j+=2) {
                jogo[i][j] = " P" + count + " ";
                count++;
            }
        }

        for (int i=1; i<5; i+=2) {
            for (int j=0; j<5; j++) {
                jogo[i][j] = " ― ";
            }
        }

        for (int i=0; i<5; i+=2) {
            for (int j=1; j<5; j+=2) {
                jogo[i][j] = " | ";
            }
        }

        return jogo;
    }

    static void mostrarJogo (String[][] jogo) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(jogo[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean verificarEmpate (String[][] jogo) {
        boolean empate = true;
        for (int i=0; i<5; i+=2) {
            for (int j=0; j<5; j+=2) {
                if (!(jogo[i][j].equals(" X  ") || jogo[i][j].equals(" O  "))) {
                    empate = false;
                    break;
                }
            }
            if (!empate) {
                break;
            }
        }

        if (empate) {
            System.out.println("Empataram!\n");
            mostrarJogo(jogo);
        }
        return empate;
    }

    static String verificarHaVencedor (String[][] jogo) {
        String vencedor = "";

        // verificar vitoria por linha
        for (int i=0; i<5; i+=2) {
            if (jogo[i][0].equals(jogo[i][2]) && jogo[i][0].equals(jogo[i][4])) {
                vencedor = jogo[i][0].equals(" X  ") ? "Jogador X" : "Jogador O";
                break;
            }
        }
        // verificar vitoria por coluna
        for (int j=0; j<5; j+=2) {
            if (jogo[0][j].equals(jogo[2][j]) && jogo[0][j].equals(jogo[4][j])) {
                vencedor = jogo[0][j].equals(" X  ") ? "Jogador X" : "Jogador O";
                break;
            }
        }
        // verificar vitoria por diagonal principal
        if (jogo[0][0].equals(jogo[2][2]) && jogo[0][0].equals(jogo[4][4])) {
            vencedor = jogo[0][0].equals(" X  ") ? "Jogador X" : "Jogador O";
        }
        // verificar vitoria por diagonal secundária
        if (jogo[0][4].equals(jogo[2][2]) && jogo[0][4].equals(jogo[4][0])) {
            vencedor = jogo[0][4].equals(" X  ") ? "Jogador X" : "Jogador O";
        }

        if (!vencedor.equals("")) {
            System.out.printf("Vitória do %s!%n%n", vencedor);
            mostrarJogo(jogo);
        }
        return vencedor;
    }

    static String[][] iniciarJogada (String[][] jogo, String jogadorAJogar) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Jogador %s - escolha o número da posição (1-9):%n", jogadorAJogar);
        mostrarJogo(jogo);

        int posicao;
        do {
            System.out.print("Posição: ");
            posicao = input.nextInt();

            String valorAColocar = jogadorAJogar.equals("X") ? " X  " : " O  ";

            switch (posicao) {
                case 1 -> {
                    if (!(jogo[0][0].equals(" X  ") || jogo[0][0].equals(" O  "))) {
                        jogo[0][0] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 2 -> {
                    if (!(jogo[0][2].equals(" X  ") || jogo[0][2].equals(" O  "))) {
                        jogo[0][2] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 3 -> {
                    if (!(jogo[0][4].equals(" X  ") || jogo[0][4].equals(" O  "))) {
                        jogo[0][4] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 4 -> {
                    if (!(jogo[2][0].equals(" X  ") || jogo[2][0].equals(" O  "))) {
                        jogo[2][0] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 5 -> {
                    if (!(jogo[2][2].equals(" X  ") || jogo[2][2].equals(" O  "))) {
                        jogo[2][2] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 6 -> {
                    if (!(jogo[2][4].equals(" X  ") || jogo[2][4].equals(" O  "))) {
                        jogo[2][4] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 7 -> {
                    if (!(jogo[4][0].equals(" X  ") || jogo[4][0].equals(" O  "))) {
                        jogo[4][0] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 8 -> {
                    if (!(jogo[4][2].equals(" X  ") || jogo[4][2].equals(" O  "))) {
                        jogo[4][2] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                case 9 -> {
                    if (!(jogo[4][4].equals(" X  ") || jogo[4][4].equals(" O  "))) {
                        jogo[4][4] = valorAColocar;
                    } else {
                        System.out.println("Posição já foi preenchida");
                        posicao = 0;
                    }
                }
                default -> System.out.println("Posição inválida (apenas de 1 a 9)");
            }
        } while (posicao < 1 || posicao > 9);

        System.out.println();
        return jogo;
    }

    public static void main(String[] args) {

        String[][] jogo = novoJogoGalo();
        boolean haVencedor = false, haEmpate = false;
        String jogadorAJogar = "X";

        while (!haVencedor && !haEmpate) {

            jogo = iniciarJogada(jogo, jogadorAJogar);

            // garantir que, se houver vitoria com o jogo cheio, o empate nao entra junto com a vitoria
            if (!verificarHaVencedor(jogo).equals("")) {
                haVencedor = true;
            } else {
                haEmpate = verificarEmpate(jogo);
            }

            jogadorAJogar = jogadorAJogar.equals("X") ? "O" : "X";
        }
    }
}
