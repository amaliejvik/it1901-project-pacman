package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.PacManUser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the persistence in the application.
 */
public class PacmanPersistence {
  /**
   * Writes username and score to .json file "scores.json"
   * Uses gson (see README)
   *
   * @param name  username of player
   * @param score score of player at gameover
   * @param path  path to save-file
   */
  public static void saveHighscore(String name, double score, String path) {
    try {
      List<PacManUser> scores = fetchHighscore(path);
      PacManUser pacManUser = new PacManUser(name, score);
      scores.add(pacManUser);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      File highScoreFile = new File(path);
      FileWriter highScoreWriter = new FileWriter(highScoreFile, StandardCharsets.UTF_8);
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
   *
   * @return list of PacManUser-objects
   */
  public static List<PacManUser> fetchHighscore(String path) {
    Gson gson = new Gson();
    List<PacManUser> scores = new ArrayList<PacManUser>();
    try {
      FileReader reader = new FileReader(path, StandardCharsets.UTF_8);
      PacManUser[] scoreData = gson.fromJson(reader, PacManUser[].class);

      // Convert to list for easier access
      if (scoreData != null) {
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

  /**
   * Maps from JSON to PacManUser-objects.
   *
   * @param jsonData The raw JSON data
   * @return List of PacManUsers
   */
  public static List<PacManUser> deserializeHighScoreList(String jsonData) {
    Gson gson = new Gson();
    List<PacManUser> scores = new ArrayList<PacManUser>();
    try {
      PacManUser[] scoreData = gson.fromJson(jsonData, PacManUser[].class);

      // Convert to list for easier access
      if (scoreData != null) {
        for (PacManUser user : scoreData) {
          scores.add(user);
        }
      }
    } catch (Exception e) {
      System.out.println("Could not find file");
      System.out.println(e.getLocalizedMessage());
    }
    return scores;
  }

  /**
   * Maps from JSON to a single PacManUser.
   *
   * @param rawJsonData The raw JSON data
   * @return List of PacManUsers
   */
  public static PacManUser deserializeIndividualHighScore(String rawJsonData) {
    Gson gson = new Gson();
    PacManUser user = null;
    try {
      user = gson.fromJson(rawJsonData, PacManUser.class);
    } catch (Exception e) {
      System.out.println("Could not deserialize user data");
      System.out.println(e.getLocalizedMessage());
    }
    return user;
  }
}