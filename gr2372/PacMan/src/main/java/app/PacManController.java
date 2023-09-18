package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27;

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

    private PacMan pacMan;

    private List<Rectangle> walls = new ArrayList<>();

    public void initialize() {
        walls.add(rect1);
        walls.add(rect2);
        walls.add(rect3);
        walls.add(rect4);
        walls.add(rect5);
        walls.add(rect6);
        walls.add(rect7);
        walls.add(rect8);
        walls.add(rect9);
        walls.add(rect10);
        walls.add(rect11);
        walls.add(rect12);
        walls.add(rect13);
        walls.add(rect14);
        walls.add(rect15);
        walls.add(rect16);
        walls.add(rect17);
        walls.add(rect18);
        walls.add(rect19);
        walls.add(rect20);
        walls.add(rect21);
        walls.add(rect22);
        walls.add(rect23);
        walls.add(rect24);
        walls.add(rect25);
        walls.add(rect26);
        walls.add(rect27);
        startButton.setDisable(true);
        updateGUI();
    }

    // TIMELINE

    Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
        // initialize();

        @Override
        public void handle(ActionEvent event) {

            pacMan.setXPosition(pacMan.getXPosition() + PacMan.dx);
            pacMan.setYPosition(pacMan.getYPosition() + PacMan.dy);

            pacManGif.setLayoutX(pacMan.getXPosition());
            pacManGif.setLayoutY(pacMan.getYPosition());

            pacMan.checkWallCollision(pacManGif, walls);
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
            timeline1.setCycleCount(Timeline.INDEFINITE);
            timeline1.play();
            pacMan = new PacMan();
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
}
