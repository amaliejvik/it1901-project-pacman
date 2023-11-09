package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostTest {

    @Test
    @DisplayName("Test Inky Reset")
    public void testInkyReset() {
        Inky inky = new Inky();
        inky.reset();

        Assertions.assertEquals(548, inky.getXposition());
        Assertions.assertEquals(24, inky.getYposition());
    }

    @Test
    @DisplayName("Test Blinky Reset")
    public void testBlinkyReset() {
        Blinky blinky = new Blinky();
        blinky.reset();

        Assertions.assertEquals(23, blinky.getXposition());
        Assertions.assertEquals(32, blinky.getYposition());
    }

    @Test
    @DisplayName("Test Clyde Reset")
    public void testClydeReset() {
        Clyde Clyde = new Clyde();
        Clyde.reset();

        Assertions.assertEquals(768, Clyde.getXposition());
        Assertions.assertEquals(378, Clyde.getYposition());
    }

    @Test
    @DisplayName("Test Pinky Reset")
    public void testPinkyReset() {
        Pinky Pinky = new Pinky();
        Pinky.reset();

        Assertions.assertEquals(395, Pinky.getXposition());
        Assertions.assertEquals(290, Pinky.getYposition());
    }

    @Test
    @DisplayName("Test Ghost movement")
    public void testGhostMovement() {
        Ghost ghost = new Ghost();

        // Ghost should stands still when initialized
        Assertions.assertEquals(0, ghost.getDx());
        Assertions.assertEquals(0, ghost.getDy());

        // Test RIGHT
        ghost.changeDirection("RIGHT");
        Assertions.assertEquals(1, ghost.getDx());
        Assertions.assertEquals(0, ghost.getDy());

        // Test LEFT
        ghost.changeDirection("LEFT");
        Assertions.assertEquals(-1, ghost.getDx());
        Assertions.assertEquals(0, ghost.getDy());

        // Test UP
        ghost.changeDirection("UP");
        Assertions.assertEquals(0, ghost.getDx());
        Assertions.assertEquals(-1, ghost.getDy());

        // Test RIGHT
        ghost.changeDirection("DOWN");
        Assertions.assertEquals(0, ghost.getDx());
        Assertions.assertEquals(1, ghost.getDy());

    }

}
