package Persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import core.PacManUser;

/**
 * Handles the persistence-layer of the app.
 * E.g. reads from and writes to a .json-file
 */
public class PacmanPersistence {

  /**
   * Writes username and score to .json file "scores.json"
   * Uses gson (see README)
   * @param username username of player
   * @param score score of player at gameover
   */
  public static void saveHighscore(String username, double score) {
    try {
      List<PacManUser> scores = fetchHighscore();
      PacManUser pacManUser = new PacManUser(username, score);
      scores.add(pacManUser);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      File highScoreFile = new File("src/main/resources/ui/JSON/scores.json");
      FileWriter highScoreWriter = new FileWriter(highScoreFile);
      gson.toJson(scores, highScoreWriter);
      System.out.println("Score saved");
      highScoreWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Score failed to save");
    }
  }

  /**
   * Reads from .json and transforms into list of PacManUser-objects
   * @return list of PacManUser-objects
   */
  public static List<PacManUser> fetchHighscore() {
    Gson gson = new Gson();
    List<PacManUser> scores = new ArrayList<PacManUser>();
    try {
      FileReader reader = new FileReader("src/main/resources/ui/JSON/scores.json");
      PacManUser[] scoreData = gson.fromJson(reader, PacManUser[].class);

      //Convert to list for easier access
      if(scoreData != null) {
        for (PacManUser user : scoreData) {
          scores.add(user);
        }
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
