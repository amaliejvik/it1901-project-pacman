package app;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PacmanReadAndWrite {
  // usikker på om det egentlig skal være static her, men hvis ikke så funka ikke
  // pacmancontroller
  public static void saveUserName(String name) {
    try {
      File userScores = new File("gr2372/PacMan/src/main/resources/" + "scores");
      FileWriter userNameWriter = new FileWriter(userScores, true);
      userNameWriter.write(name);
      userNameWriter.close();
      System.out.println("Username saved");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Username failed to save");
    }
  }

  public String fetchScoreBoard() {
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
