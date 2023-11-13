package pacmann.springboot.restserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import core.PacManUser;
import persistence.PacmanPersistence;

@Service
public class PacManModelService {

    private final String systemPath = new File(System.getProperty("user.dir")).getParent();
    private final String globalPath = removeFolder(systemPath, "springboot");
    private String finalPath = globalPath + "/core/src/main/java/persistence/JSON/remoteScores.json";

    public PacManModelService() {
    }

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
    
    public void setPersistanceLocation(String location) {
        finalPath = globalPath + location;
    }

    public List<PacManUser> getHighScores() {
        return persistence.PacmanPersistence.fetchHighscore(finalPath);
    }

    public void addHighScore(String user) {
        PacManUser pacManUser = PacmanPersistence.deserializeIndividualHighScore(user);
        String name = pacManUser.getUsername();
        double score = pacManUser.getScore();
        persistence.PacmanPersistence.saveHighscore(name, score, finalPath);
    }

    public void addHighScore(PacManUser user) {
        String name = user.getUsername();
        double score = user.getScore();
        persistence.PacmanPersistence.saveHighscore(name, score, finalPath);
    }

    public void removeAllHighScores() {
        try {
            new FileWriter(finalPath, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
