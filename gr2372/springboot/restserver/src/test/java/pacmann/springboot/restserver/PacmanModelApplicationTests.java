package pacmann.springboot.restserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.google.gson.Gson;
import core.PacManUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes = 
  {PacManModelApplication.class, PacManModelController.class, PacManModelService.class})
@WebMvcTest
public class PacmanModelApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PacManModelService pacManModelService;

  private Gson gson = new Gson();

  private final String url = "http://localhost:8080/api/highscores/test";

  private final PacManUser player1 = new PacManUser("Player1", 0);
  private final PacManUser player2 = new PacManUser("Player2", 330);
  private final PacManUser player3 = new PacManUser("Player3", 660);
  private final PacManUser player4 = new PacManUser("Player4", 200);
;


  @Test
  public void contextLoads() throws Exception {
    assertNotNull(pacManModelService);
  }

  @BeforeAll
  public void setup() throws IllegalStateException, IOException {
    pacManModelService = new PacManModelService();
    pacManModelService.setPersistanceLocation("/core/src/test/java/core/JSON/testScores.json");
    
    pacManModelService.addHighScore(player1);
    pacManModelService.addHighScore(player2);
    pacManModelService.addHighScore(player3);
  }
  @Test
  public void testControllerGetHighScores() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(url)
           .accept(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andReturn();

  }

  @Test
  public void testControllerPutHighScore() throws Exception {
    final String json = gson.toJson(player4);
    mockMvc.perform(MockMvcRequestBuilders.put(url)
           .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
           .content(json).accept(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testServiceGetAndPutHighScores() {
    List<PacManUser> pacManUserList = new ArrayList<>();
    pacManUserList.add(player1);
    pacManUserList.add(player2);
    pacManUserList.add(player3);
    pacManUserList.add(player4);

    String player4String = gson.toJson(player4);
    pacManModelService.addHighScore(player4String);

    String jsonExpected = gson.toJson(pacManUserList);
    String jsonActual = gson.toJson(pacManModelService.getHighScores());

    assertEquals(jsonExpected, jsonActual);
  }

  @AfterAll
  public void removeHighScores() {
    pacManModelService.removeAllHighScores();
  }
}
