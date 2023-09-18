package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PacManTest {

  @Test
  @DisplayName("Test validation of username")
  public void testUserNameValidation() {
    PacmanReadAndWrite readAndWrite = new PacmanReadAndWrite();
    String testName1 = "";
    String testName2 = "n";
    String testName3 = "Name";
    Assertions.assertEquals(false, readAndWrite.validateUserName(testName1));
    Assertions.assertEquals(false, readAndWrite.validateUserName(testName2));
    Assertions.assertEquals(true, readAndWrite.validateUserName(testName3));
  }
}