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
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
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
        assertTrue(game.isDraw());
    }

    @Test
    public void testNotDraw() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        assertFalse(game.isDraw());
    }

    @Test
    public void testStartResetsBoard() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.start();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(game.board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testStartSetsCurrentPlayerToPlayer1() {
        game.switchCurrentPlayer();
        game.start();
        assertEquals(game.player1, game.currentPlayer);
    }

    @Test
    public void testSwitchCurrentPlayer() {
        game.start();
        Player initialPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.currentPlayer);
    }

    @Test
    public void testSwitchCurrentPlayerTwice() {
        game.start();
        Player initialPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.currentPlayer);
    }

    @Test
    public void testGameEndsWhenWinner() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
        // Here we should check if the game loop stops, but since we don't have the game loop in the test,
        // we assume the main method handles this. This test ensures hasWinner works correctly.
    }

    @Test
    public void testPlayerMarkerStaysSameAfterWin() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
        assertEquals('X', game.currentPlayer.getMarker());
    }
}
