package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PacManPersistenceTest {

  //TODO: Move testUserNameValidation, create persistence test.
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