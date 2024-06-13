package at.fhtw.bwi.tictactoe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmptyPositive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmptyNegative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlacePositive() {
        board.place(0, 0, 'X');
        assertEquals('X', board.cells[0][0]);
    }

    @Test
    public void testPlaceNegative() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertEquals('X', board.cells[0][0]);
    }

    @Test
    public void testIsFullPositive() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFullNegative() {
        assertFalse(board.isFull());
    }

    @Test
    public void testClearPositive() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClearNegative() {
        board.place(0, 0, 'X');
        board.clear();
        assertFalse(board.cells[0][0] == 'X');
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceOutOfBounds() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.place(3, 3, 'X');
        });
        String expectedMessage = "Index 3 out of bounds for length 3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testIsCellEmptyOutOfBounds() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.isCellEmpty(3, 3);
        });
        String expectedMessage = "Index 3 out of bounds for length 3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
