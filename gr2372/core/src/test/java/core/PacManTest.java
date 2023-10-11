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

        Assertions.assertEquals(1, PacMan.getDX());
        Assertions.assertEquals(0, PacMan.getDY());

        // Test Left
        PacMan.changeDirection("LEFT");
        Assertions.assertEquals(-1, PacMan.getDX());
        Assertions.assertEquals(0, PacMan.getDY());

        // Test Up
        PacMan.changeDirection("UP");
        Assertions.assertEquals(-1, PacMan.getDY());
        Assertions.assertEquals(0, PacMan.getDX());

        // Test Down
        PacMan.changeDirection("DOWN");
        Assertions.assertEquals(1, PacMan.getDY());
        Assertions.assertEquals(0, PacMan.getDX());
    }

    @Test
    @DisplayName("Test Pacman start position")
    public void testPacManStartPos() {
        // PacMan pacman = new PacMan();
        Assertions.assertEquals(330, PacMan.getXPosition());
        Assertions.assertEquals(115, PacMan.getYPosition());
    }

    @Test
    @DisplayName("Test validation of username")
    public void testUserNameValidation() {
        PacMan pacMan = new PacMan();
        String testName1 = "";
        String testName2 = "n";
        String testName3 = "Name";
        Assertions.assertEquals(false, pacMan.validateUsername(testName1));
        Assertions.assertEquals(false, pacMan.validateUsername(testName2));
        Assertions.assertEquals(true, pacMan.validateUsername(testName3));
  }
}
