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
    public void testSwitchCurrentPlayer() {
        game.start();
        Player firstPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(firstPlayer, game.currentPlayer);
    }

    @Test
    public void testHasWinner() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinner() {
        game.start();
        assertFalse(game.hasWinner());
    }

    @Test
    public void testIsDraw() {
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
    public void testPlay() {
        // Testing play method requires manual interaction or mock input
        // Here we ensure the game initializes correctly
        game.start();
        assertNotNull(game.currentPlayer);
        assertFalse(game.board.isFull());
    }
}
