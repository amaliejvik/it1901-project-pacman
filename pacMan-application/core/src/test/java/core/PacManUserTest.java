package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests creation and validation of PacManUser-objects.
 */
public class PacManUserTest {

  @Test
  @DisplayName("Test reset")
  public void testPacManUserReset() {
    PacManUser pacManUser = new PacManUser();
    pacManUser.setScore(40);
    pacManUser.setUsername("Test1");

    pacManUser.reset();
    Assertions.assertEquals(0, pacManUser.getScore());
    Assertions.assertEquals("Test1", pacManUser.getUsername());
  }

  @Test
  @DisplayName("Test validation of username")
  public void testUserNameValidation() {
    String testName1 = "";
    String testName2 = "n";
    String testName3 = "Name ";
    String testName4 = "Name";
    Assertions.assertEquals(false, PacManUser.validateUsername(testName1));
    Assertions.assertEquals(false, PacManUser.validateUsername(testName2));
    Assertions.assertEquals(false, PacManUser.validateUsername(testName3));
    Assertions.assertEquals(true, PacManUser.validateUsername(testName4));
  }

  @Test
  @DisplayName("Test toString()")
  public void testToString() {
    PacManUser test = new PacManUser("Test", 100);
    Assertions.assertEquals("Username=Test, Score=100.0\n", test.toString());
  }
}
