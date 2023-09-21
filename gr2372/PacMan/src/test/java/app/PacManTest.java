package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PacManTest {

    @Test
    @DisplayName("Test Pacman changeDirection()")
    public void testPacManChangeDirection() {
        PacMan pacman = new PacMan();

        // Test Right
        pacman.changeDirection("RIGHT");

        Assertions.assertEquals(1, pacman.getDx());
        Assertions.assertEquals(0, pacman.getDy());

        // Test Left
        pacman.changeDirection("LEFT");
        Assertions.assertEquals(-1, pacman.getDx());
        Assertions.assertEquals(0, pacman.getDy());

        // Test Up
        pacman.changeDirection("UP");
        Assertions.assertEquals(-1, pacman.getDy());
        Assertions.assertEquals(0, pacman.getDx());

        // Test Down
        pacman.changeDirection("DOWN");
        Assertions.assertEquals(1, pacman.getDy());
        Assertions.assertEquals(0, pacman.getDx());
    }

    @Test
    @DisplayName("Test Pacman start position")
    public void testPacManStartPos() {
        PacMan pacman = new PacMan();
        Assertions.assertEquals(330, pacman.getXPosition());
        Assertions.assertEquals(115, pacman.getYPosition());
    }
}
