import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("JOGO DA VELHA");
        System.out.print("Digite o nome do jogador1: ");
        String nomeJogador1 = scanner.nextLine();
        System.out.print("Digite o nome do jogador2: ");
        String nomeJogador2 = scanner.nextLine();

        System.out.println(nomeJogador1 + " escolha X ou O");
        System.out.print("Sua escolha: ");
        String escolhaJogador1 = scanner.nextLine().toUpperCase();
        String escolhaJogador2 = "";
        if (escolhaJogador1.equalsIgnoreCase("X")){
            escolhaJogador2 = "O";
            System.out.println(nomeJogador1 + " escolheu: " + escolhaJogador1);
            System.out.println(nomeJogador2 + " ficou com: " + escolhaJogador2);
        } else if (escolhaJogador1.equalsIgnoreCase("O")){
            escolhaJogador2 = "X";
            System.out.println(nomeJogador1 + " escolheu: " + escolhaJogador1);
            System.out.println(nomeJogador2 + " ficou com: " + escolhaJogador2);
        }


        String[][] posicoes = new String[3][3];

        while (true) {
            exibirTabuleiro(posicoes);

            System.out.println(nomeJogador1 + ", digite a posição que deseja jogar (linha e coluna): ");
            System.out.print("Linha: ");
            int linha = scanner.nextInt();
            System.out.print("Coluna: ");
            int coluna = scanner.nextInt();

            while (posicoes[linha][coluna] != null) {
                System.out.println("Posição já ocupada. Escolha outra.");
                System.out.print("Linha: ");
                linha = scanner.nextInt();
                System.out.print("Coluna: ");
                coluna = scanner.nextInt();
            }

            posicoes[linha][coluna] = escolhaJogador1;
            exibirTabuleiro(posicoes);

            if (verificarEmpate(posicoes)){
                System.out.println("Empate");
                break;
            }

            if (verificarVencedor(posicoes)){
                System.out.println(nomeJogador1 + " Venceu");
                break;
            }





            System.out.println(nomeJogador2 + ", digite a posição que deseja jogar (linha e coluna): ");
            System.out.print("Linha: ");
            int linhaJogador2 = scanner.nextInt();
            System.out.print("Coluna: ");
            int colunaJogador2 = scanner.nextInt();

            while (posicoes[linhaJogador2][colunaJogador2] != null) {
                System.out.println("Posição já ocupada. Escolha outra.");
                linhaJogador2 = scanner.nextInt();
                colunaJogador2 = scanner.nextInt();
            }

            posicoes[linhaJogador2][colunaJogador2] = escolhaJogador2;


            if (verificarVencedor(posicoes)){
                System.out.println(nomeJogador2 + " Venceu");
                break;
            }



        }
    }

    public static void exibirTabuleiro(String[][] posicoes) {
        System.out.println("Tabuleiro:");

        for (String[] linha : posicoes) {
            for (String celula : linha) {
                System.out.print((celula != null ? celula : "-") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean verificarVencedor(String[][] posicoes) {
        // Verificar linhas
        for (String[] posicao : posicoes) {
            if (posicao[0] != null && posicao[0].equals(posicao[1]) && posicao[1].equals(posicao[2])) {
                System.out.println("Vencedor: " + posicao[0]);
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < posicoes[0].length; j++) {
            if (posicoes[0][j] != null && posicoes[0][j].equals(posicoes[1][j]) && posicoes[1][j].equals(posicoes[2][j])) {
                System.out.println("Vencedor: " + posicoes[0][j]);
                return true;
            }
        }

        // Verificar diagonais
        if (posicoes[0][0] != null && posicoes[0][0].equals(posicoes[1][1]) && posicoes[1][1].equals(posicoes[2][2])) {
            System.out.println("Vencedor: " + posicoes[0][0]);
            return true;
        }

        if (posicoes[0][2] != null && posicoes[0][2].equals(posicoes[1][1]) && posicoes[1][1].equals(posicoes[2][0])) {
            System.out.println("Vencedor: " + posicoes[0][2]);
            return true;
        }


        return false;
    }

    public static boolean verificarEmpate(String[][] posicoes) {
        for (String[] posicao : posicoes) {
            for (String posicao1 : posicao) {
                if (posicao1 == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
