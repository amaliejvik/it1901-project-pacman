package app;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PacmanReadAndWrite {

  /**
   * Input validation on username, e.g. no spaces or empty strings
   * @param name username from player
   * @return true if the username is valid, else false
   */
  public static boolean validateUserName(String name) {
    if (name.contains(" ")) {
      return false;
    } else if (name == "") {
      return false;
    } else if (name.length() <= 2) {
      return false;
    }
    return true;
  }

  /**
   * Writes username and score to highscore file
   * @param name
   * @param score
   */
  public static void saveHighscore(String name, double score) {
    try {
      File highScoreFile = new File("src/main/resources/" + "scores.txt");
      FileWriter highScoreWriter = new FileWriter(highScoreFile, true);
      highScoreWriter.write(name + ": " + score + "\n");
      highScoreWriter.close();
      System.out.println("Score saved");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Score failed to save");
    }
  }

  /**
   * Reads scores.txt into leaderboard
   * @return
   */
  public static String fetchScoreBoard() {
    String scores = "";
    try {
      Scanner reader = new Scanner(new File("src/main/resources/scores.txt"));
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        scores = scores + line + "\n";
        System.out.println(scores);
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not find file");
      System.out.println(e.getLocalizedMessage());
    }
    return scores;
  }
}
