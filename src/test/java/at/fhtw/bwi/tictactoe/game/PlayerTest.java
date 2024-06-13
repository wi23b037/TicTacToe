package at.fhtw.bwi.tictactoe.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());

        player = new Player('O');
        assertEquals('O', player.getMarker());
    }
}
