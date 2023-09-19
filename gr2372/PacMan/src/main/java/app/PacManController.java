package app;

import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PacManController {

    // REGULAR ATTRIBUTES
    private PacMan pacMan;
    private List<Rectangle> walls = new ArrayList<>();
    private List<ImageView> pellets = new ArrayList<>();

    // FXML-ATTRIBUTES
    @FXML
    private AnchorPane mainBackground;

    @FXML
    private ImageView mapGrid;

    @FXML
    private Button startButton;

    @FXML
    private Rectangle startScreen;

    @FXML
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13,
            rect14, rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26,
            rect27;

    @FXML
    private ImageView pellet1, pellet2, pellet3, pellet4;

    @FXML
    private TextField usernameInput;

    @FXML
    private Label pacManText;

    @FXML
    private Label username;

    @FXML
    private ImageView pacManGif;

    @FXML
    private Label score;

    @FXML
    private Text yourScoreText;

    @FXML
    private Rectangle rectScore;

    // PacManGameOver
    @FXML
    private TextArea seeHighScore;

    @FXML
    private Label gameOverText;

    @FXML
    private Rectangle gameOverScreen;

    @FXML
    private Button restartGame;

    @FXML
    private Button seeScore;

    // PacManHighScores
    @FXML
    private TextArea highScores;

    @FXML
    private Button backButton;

    // CONSTRUCTOR
    public PacManController() {
        return;
    }

    // INITIALIZES GAME
    public void initialize() {

        // ARRAY OF WALLS
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

        // ARRAY OF PELLETS
        pellets.add(pellet1);
        pellets.add(pellet2);
        pellets.add(pellet3);
        pellets.add(pellet4);

        // DISABLES BUTTON
        startButton.setDisable(true);

        // SCORE
        rectScore.setVisible(false);
        yourScoreText.setVisible(false);
        score.setVisible(false);
        seeScore.setVisible(false);
        gameOverScreen.setVisible(false);
        gameOverText.setVisible(false);
        restartGame.setVisible(false);

        updateGUI();
    }

    // TIMELINE
    Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {

            // UPDATES PACMAN'S POSITION ("backend")
            pacMan.setXPosition(pacMan.getXPosition() + PacMan.dx);
            pacMan.setYPosition(pacMan.getYPosition() + PacMan.dy);

            // UPDATES PACMAN'S POSITION ("frontend")
            pacManGif.setLayoutX(pacMan.getXPosition());
            pacManGif.setLayoutY(pacMan.getYPosition());

            // COLLISION CHECK
            pacMan.checkWallCollision(pacManGif, walls);
            pacMan.checkPelletCollision(pacManGif, pellets);

            // UPDATES SCORE
            score.setText(Integer.toString(pacMan.getScore()));

            // ROTATES PACMAN
            pacManGif.setRotate(pacMan.rotationAngle());

            if (pacMan.getScore() >= 40) {
                gameOver();
            }

        }
    }));

    @FXML
    public void updateGUI() {
        startButton.setDisable(true);
        String name = usernameInput.getText();
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(name);
        boolean found = matcher.find();
        if (PacmanReadAndWrite.validateUserName(name)) {
            startButton.setDisable(false);
        }
        if (found) {
            startButton.setDisable(true);
        }
    }

    @FXML
    private void handleStartButton() {
        try {
            // REMOVES STARTSCREEN
            startButton.setVisible(false);
            startScreen.setVisible(false);
            username.setVisible(false);
            usernameInput.setVisible(false);
            pacManText.setVisible(false);

            // STARTS TIMELINE
            timeline1.setCycleCount(Timeline.INDEFINITE);
            timeline1.play();

            // GENERATES NEW PACMAN
            pacMan = new PacMan();

            // SHOWS SCOREVIEW
            score.setText("0");
            rectScore.setVisible(true);
            yourScoreText.setVisible(true);
            score.setVisible(true);

            PacmanReadAndWrite.saveUserName(usernameInput.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    public void gameOver() {
        timeline1.stop();
        gameOverScreen.setVisible(true);
        gameOverText.setVisible(true);
        seeScore.setVisible(true);
        restartGame.setVisible(true);
        PacmanReadAndWrite.saveScore(pacMan.getScore()); // save score to username
        mapGrid.setViewOrder(2);

    }

    @FXML
    private void handleSeeScoreButton() {
        // TODO: switch to gameoverscreen
    }

}
