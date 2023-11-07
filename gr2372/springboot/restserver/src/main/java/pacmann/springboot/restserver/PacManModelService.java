package pacmann.springboot.restserver;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Service;
import core.PacManUser;
import persistence.PacmanPersistence;

@Service
public class PacManModelService {
    // Check if the word is present in string
        // If found, remove it using removeAll()
      

    private String systemPath = new File(System.getProperty("user.dir")).getParent();

    public String removeFolder(String filePath, String folderToRemove) {
        int lastIndex = filePath.lastIndexOf(folderToRemove) - 1;
    if (lastIndex != -1) {
        if (lastIndex + folderToRemove.length() == filePath.length() - 1) {
            // If "springboot" is the last folder, remove it without a trailing slash
            return filePath.substring(0, lastIndex);
        } else {
            // Remove "springboot" and the preceding "/" as usual
            return filePath.substring(0, lastIndex) + filePath.substring(lastIndex + folderToRemove.length() + 1);
        }
    }
    return filePath;
    }
    public List<PacManUser> getHighScores() {
        String correctPath = removeFolder(systemPath, "springboot");
        String scoresPath = "/core/src/main/java/persistence/JSON/remoteScores.json";
        return persistence.PacmanPersistence.fetchHighscore(correctPath+scoresPath);
    }

    public void addHighScore(String user) {
        PacManUser pacManUser = PacmanPersistence.deserializeIndividualHighScore(user);
        String correctPath = removeFolder(systemPath, "springboot");
        String scoresPath = "/core/src/main/java/persistence/JSON/remoteScores.json";
        String name = pacManUser.getUsername();
        double score = pacManUser.getScore();
        persistence.PacmanPersistence.saveHighscore(name, score, correctPath+scoresPath);
    }
}
