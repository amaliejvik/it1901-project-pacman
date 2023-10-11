package ui;

import java.util.Arrays;
import java.util.List;

import Persistence.PacmanPersistence;
import core.PacMan;
import core.PacManUser;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PacManController {

    //Data-oriented and gameloop attributes
    private PacMan pacMan;
    private List<Rectangle> walls;
    private List<Rectangle> collisionRectangles;
    private List<ImageView> pellets;
    private Timeline timeline;
    private MediaPlayer mediaPlayer;

    // Fxml-attributes
    @FXML
    private AnchorPane mainBackground;

    @FXML
    private ImageView mapGrid;

    @FXML
    private Button startButton;

    @FXML
    private Rectangle startScreen;

    @FXML
    private Rectangle collisionRect1, collisionRect2, collisionRect3, collisionRect4;
    
    @FXML
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13,
            rect14, rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26,
            rect27;

    @FXML
    private ImageView pellet1, pellet2, pellet3, pellet4, pellet5, pellet6, pellet7, pellet8, pellet9, pellet10,
            pellet11, pellet12, pellet13,
            pellet14, pellet15, pellet16, pellet17, pellet18, pellet19, pellet20, pellet21, pellet22, pellet23,
            pellet24, pellet25,
            pellet26, pellet27, pellet28, pellet29, pellet30, pellet31, pellet32, pellet33, pellet34, pellet35,
            pellet36, pellet37,
            pellet38, pellet39, pellet40, pellet41, pellet42, pellet43, pellet44, pellet45, pellet46, pellet47,
            pellet48, pellet49,
            pellet50, pellet51, pellet52, pellet53, pellet54, pellet55, pellet56;

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
    private Text scoreText;

    @FXML
    private Label gameOverText;

    @FXML
    private Rectangle gameOverScreen;

    @FXML
    private Button restartGame;

    @FXML
    private TextArea highScores;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox toggleLightmode;

	/**
     * Creates the main game-loop for the application.
     * Updates pacmans position and rotation, checks for collisions, updates score, triggers gameover
     */
    public void createAndConfigureTimeline() {
        this.timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                // UPDATES PACMAN'S POSITION-VARIABLES
                PacMan.setXPosition(PacMan.getXPosition() + PacMan.getDX());
                PacMan.setYPosition(PacMan.getYPosition() + PacMan.getDY());

                // GRAPHICALLY UPDATES PACMAN'S POSITION
                pacManGif.setLayoutX(PacMan.getXPosition());
                pacManGif.setLayoutY(PacMan.getYPosition());

                // COLLISION CHECK
                PacMan.checkWallCollision(pacManGif, walls);
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
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    /*
     * Starts main game-loop
     */
    public void startTimeline(){
        timeline.play();
    }

    /*
     * Getter for PacMan-object
     */
    public PacMan getPacMan(){
        return pacMan;
    }

    /*
     * Is executed as game initializes.
     * Initializes music-player, organises FXML-elements into lists, generates PacMan object, hides various FXML-elements 
     * from the screen, configures timeline
     */
    public void initialize() {
        //Music-player
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/ui/PacManAudio.mp3").toString()));
        //If music ends, restart
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
            }
        });

        walls = Arrays.asList(rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, 
                            rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27);
        
        collisionRectangles = Arrays.asList(collisionRect1, collisionRect2, collisionRect3, collisionRect4);

        pellets = Arrays.asList(pellet1, pellet2, pellet3, pellet4, pellet5, pellet6, pellet7, pellet8, pellet9, pellet10, pellet11, pellet12, pellet13,
                        pellet14, pellet15, pellet16, pellet17, pellet18, pellet19, pellet20, pellet21, pellet22, pellet23, pellet24, pellet25,
                        pellet26, pellet27, pellet28, pellet29, pellet30, pellet31, pellet32, pellet33, pellet34, pellet35, pellet36, pellet37,
                        pellet38, pellet39, pellet40, pellet41, pellet42, pellet43, pellet44, pellet45, pellet46, pellet47, pellet48, pellet49,
                        pellet50, pellet51, pellet52, pellet53, pellet54, pellet55, pellet56);

        pacMan = new PacMan();

		gameOverScreen.setVisible(false);
        gameOverText.setVisible(false);
        restartGame.setVisible(false);
        highScores.setVisible(false);
        startButton.setDisable(true);

        createAndConfigureTimeline();

        updateGUI();
    }

    public ImageView getPacmanGif() {
        return pacManGif;
    }

    public List<Rectangle> getCollisionRectangles() {
        return collisionRectangles;
    }

    /**
     * Disables the startbutton if the username is invalid
     */
    @FXML
    public void updateGUI() {
        startButton.setDisable(true);
        String name = usernameInput.getText();
        if (pacMan.validateUsername(name)) {
            startButton.setDisable(false);
        } else {
            startButton.setDisable(true);
        }
    }

    /**
     * Hides the startscreen and starts the game and music when startbutton is pressed.
     * Updates map to light- or darkmode depending on users choice in startscreen
     */
    @FXML
    private void handleStartButton() {
        mediaPlayer.play();
        try {
            startButton.setVisible(false);
            startScreen.setVisible(false);
            username.setVisible(false);
            usernameInput.setVisible(false);
            pacManText.setVisible(false);
            toggleLightmode.setVisible(false);

            if (toggleLightmode.isSelected()) {
                mapGrid.setImage(new Image("file:src/main/resources/ui/mapgridLight.png"));

                for (ImageView pellet : pellets) {
                    pellet.setImage(new Image("file:src/main/resources/ui/smalldotLight.png"));
                }
                pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModelLight.gif"));
                scoreText.setFill(Color.BLACK);
                score.setTextFill(Color.BLACK);
            } else {
                mapGrid.setImage(new Image("file:src/main/resources/ui/mapgrid.png"));

                for (ImageView pellet : pellets) {
                    pellet.setImage(new Image("file:src/main/resources/ui/smalldot.png"));
                }
                pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModel.gif"));
                scoreText.setFill(Color.WHITE);
                score.setTextFill(Color.WHITE);
            }

            startTimeline();

            score.setText("0");

            scoreText.setVisible(true);
            score.setVisible(true);

            pacMan.setUsername(usernameInput.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    /**
     * Stops game and music when all pellets are collected.
     * Displays gameover-screen with highscores.
     * Saves userdata to file.
     */
    public void gameOver() {
        timeline.stop();
        // Set GameOver screen visible
        gameOverScreen.setVisible(true);
        gameOverText.setVisible(true);
        restartGame.setVisible(true);
        highScores.setVisible(true);
        toggleLightmode.setVisible(true);
        // Save score to username in file
        PacmanPersistence.saveHighscore(pacMan.getUsername(), pacMan.getScore(), "src/main/resources/ui/JSON/scores.json");
        // Displays score in scoreboard
        String usersString = "";
        List<PacManUser> UserArray = PacmanPersistence.fetchHighscore();
        StringBuffer buf = new StringBuffer();
        for (PacManUser user : UserArray) {
            buf.append(user.toString());
        }
        usersString = buf.toString();
        highScores.setText(usersString);

        gameOverScreen.setVisible(true);
        gameOverText.setVisible(true);
        restartGame.setVisible(true);
        highScores.setVisible(true);
        toggleLightmode.setVisible(true);
    }

    /**
     * Restarts game when restart button is pressed.
     * Resets Pacman's position, speed, direction and score.
     * Displays the startscreen.
     */
    @FXML
    private void handleRestartGameButton() {
        gameOverScreen.setVisible(false);
        gameOverText.setVisible(false);
        restartGame.setVisible(false);
        highScores.setVisible(false);
        startButton.setVisible(true);
        startScreen.setVisible(true);
        username.setVisible(true);
        usernameInput.clear();
        usernameInput.setVisible(true);
        pacManText.setVisible(true);
        for (ImageView pellet : pellets) {
            pellet.setVisible(true);
        }
        pacMan.setScore(0);
        pacManGif.setLayoutX(330);
        pacManGif.setLayoutY(115);
        PacMan.setDX(0);;
        PacMan.setDY(0);;
        PacMan.setRotate(0);
        PacMan.setXPosition(330);
        PacMan.setYPosition(115);

        updateGUI();

    }
}