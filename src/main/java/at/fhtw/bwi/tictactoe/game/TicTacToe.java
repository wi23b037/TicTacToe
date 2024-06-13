package at.fhtw.bwi.tictactoe.game;

import java.util.Scanner;

public class TicTacToe {
    Player player1;
    private Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board.cells[i][0] == marker && board.cells[i][1] == marker && board.cells[i][2] == marker) ||
                    (board.cells[0][i] == marker && board.cells[1][i] == marker && board.cells[2][i] == marker)) {
                return true;
            }
        }
        if ((board.cells[0][0] == marker && board.cells[1][1] == marker && board.cells[2][2] == marker) ||
                (board.cells[0][2] == marker && board.cells[1][1] == marker && board.cells[2][0] == marker)) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        return board.isFull() && !hasWinner();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            start();
            board.print();
            while (true) {
                System.out.println("Current Player: " + currentPlayer.getMarker());
                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();
                if (board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());
                    board.print();
                    if (hasWinner()) {
                        System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                        break;
                    } else if (isDraw()) {
                        System.out.println("The game is a draw!");
                        break;
                    }
                    switchCurrentPlayer();
                } else {
                    System.out.println("Cell is not empty. Try again.");
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        } while (playAgain);

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
