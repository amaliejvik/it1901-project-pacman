package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests movement of PacMan, name-validation and resetting.
 */
public class PacManTest {

  @Test
  @DisplayName("Test Pacman changeDirection()")
  public void testPacManChangeDirection() {
    // Test Right
    PacMan.changeDirection("RIGHT");

    Assertions.assertEquals(1, PacMan.getDx());
    Assertions.assertEquals(0, PacMan.getDy());

    // Test Left
    PacMan.changeDirection("LEFT");
    Assertions.assertEquals(-1, PacMan.getDx());
    Assertions.assertEquals(0, PacMan.getDy());

    // Test Up
    PacMan.changeDirection("UP");
    Assertions.assertEquals(-1, PacMan.getDy());
    Assertions.assertEquals(0, PacMan.getDx());

    // Test Down
    PacMan.changeDirection("DOWN");
    Assertions.assertEquals(1, PacMan.getDy());
    Assertions.assertEquals(0, PacMan.getDx());
  }

  @Test
  @DisplayName("Test Pacman start position")
  public void testPacManStartPos() {
    Assertions.assertEquals(330, PacMan.getXposition());
    Assertions.assertEquals(115, PacMan.getYposition());
  }

  @Test
  @DisplayName("Test validation of username")
  public void testUserNameValidation() {
    String testName1 = "";
    String testName2 = "n";
    String testName3 = "Name";
    Assertions.assertEquals(false, PacManUser.validateUsername(testName1));
    Assertions.assertEquals(false, PacManUser.validateUsername(testName2));
    Assertions.assertEquals(true, PacManUser.validateUsername(testName3));
  }

  @Test
  @DisplayName("Test reset of PacMan")
  public void testReset() {
    PacMan.changeDirection("LEFT");
    PacMan.reset();

    // Test speed
    Assertions.assertEquals(0, PacMan.getDx());
    Assertions.assertEquals(0, PacMan.getDy());

    // Test rotation
    Assertions.assertEquals("RIGHT", PacMan.getRotate());
    Assertions.assertEquals(0, PacMan.rotationAngle());

    // Test position
    Assertions.assertEquals(330, PacMan.getXposition());
    Assertions.assertEquals(115, PacMan.getYposition());

  }

  @Test
  @DisplayName("Test Pacman rotation")
  public void testPacManRotation() {

    // Test default start rotation angle
    Assertions.assertEquals(0, PacMan.rotationAngle());

    // Test rotation LEFT
    PacMan.changeDirection("LEFT");
    Assertions.assertEquals(180, PacMan.rotationAngle());

    // Test rotation UP
    PacMan.changeDirection("UP");
    Assertions.assertEquals(270, PacMan.rotationAngle());

    // Test rotation left
    PacMan.changeDirection("DOWN");
    Assertions.assertEquals(90, PacMan.rotationAngle());

    // Test rotation RIGHT
    PacMan.changeDirection("RIGHT");
    Assertions.assertEquals(0, PacMan.rotationAngle());

  }
}
