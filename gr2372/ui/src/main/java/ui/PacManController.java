package ui;

import java.util.Arrays;
import java.util.List;

import core.PacMan;
import core.PacManUser;
import core.Pinky;
import core.Blinky;
import core.Clyde;
import core.Ghost;
import core.Inky;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
import persistence.PacmanPersistence;

public class PacManController {

    //Data-oriented and gameloop attributes
    private Inky inky;
    private Pinky pinky;
    private Blinky blinky;
    private Clyde clyde;
    private List<Rectangle> walls;
    private List<Rectangle> testCollisionRectangles;
    private List<Rectangle> inkyCollisionRectangles;
    private List<Rectangle> blinkyCollisionRectangles;
    private List<Rectangle> pinkyCollisionRectangles;
    private List<Rectangle> clydeCollisionRectangles;
    private List<ImageView> pellets;
    private List<Ghost> ghosts;
    private List<ImageView> ghostsPNG;
    private Timeline timeline;
    private MediaPlayer mediaPlayer;
    private String chosenPacManColor;
    private PacManUser pacManUser;

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
    private ImageView yellowPacManPhoto;

    @FXML
    private ImageView greenPacManPhoto;

    @FXML
    private ImageView pinkPacManPhoto;

    @FXML
    private ImageView orangePacManPhoto;

    @FXML
    private ImageView checkMark;

    @FXML
    private Label choosePacManText;
  
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

    @FXML 
    private ImageView cherry;

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

                for (int i = 0; i < 4; i++) {
                    ghosts.get(i).setXPosition(ghosts.get(i).getXPosition() + ghosts.get(i).getDX());
                    ghosts.get(i).setYPosition(ghosts.get(i).getYPosition() + ghosts.get(i).getDY());
                    ghostsPNG.get(i).setLayoutX(ghosts.get(i).getXPosition());
                    ghostsPNG.get(i).setLayoutY(ghosts.get(i).getYPosition());
                }
                
                // COLLISION CHECK
                if (Collisions.PacmanWallCollision(pacManGif, walls)) {
                    PacMan.setDX(0);
                    PacMan.setDY(0);
                }
                
                if (Collisions.PacmanPelletCollision(pacManGif, pellets)) {
                    pacManUser.setScore(pacManUser.getScore()+10);
                }

                if (pacManUser.getScore() == 40) {
                    cherry.setVisible(true);
                }

                if (Collisions.PacmanCherryCollision(pacManGif, cherry)) {
                    cherry.setVisible(false);
                    pacManUser.setScore(pacManUser.getScore()+100);
                }

                if (Collisions.PacmanGhostCollision(pacManGif, ghostsPNG)) {
                    gameOver();
                }
                
                inky.pathing(inkyPNG, inkyCollisionRectangles);
                blinky.pathing(blinkyPNG, blinkyCollisionRectangles);
                pinky.pathing(pinkyPNG, pinkyCollisionRectangles);
                clyde.pathing(clydePNG, clydeCollisionRectangles);

                // UPDATES SCORE
                score.setText(Double.toString(pacManUser.getScore()));

                // ROTATES PACMAN
                pacManGif.setRotate(PacMan.rotationAngle());

                if (pacManUser.getScore() >= 660) {
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

        chooseYellowPacMan();
        
        pacManUser = new PacManUser();
        inky = new Inky();
        pinky = new Pinky();
        blinky = new Blinky();
        clyde = new Clyde();

        inky.reset();
        blinky.reset();
        pinky.reset();
        clyde.reset();

        walls = Arrays.asList(rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, 
                            rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27);
        
        pellets = Arrays.asList(pellet1, pellet2, pellet3, pellet4, pellet5, pellet6, pellet7, pellet8, pellet9, pellet10, pellet11, pellet12, pellet13,
                        pellet14, pellet15, pellet16, pellet17, pellet18, pellet19, pellet20, pellet21, pellet22, pellet23, pellet24, pellet25,
                        pellet26, pellet27, pellet28, pellet29, pellet30, pellet31, pellet32, pellet33, pellet34, pellet35, pellet36, pellet37,
                        pellet38, pellet39, pellet40, pellet41, pellet42, pellet43, pellet44, pellet45, pellet46, pellet47, pellet48, pellet49,
                        pellet50, pellet51, pellet52, pellet53, pellet54, pellet55, pellet56);

        testCollisionRectangles = Arrays.asList(collisionRect1, collisionRect2, collisionRect3, collisionRect4);
        inkyCollisionRectangles = Arrays.asList(collisionRect23, collisionRect12, collisionRect9, collisionRect10, collisionRect22, 
                                                collisionRect21, collisionRect15, collisionRect24, collisionRect20, collisionRect19, 
                                                collisionRect14, collisionRect16, collisionRect18, collisionRect17, collisionRect5, 
                                                collisionRect6, collisionRect13, collisionRect11, collisionRect7, collisionRect8);
        blinkyCollisionRectangles = Arrays.asList(collisionRect6, collisionRect13, collisionRect11, collisionRect7, collisionRect8, 
                                                collisionRect20, collisionRect19, collisionRect14, collisionRect16, collisionRect18, 
                                                collisionRect17, collisionRect5);
        pinkyCollisionRectangles = Arrays.asList(collisionRect3, collisionRect4, collisionRect1, collisionRect2);
        clydeCollisionRectangles = Arrays.asList(collisionRect21, collisionRect15, collisionRect3, collisionRect4, collisionRect12, 
                                                collisionRect9, collisionRect10, collisionRect22);

        ghostsPNG = Arrays.asList(inkyPNG, pinkyPNG, blinkyPNG, clydePNG);
        ghosts = Arrays.asList(inky, pinky, blinky, clyde);

        setComponentsVisible(false, gameOverScreen, gameOverText, restartGame, highScores, cherry);
        startButton.setDisable(true);

        createAndConfigureTimeline();

        updateGUI();
    }

    public ImageView getPacmanGif() {
        return pacManGif;
    }

    public PacManUser getPacManUser(){
        return pacManUser;
    }

    public List<Rectangle> getTestCollisionRectangles() {
        return testCollisionRectangles;
    }

    /**
     * Disables the startbutton if the username is invalid
     */
    @FXML
    public void updateGUI() {
        startButton.setDisable(true);
        String name = usernameInput.getText();
        if (!PacManUser.validateUsername(name)) {
            startButton.setDisable(true);
        } else {
            startButton.setDisable(false);
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

            setComponentsVisible(false, startButton, startScreen, username,
                                usernameInput, pacManText, toggleLightmode, checkMark, choosePacManText, 
                                yellowPacManPhoto, greenPacManPhoto, pinkPacManPhoto, orangePacManPhoto );

            switch (chosenPacManColor) {
                case ("YELLOW") :
                    pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModelYellow.gif"));
                    break;

                case ("GREEN") :
                    pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModelGreen.gif"));
                    break;

                case ("PINK") :
                    pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModelPink.gif"));
                    break;

                case ("ORANGE") :
                    pacManGif.setImage(new Image("file:src/main/resources/ui/PacManModelOrange.gif"));
                    break;
            }

            if (toggleLightmode.isSelected()) {
                mapGrid.setImage(new Image("file:src/main/resources/ui/mapgridLight.png"));

                for (ImageView pellet : pellets) {
                    pellet.setImage(new Image("file:src/main/resources/ui/smalldotLight.png"));
                }
                scoreText.setFill(Color.BLACK);
                score.setTextFill(Color.BLACK);
            } else {
                mapGrid.setImage(new Image("file:src/main/resources/ui/mapgrid.png"));

                for (ImageView pellet : pellets) {
                    pellet.setImage(new Image("file:src/main/resources/ui/smalldot.png"));
                }
                scoreText.setFill(Color.WHITE);
                score.setTextFill(Color.WHITE);
            }

            startTimeline();

            score.setText("0");

            setComponentsVisible(true, scoreText,score);
            
            pacManUser.setUsername(usernameInput.getText());
            pacManUser.setScore(0);
            
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
        
        // Save score to username in file
        PacmanPersistence.saveHighscore(pacManUser.getUsername(), pacManUser.getScore(), "src/main/resources/ui/JSON/scores.json");
        
        // Displays score in scoreboard
        String usersString = "";
        List<PacManUser> UserArray = PacmanPersistence.fetchHighscore("src/main/resources/ui/JSON/scores.json");
        StringBuffer buf = new StringBuffer();
        for (PacManUser user : UserArray) {
            buf.append(user.toString());
        }
        usersString = buf.toString();
        
        highScores.setText(usersString);
        
        setComponentsVisible(true, gameOverScreen, gameOverText, restartGame, highScores, toggleLightmode);
    }

    /**
     * Restarts game when restart button is pressed.
     * Resets Pacman's position, speed, direction and score.
     * Displays the startscreen.
     */
    @FXML
    private void handleRestartGameButton() {
        setComponentsVisible(false, gameOverScreen, gameOverText, restartGame, highScores, cherry);
       
        usernameInput.clear();

        setComponentsVisible(true, startButton, startScreen,username,
                            choosePacManText,yellowPacManPhoto,greenPacManPhoto,
                            pinkPacManPhoto, orangePacManPhoto,usernameInput,pacManText);
        
        for (ImageView pellet : pellets) {
            pellet.setVisible(true);
        }
        pacManGif.setLayoutX(330);
        pacManGif.setLayoutY(115);
        
        pacManUser.reset();
        PacMan.reset();
        inky.reset();
        blinky.reset();
        pinky.reset();
        clyde.reset();

        updateGUI();

    }

    @FXML
    private void chooseYellowPacMan(){
        checkMark.setLayoutX(427);
        checkMark.setLayoutY(242);
        checkMark.setVisible(true);
        this.chosenPacManColor = "YELLOW";
    }
    @FXML
    private void chooseGreenPacMan(){
        checkMark.setLayoutX(497);
        checkMark.setLayoutY(242);
        checkMark.setVisible(true);
        this.chosenPacManColor = "GREEN";
    }
    @FXML
    private void choosePinkPacMan(){
        checkMark.setLayoutX(565);
        checkMark.setLayoutY(242);
        checkMark.setVisible(true);
        this.chosenPacManColor = "PINK";
    }
    @FXML
    private void chooseOrangePacMan(){
        checkMark.setLayoutX(625);
        checkMark.setLayoutY(242);
        checkMark.setVisible(true);
        this.chosenPacManColor = "ORANGE";
    }

    private void setComponentsVisible(boolean isVisible, Node... components) {
        for (Node component : components) {
            component.setVisible(isVisible);
        }
    }
}
