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

  /**
   * Writes username and score to highscore file
   * @param name username of the player
   */
  public static void saveUserName(String name) {
    if (!validateUserName(name)) {
      throw new IllegalArgumentException("Invalid name");
    }
    try {
      File userScores = new File("gr2372/PacMan/src/main/resources/" + "scores.txt");
      FileWriter userNameWriter = new FileWriter(userScores, true);
      userNameWriter.write(name + ": ");
      userNameWriter.close();
      System.out.println("Username saved");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Username failed to save");
    }
  }

  //TODO: combine with saveUserName to one function that saves name and score at gameover
  public static void saveScore(int score) {
    try {
      FileWriter scoreWriter = new FileWriter("gr2372/PacMan/src/main/resources/" + "scores.txt", true);
      scoreWriter.write(score + "\n");
      scoreWriter.close();
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
      Scanner reader = new Scanner(new File("gr2372/PacMan/src/main/resources/scores.txt"));
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

  public static void main() {
    fetchScoreBoard();
  }

}
