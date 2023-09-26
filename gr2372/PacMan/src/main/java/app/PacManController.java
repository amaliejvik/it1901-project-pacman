package app;

import java.util.Arrays;
import java.util.List;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PacManController {
    
    // REGULAR ATTRIBUTES
    private PacMan pacMan;
    private List<Rectangle> walls;
    private List<ImageView> pellets;

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
                        rect14, rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27;
    
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

    private Timeline timeline;

    //SPLIT TIMELINE INTO TWO FUNCTIONS; ONE THAT CREATES AND CONFIGURES IT AND ONE THAT STARTS IT
    public void createAndConfigureTimeline(){
        this.timeline = new Timeline(new KeyFrame(Duration.millis(10),new EventHandler<ActionEvent>() {

            @Override
        public void handle(ActionEvent event) {

            // UPDATES PACMAN'S POSITION-VARIABLES
            pacMan.setXPosition(pacMan.getXPosition() + PacMan.dx);
            pacMan.setYPosition(pacMan.getYPosition() + PacMan.dy);

            // GRAPHICALLY UPDATES PACMAN'S POSITION
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
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void startTimeline(){
        timeline.play();
    }
    // INITIALIZES GAME
    public void initialize() {

        // ARRAY OF WALLS
        walls = Arrays.asList(rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, 
                            rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27);

        // ARRAY OF PELLETS
        pellets = Arrays.asList(pellet1, pellet2, pellet3, pellet4);

        // DISABLES START BUTTON
        startButton.setDisable(true);

        // HIDES SCORE AND GAMEOVER SCREEN
        rectScore.setVisible(false);
        yourScoreText.setVisible(false);
        score.setVisible(false);
        gameOverScreen.setVisible(false);
        gameOverText.setVisible(false);
        restartGame.setVisible(false);
        highScores.setVisible(false);

        //CREATE AND CONFIGURE TIMELANE
        createAndConfigureTimeline();

        updateGUI();
    }


    // // TIMELINE
    // Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

    //     @Override
    //     public void handle(ActionEvent event) {

    //         // UPDATES PACMAN'S POSITION-VARIABLES
    //         pacMan.setXPosition(pacMan.getXPosition() + PacMan.dx);
    //         pacMan.setYPosition(pacMan.getYPosition() + PacMan.dy);

    //         // GRAPHICALLY UPDATES PACMAN'S POSITION
    //         pacManGif.setLayoutX(pacMan.getXPosition());
    //         pacManGif.setLayoutY(pacMan.getYPosition());

    //         // COLLISION CHECK
    //         pacMan.checkWallCollision(pacManGif, walls);
    //         pacMan.checkPelletCollision(pacManGif, pellets);

    //         // UPDATES SCORE
    //         score.setText(Integer.toString(pacMan.getScore()));

    //         // ROTATES PACMAN
    //         pacManGif.setRotate(pacMan.rotationAngle());

    //         if (pacMan.getScore() >= 40) {
    //             gameOver();
    //         }

    //     }
    // }));

    /**
     * Disables the startbutton if the username is invalid
     */
    @FXML
    public void updateGUI() {
        startButton.setDisable(true);
        String name = usernameInput.getText();
        if (PacmanReadAndWrite.validateUserName(name)) {
            startButton.setDisable(false);
        }
        else {
            startButton.setDisable(true);
        }
    }

    /**
     * Hides the startscreen and starts the game when startbutton is pressed
     */
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
            startTimeline();

            //GENERATES NEW PACMAN
            pacMan = new PacMan();

            // SHOWS SCOREVIEW
            score.setText("0");
            rectScore.setVisible(true);
            yourScoreText.setVisible(true);
            score.setVisible(true);

            pacMan.setUsername(usernameInput.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    /**
     * Stops game when all pellets are collected, 
     * displays gameover-screen
     */
    public void gameOver() {
        // Stop timeline
        timeline.stop();
        // Set GameOver screen visible
        gameOverScreen.setVisible(true);
        gameOverText.setVisible(true);
        restartGame.setVisible(true);
        highScores.setVisible(true);
        // Save score to username in file
        PacmanReadAndWrite.saveHighscore(pacMan.getUsername(), pacMan.getScore());
        // Displays score in scoreboard
        highScores.setText(PacmanReadAndWrite.fetchScoreBoard());
    }

    public void setScoreBoard(String newscoreboard) {
        highScores.setText(newscoreboard );
    }

    /**
     * Restarts game when restart button is pressed
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
        this.timeline = null;
        for (ImageView pellet : pellets) {
            pellet.setVisible(true);
        }
        
        pacMan.setScore(0);
        pacManGif.setLayoutX(330);
        pacManGif.setLayoutY(115);
        PacMan.dx = 0;
        PacMan.dy = 0;

        updateGUI();
    }
}
