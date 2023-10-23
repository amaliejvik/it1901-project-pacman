package ui;

import java.util.Arrays;
import java.util.List;

import Persistence.PacmanPersistence;
import core.PacMan;
import core.PacManUser;
import core.Ghost;
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
    private Ghost inky;
    private Ghost pinky;
    private Ghost blinky;
    private Ghost clyde;
    private List<Rectangle> walls;
    private List<Rectangle> collisionRectangles;
    private List<ImageView> pellets;
    private List<ImageView> ghosts;
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
    private Rectangle collisionRect1, collisionRect2, collisionRect3, collisionRect4, collisionRect5, collisionRect6,
            collisionRect7, collisionRect8, collisionRect9, collisionRect10, collisionRect11, collisionRect12, collisionRect13,
            collisionRect14, collisionRect15, collisionRect16, collisionRect17, collisionRect18, collisionRect19, collisionRect20,
            collisionRect21, collisionRect22, collisionRect23, collisionRect24;
    
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
    private ImageView pacManGif, blinkyPNG, pinkyPNG, clydePNG, inkyPNG;

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
                
                inky.setXPosition(inky.getXPosition() + inky.getDX());
                inky.setYPosition(inky.getYPosition() + inky.getDY());
                inkyPNG.setLayoutX(inky.getXPosition());
                inkyPNG.setLayoutY(inky.getYPosition());

                blinky.setXPosition(blinky.getXPosition() + blinky.getDX());
                blinky.setYPosition(blinky.getYPosition() + blinky.getDY());
                blinkyPNG.setLayoutX(blinky.getXPosition());
                blinkyPNG.setLayoutY(blinky.getYPosition());

                pinky.setXPosition(pinky.getXPosition() + pinky.getDX());
                pinky.setYPosition(pinky.getYPosition() + pinky.getDY());
                pinkyPNG.setLayoutX(pinky.getXPosition());
                pinkyPNG.setLayoutY(pinky.getYPosition());

                clyde.setXPosition(clyde.getXPosition() + clyde.getDX());
                clyde.setYPosition(clyde.getYPosition() + clyde.getDY());
                clydePNG.setLayoutX(clyde.getXPosition());
                clydePNG.setLayoutY(clyde.getYPosition());
                
                // COLLISION CHECK
                if (Collisions.PacmanWallCollision(pacManGif, walls)) {
                    PacMan.setDX(0);
                    PacMan.setDY(0);
                }
                
                if (Collisions.PacmanPelletCollision(pacManGif, pellets)) {
                    PacMan.setScore(PacMan.getScore()+10);
                }

                if (Collisions.PacmanGhostCollision(pacManGif, ghosts)) {
                    gameOver();
                }
                
                inkyPathing();
                blinkyPathing();
                pinkyPathing();
                clydePathing();

                // UPDATES SCORE
                score.setText(Integer.toString(PacMan.getScore()));

                // ROTATES PACMAN
                pacManGif.setRotate(pacMan.rotationAngle());

                if (PacMan.getScore() >= 560) {
                    gameOver();
                }

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void inkyPathing() {
        if (inky.checkWallCollision(inkyPNG, collisionRect23)) {
            inky.changeDirection("RIGHT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect12)) {
            inky.changeDirection("UP");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect9)) {
            inky.changeDirection("RIGHT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect10)) {
            inky.changeDirection("DOWN");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect22)) {
            inky.changeDirection("LEFT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect21)) {
            inky.changeDirection("UP");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect15)) {
            inky.changeDirection("LEFT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect24)) {
            inky.changeDirection("DOWN");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect20)) {
            inky.changeDirection("LEFT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect19)) {
            inky.changeDirection("UP");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect14)) {
            inky.changeDirection("LEFT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect16)) {
            inky.changeDirection("DOWN");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect18)) {
            inky.changeDirection("LEFT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect17)) {
            inky.changeDirection("UP");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect5)) {
            inky.changeDirection("RIGHT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect6)) {
            inky.changeDirection("DOWN");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect13)) {
            inky.changeDirection("RIGHT");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect11)) {
            inky.changeDirection("UP");
        }
        else if (inky.checkWallCollision(inkyPNG, collisionRect7)) {
            inky.changeDirection("RIGHT");
        }
    }
    
    public void blinkyPathing() {
        if (blinky.checkWallCollision(blinkyPNG, collisionRect6)) {
            blinky.changeDirection("DOWN");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect13)) {
            blinky.changeDirection("RIGHT");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect11)) {
            blinky.changeDirection("UP");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect7)) {
            blinky.changeDirection("RIGHT");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect8)) {
            blinky.changeDirection("DOWN");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect20)) {
            blinky.changeDirection("LEFT");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect19)) {
            blinky.changeDirection("UP");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect14)) {
            blinky.changeDirection("LEFT");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect16)) {
            blinky.changeDirection("DOWN");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect18)) {
            blinky.changeDirection("LEFT");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect17)) {
            blinky.changeDirection("UP");
        }
        else if (blinky.checkWallCollision(blinkyPNG, collisionRect5)) {
            blinky.changeDirection("RIGHT");
        }
    }

    public void pinkyPathing() {
        if (pinky.checkWallCollision(pinkyPNG, collisionRect3)) {
            pinky.changeDirection("UP");
        }
        else if (pinky.checkWallCollision(pinkyPNG, collisionRect4)) {
            pinky.changeDirection("RIGHT");
        }
        else if (pinky.checkWallCollision(pinkyPNG, collisionRect1)) {
            pinky.changeDirection("DOWN");
        }
        else if (pinky.checkWallCollision(pinkyPNG, collisionRect2)) {
            pinky.changeDirection("LEFT");
        }
    }

    public void clydePathing() {
        if (clyde.checkWallCollision(clydePNG, collisionRect21)) {
            clyde.setXPosition(clyde.getXPosition()+3);
            clyde.changeDirection("UP");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect15)) {
            clyde.setYPosition(clyde.getYPosition()+3);
            clyde.changeDirection("LEFT");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect3)) {
            clyde.setXPosition(clyde.getXPosition()+3);
            clyde.changeDirection("UP");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect4)) {
            clyde.setYPosition(clyde.getYPosition()+3);
            clyde.changeDirection("RIGHT");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect12)) {
            clyde.setXPosition(clyde.getXPosition()-3);
            clyde.changeDirection("UP");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect9)) {
            clyde.setYPosition(clyde.getYPosition()+3);
            clyde.changeDirection("RIGHT");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect10)) {
            clyde.setXPosition(clyde.getXPosition()-3);
            clyde.changeDirection("DOWN");
        }
        else if (clyde.checkWallCollision(clydePNG, collisionRect22)) {
            clyde.setYPosition(clyde.getYPosition()-3);
            clyde.changeDirection("LEFT");
        }
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

    public PacManController() {
        return ;
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

        inky = new Ghost();
        pinky = new Ghost();
        blinky = new Ghost();
        clyde = new Ghost();

        ghosts = Arrays.asList(inkyPNG, pinkyPNG, blinkyPNG, clydePNG);

        inky.changeDirection("DOWN");
        inky.setXPosition(548);
        inky.setYPosition(24);
        
        pinky.changeDirection("LEFT");
        pinky.setXPosition(395);
        pinky.setYPosition(290);

        blinky.changeDirection("RIGHT");
        blinky.setXPosition(23);
        blinky.setYPosition(32);

        clyde.changeDirection("LEFT");
        clyde.setXPosition(768);
        clyde.setYPosition(378);

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

            PacMan.setUsername(usernameInput.getText());
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
        PacmanPersistence.saveHighscore(PacMan.getUsername(), PacMan.getScore(), "src/main/resources/ui/JSON/scores.json");
        // Displays score in scoreboard
        String usersString = "";
        List<PacManUser> UserArray = PacmanPersistence.fetchHighscore("src/main/resources/ui/JSON/scores.json");
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
        PacMan.setScore(0);
        pacManGif.setLayoutX(330);
        pacManGif.setLayoutY(115);
        PacMan.setDX(0);;
        PacMan.setDY(0);;
        PacMan.setRotate(0);
        PacMan.setXPosition(330);
        PacMan.setYPosition(115);
        
        inky.changeDirection("DOWN");
        inky.setXPosition(548);
        inky.setYPosition(24);
        
        pinky.changeDirection("LEFT");
        pinky.setXPosition(395);
        pinky.setYPosition(290);

        blinky.changeDirection("RIGHT");
        blinky.setXPosition(23);
        blinky.setYPosition(32);

        clyde.changeDirection("LEFT");
        clyde.setXPosition(768);
        clyde.setYPosition(378);

        updateGUI();

    }
}