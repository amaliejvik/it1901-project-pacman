package ui;

import com.google.gson.Gson;
import core.PacManUser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Connecting Springboot and UI.
 */
public class RemotePacManModelAccess {

  private final URI endpointBaseUri;

  private static final String APPLICATION_JSON = "application/json";

  private static final String ACCEPT_HEADER = "Accept";

  private static final String CONTENT_TYPE_HEADER = "Content-Type";

  private List<PacManUser> highscores;

  private Gson gson = new Gson();

  public RemotePacManModelAccess(URI endpointBaseUri) {
    this.endpointBaseUri = endpointBaseUri;
  }

  /**
   * Returns highscores from database.
   *
   * @return A list of PacManUsers in database.
   */
  public List<PacManUser> getHighscores() {
    HttpRequest request = HttpRequest.newBuilder(endpointBaseUri)
        .header(ACCEPT_HEADER, APPLICATION_JSON)
        .GET()
        .build();
    try {
      final HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
          HttpResponse.BodyHandlers.ofString());
      this.highscores = deserializeHighscoreList(response.body());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
    return highscores;
  }

  /**
   * Sends a highscore to be stored in the database.
   *
   * @param username  Name of the user.
   * @param highscore The score of the user.
   */
  public void putHighscore(String username, double highscore) {
    PacManUser user = new PacManUser(username, highscore);
    String json = gson.toJson(user);
    try {
      HttpRequest request = HttpRequest.newBuilder(endpointBaseUri)
          .header(ACCEPT_HEADER, APPLICATION_JSON)
          .header(CONTENT_TYPE_HEADER, APPLICATION_JSON)
          .PUT(BodyPublishers.ofString(json))
          .build();
      HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  /**
   * Maps from JSON to PacManUser-objects.
   *
   * @param jsonData The raw JSON data
   * @return List of PacManUsers
   */
  public List<PacManUser> deserializeHighscoreList(String jsonData) {
    List<PacManUser> scores = new ArrayList<PacManUser>();
    PacManUser[] scoreData = gson.fromJson(jsonData, PacManUser[].class);
    if (scoreData != null) {
      for (PacManUser user : scoreData) {
        scores.add(user);
      }
    }
    return scores;
  }
}
