package app;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PacManController {

    private int score = 0;
    private Stage stage;
    private Scene scene;
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
        //initialize();

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
            PacmanReadAndWrite.saveUserName(usernameInput.getText()); //lagrer brukernavnet
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    public void gameOver() {
        timeline1.stop();
        switchToGameOverBackground();
        // Fetche highscore, og lagre highscore til brukernavnet
        // TODO: Legge inn fxml sånn at vi får en game over screen med highscore
        // TODO: lagre score automatisk på brukernavnet
    }

    public int getScore() {
        return score;
    }

    public void setScore(int point) {
        score += point;
    }

    public void restartGame() {
        handleStartButton();
        // starte spillet på nytt igjen
    }

    @FXML
    public void updateGUI() {
        String name = usernameInput.getText();
        if (name.contains(" ")) {
            System.out.println("Name cannot contain spaces");
        } else if (name == "") {
            System.out.println("Namefield cannot be empty");
        } else if (name.length() > 2) {
            startButton.setDisable(false);
        }
    }

    // Handle switch between the two separate screens: mainbackground and
    // Gameoverbackground

    public void switchToGameOverBackground() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PacManGameOver.fxml"));
            Parent parent = fxmlLoader.load();
            stage.setScene(new Scene(parent));
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not switch background");
        }
    }

    public void switchToPacMan() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PacMan.fxml"));
            Parent parent = fxmlLoader.load();
            stage.setScene(new Scene(parent));
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not switch background");
        }
    }

    public PacManController() {
        return;

    }
}
