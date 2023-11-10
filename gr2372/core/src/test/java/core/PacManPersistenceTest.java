package core;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.PacmanPersistence;

/**
 * Tests writing and reading of highscores locally.
 */
public class PacManPersistenceTest {

  @Test
  @DisplayName("Test reading and writing to file")
  public void persistanceTest() {

    PacmanPersistence.saveHighscore("testUser", 100, "src/test/java/core/JSON/testScores.json");
    List<PacManUser> testScores = PacmanPersistence
        .fetchHighscore("src/test/java/core/JSON/testScores.json");
    PacManUser userFromScore = testScores.get(0);

    assertTrue(userFromScore.getUsername().equals("testUser"),
        "Username written to file is not the same as username read from file");
    assertTrue(userFromScore.getScore() == 100,
        "Score written to file is not the same as score read from file");

    // Deletes content of .json file
    try {
      new FileWriter("src/test/java/core/JSON/testScores.json", false).close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}