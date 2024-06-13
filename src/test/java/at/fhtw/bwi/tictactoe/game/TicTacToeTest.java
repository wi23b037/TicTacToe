package at.fhtw.bwi.tictactoe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayerPositive() {
        game.start();
        Player firstPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(firstPlayer, game.currentPlayer);
    }

    @Test
    public void testSwitchCurrentPlayerNegative() {
        game.start();
        Player firstPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertEquals(firstPlayer == game.player1 ? game.player2 : game.player1, game.currentPlayer);
    }

    @Test
    public void testHasWinnerPositive() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerNegative() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testIsDrawPositive() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        game.board.place(2, 2, 'O');
        assertTrue(game.board.isFull());
        assertFalse(game.hasWinner());
    }

    @Test
    public void testIsDrawNegative() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        // Leave the last cell empty to make it not a draw
        assertFalse(game.board.isFull());
        assertFalse(game.isDraw());
    }

    @Test
    public void testPlayPositive() {

        game.start();
        assertNotNull(game.currentPlayer);
        assertFalse(game.board.isFull());
    }

    @Test
    public void testPlayNegative() {
        game.start();
        assertNotNull(game.currentPlayer);
        assertFalse(game.hasWinner());
        assertFalse(game.isDraw());
    }
}
