package Persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import core.PacManUser;

public class PacmanPersistence {

  /**
   * Writes username and score to highscore file
   * @param name
   * @param score
   */
  public static void saveHighscore(String name, double score) {
    try {
      List<PacManUser> scores = fetchHighscore();
      PacManUser pacManUser = new PacManUser(name, score);
      scores.add(pacManUser);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      File highScoreFile = new File("src/main/resources/ui/JSON/scores.json");
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
   * Reads scores.txt into leaderboard
   * @return
   */
  public static List<PacManUser> fetchHighscore() {
    Gson gson = new Gson();
    List<PacManUser> scores = new ArrayList<PacManUser>();
    try {
      FileReader reader = new FileReader("src/main/resources/ui/JSON/scores.json", StandardCharsets.UTF_8);
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
