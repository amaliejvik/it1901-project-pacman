package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PacManTest {

    @Test
    @DisplayName("Test Pacman changeDirection()")
    public void testPacManChangeDirection() {
        // Test Right
        PacMan.changeDirection("RIGHT");

        Assertions.assertEquals(1, PacMan.dx);
        Assertions.assertEquals(0, PacMan.dy);

        // Test Left
        PacMan.changeDirection("LEFT");
        Assertions.assertEquals(-1, PacMan.dx);
        Assertions.assertEquals(0, PacMan.dy);

        // Test Up
        PacMan.changeDirection("UP");
        Assertions.assertEquals(-1, PacMan.dy);
        Assertions.assertEquals(0, PacMan.dx);

        // Test Down
        PacMan.changeDirection("DOWN");
        Assertions.assertEquals(1, PacMan.dy);
        Assertions.assertEquals(0, PacMan.dx);
    }

    @Test
    @DisplayName("Test Pacman start position")
    public void testPacManStartPos() {
        PacMan pacman = new PacMan();
        Assertions.assertEquals(330, pacman.getXPosition());
        Assertions.assertEquals(115, pacman.getYPosition());
    }
}
