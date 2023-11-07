package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
    // PacMan pacman = new PacMan();
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
}
