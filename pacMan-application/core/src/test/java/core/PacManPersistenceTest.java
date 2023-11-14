package core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.PacManPersistence;

/**
 * Tests writing and reading of highscores locally.
 */
public class PacManPersistenceTest {

  @Test
  @DisplayName("Test reading and writing to file")
  public void persistanceTest() {

    PacManPersistence.saveHighscore("testUser", 100, "src/test/java/core/JSON/testScores.json");
    List<PacManUser> testScores = PacManPersistence
        .fetchHighscore("src/test/java/core/JSON/testScores.json");
    PacManUser userFromScore = testScores.get(0);

    Assertions.assertTrue(userFromScore.getUsername().equals("testUser"),
        "Username written to file is not the same as username read from file");
    Assertions.assertTrue(userFromScore.getScore() == 100,
        "Score written to file is not the same as score read from file");

    // Deletes content of .json file
    try {
      new FileWriter("src/test/java/core/JSON/testScores.json", false).close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test deserialization of highscorelist from JSON")
  public void testDeserializeHighscoreList() {

    // Test-JSONdata, multiple users
    String jsonData = "[{\"username\":\"User1\",\"score\":100},"
        + "{\"username\":\"User2\",\"score\":150}]";

    // Attempt to deserialize
    List<PacManUser> pacManUsers = PacManPersistence.deserializeHighscoreList(jsonData);

    // Assert everything is as it should be
    Assertions.assertEquals(2, pacManUsers.size());
    Assertions.assertEquals("User1", pacManUsers.get(0).getUsername());
    Assertions.assertEquals(100, pacManUsers.get(0).getScore());
    Assertions.assertEquals("User2", pacManUsers.get(1).getUsername());
    Assertions.assertEquals(150, pacManUsers.get(1).getScore());
  }

  @Test
  @DisplayName("Test deserialization of individual highscore from JSON")
  public void testDeserializeIndividualHighscore() {

    // Test-JSONdata, one user
    String jsonData = "{\"username\":\"User1\",\"score\":100}";

    // Attempt to deserialize
    PacManUser pacManUser = PacManPersistence.deserializeIndividualHighscore(jsonData);

    // Assert everything is as it should be
    Assertions.assertNotNull(pacManUser);
    Assertions.assertEquals("User1", pacManUser.getUsername());
    Assertions.assertEquals(100, pacManUser.getScore());
  }

  @Test
  @DisplayName("Test deserialization of highscorelist from invalid JSON")
  public void testDeserializeEmptyHighscoreListFromInvalidJson() {

    // Invalid test-JSONdata
    String invalidJsonData = "[{\"invalidJSONData\"}]";

    // Attemt to deserialize
    assertDoesNotThrow(() -> PacManPersistence.deserializeIndividualHighscore(invalidJsonData));
  }

  @Test
  @DisplayName("Test deserialization of individual highscore from invalid JSON")
  public void testDeserializeNullIndividualHighscoreFromInvalidJson() {

    // Invalid test-JSONdata
    String invalidJsonData = "{\"invalidJSONData\"}";

    // Attemt to deserialize
    assertDoesNotThrow(() -> PacManPersistence.deserializeIndividualHighscore(invalidJsonData));
  }
}