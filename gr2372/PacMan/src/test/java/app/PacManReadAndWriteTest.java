package app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PacManReadAndWriteTest {

  @Test
  @DisplayName("Test validation of username")
  public void testUserNameValidation() {
    String testName1 = "";
    String testName2 = "n";
    String testName3 = "Name";
    Assertions.assertEquals(false, PacmanReadAndWrite.validateUserName(testName1));
    Assertions.assertEquals(false, PacmanReadAndWrite.validateUserName(testName2));
    Assertions.assertEquals(true, PacmanReadAndWrite.validateUserName(testName3));
  }





}