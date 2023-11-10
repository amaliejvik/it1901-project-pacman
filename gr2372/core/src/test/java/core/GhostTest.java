package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests the position of the ghosts after a reset.
 */
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
    Clyde clyde = new Clyde();
    clyde.reset();

    Assertions.assertEquals(768, clyde.getXposition());
    Assertions.assertEquals(378, clyde.getYposition());
  }

  @Test
  @DisplayName("Test Pinky Reset")
  public void testPinkyReset() {
    Pinky pinky = new Pinky();
    pinky.reset();

    Assertions.assertEquals(395, pinky.getXposition());
    Assertions.assertEquals(290, pinky.getYposition());
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
