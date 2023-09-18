package app;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PacmanReadAndWrite {
  public static boolean validateUserName(String name) {
    if (name.contains(" ")) {
      System.out.println("Name cannot contain spacing");
      return false;
    } else if (name == "") {
      System.out.println("Namefield cannot be empty");
      return false;
    } else if (name.length() <= 2) {
      return false;
    }
    return true;
  }

  public static void saveUserName(String name) {
    if (!validateUserName(name)) {
      throw new IllegalArgumentException("Invalid name");
    }
    try {
      File userScores = new File("gr2372/PacMan/src/main/resources/" + "scores");
      FileWriter userNameWriter = new FileWriter(userScores, true);
      userNameWriter.write(name + ": ");
      userNameWriter.close();
      System.out.println("Username saved");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Username failed to save");
    }
  }

  public static void saveScore(int score) {
    try {
      FileWriter scoreWriter = new FileWriter("gr2372/PacMan/src/main/resources/" + "scores", true);
      scoreWriter.write(score + "\n");
      scoreWriter.close();
      System.out.println("Score saved");

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Score failed to save");
    }
  }

  // TODO: create restart method so that score is set again

  public static String fetchScoreBoard() {
    String scores = null;
    try {
      Scanner reader = new Scanner("gr2372/PacMan/src/main/resources/" + "scores");
      while (reader.hasNextLine()) {
        scores = reader.nextLine();
        reader.close();
        // her kan vi endre på highscoretabell i PacManController, når vi får på plass
        // FXML til det
        System.out.println(scores);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not find file");
    }
    return scores;
  }

}
