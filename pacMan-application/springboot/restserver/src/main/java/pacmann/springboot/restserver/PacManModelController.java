package pacmann.springboot.restserver;

import core.PacManUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Connects server requests and the PacManModelService class.
 */
@RestController
@RequestMapping("/api/highscores")
public class PacManModelController {

  @Autowired
  private PacManModelService service;

  /**
   * Empty constructor.
   */
  public PacManModelController() {
  }

  /**
   * Get the save-data from the service-layer.
   *
   * @return The saved highscores
   */
  @GetMapping
  public List<PacManUser> getAllHighscores() {
    service.setPersistanceLocation("/core/src/main/java/persistence/JSON/remoteScores.json");
    return service.getHighScores();
  }

  /**
   * Get the testdata from the service-layer.
   *
   * @return The saved testscores
   */
  @GetMapping("/test")
  public List<PacManUser> getAllTestHighscores() {
    service.setPersistanceLocation("/core/src/test/java/core/JSON/testScores.json");
    return service.getHighScores();
  }

  /**
   * Send a highscore to the serivce-layer.
   *
   * @param user User to be saved
   */
  @PutMapping
  public void addHighscore(@RequestBody String user) {
    service.setPersistanceLocation("/core/src/main/java/persistence/JSON/remoteScores.json");
    service.addHighScore(user);
  }

  /**
   * Send a testscore to the serivce-layer.
   *
   * @param user Testuser to be saved
   */
  @PutMapping("/test")
  public void addTestHighscore(@RequestBody String user) {
    service.setPersistanceLocation("/core/src/test/java/core/JSON/testScores.json");
    service.addHighScore(user);
  }
}
