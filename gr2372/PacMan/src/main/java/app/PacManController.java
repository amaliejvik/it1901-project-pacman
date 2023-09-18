package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PacManController {

    // ATTRIBUTTER
    @FXML
    private ImageView mapGrid;

    @FXML
    private Button startButton;

    @FXML
    private Rectangle startScreen;

    @FXML
    private TextField usernameInput;

    @FXML
    private Label pacManText;

    @FXML
    private Label username;

    @FXML
    private ImageView pacManGif;

    @FXML
    private AnchorPane mainBackground;

    public void initialize() {
        startButton.setDisable(true);
        updateGUI();
    }

    // TIMELINE

    Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
        // initialize();

        @Override
        public void handle(ActionEvent event) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'handle'");
        }

    }));

    @FXML
    private void handleStartButton() {
        try {
            startButton.setVisible(false);
            startScreen.setVisible(false);
            username.setVisible(false);
            usernameInput.setVisible(false);
            pacManText.setVisible(false);
            PacmanReadAndWrite.saveUserName(usernameInput.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    public void gameOver() {
        timeline1.stop();
        // Fetche highscore, og lagre highscore til brukernavnet
        Rectangle gameoverScreen = new Rectangle(250, 250);
        Button restartGame = new Button("Restart Game", gameoverScreen);
        // TODO: Legge inn fxml sånn at vi får en game over screen med highscore

        mainBackground.getChildren().add(gameoverScreen);
        // TODO: lagre score automatisk på brukernavnet
    }

    public void restartGame() {
        handleStartButton();
        // starte spillet på nytt igjen
    }

    @FXML
    public void updateGUI() {
        startButton.setDisable(true);
        String name = usernameInput.getText();
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(name);
        boolean found = matcher.find();
        if (name.length() >= 2) {
            startButton.setDisable(false);
        }
        if (found) {
            startButton.setDisable(true);
        }
    }

    public PacManController() {
        return;
    }
}
