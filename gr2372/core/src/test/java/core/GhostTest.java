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

        Assertions.assertEquals(548, inky.getXPosition());
        Assertions.assertEquals(24, inky.getYPosition());
    }

    @Test
    @DisplayName("Test Blinky Reset")
    public void testBlinkyReset() {
        Blinky blinky = new Blinky();
        blinky.reset();

        Assertions.assertEquals(23, blinky.getXPosition());
        Assertions.assertEquals(32, blinky.getYPosition());
    }

    @Test
    @DisplayName("Test Clyde Reset")
    public void testClydeReset() {
        Clyde Clyde = new Clyde();
        Clyde.reset();

        Assertions.assertEquals(768, Clyde.getXPosition());
        Assertions.assertEquals(378, Clyde.getYPosition());
    }

    @Test
    @DisplayName("Test Pinky Reset")
    public void testPinkyReset() {
        Pinky Pinky = new Pinky();
        Pinky.reset();

        Assertions.assertEquals(395, Pinky.getXPosition());
        Assertions.assertEquals(290, Pinky.getYPosition());
    }

    @Test
    @DisplayName("Test Ghost movement")
    public void testGhostMovement() {
        Ghost ghost = new Ghost();

        // Ghost should stands still when initialized
        Assertions.assertEquals(0, ghost.getDX());
        Assertions.assertEquals(0, ghost.getDY());

        // Test RIGHT
        ghost.changeDirection("RIGHT");
        Assertions.assertEquals(1, ghost.getDX());
        Assertions.assertEquals(0, ghost.getDY());

        // Test LEFT
        ghost.changeDirection("LEFT");
        Assertions.assertEquals(-1, ghost.getDX());
        Assertions.assertEquals(0, ghost.getDY());

        // Test UP
        ghost.changeDirection("UP");
        Assertions.assertEquals(0, ghost.getDX());
        Assertions.assertEquals(-1, ghost.getDY());

        // Test RIGHT
        ghost.changeDirection("DOWN");
        Assertions.assertEquals(0, ghost.getDX());
        Assertions.assertEquals(1, ghost.getDY());

    }

}
