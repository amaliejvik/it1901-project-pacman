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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PacManController {
    
    
    //FXML-ATTRIBUTES

    @FXML
    private AnchorPane mainBackground;

    @FXML
    private ImageView mapGrid;

    @FXML
    private Button startButton;

    @FXML
    private Rectangle startScreen;

    //Walls in mapgrid
    @FXML
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27;

    //Pellets to be eaten by PacMan
    @FXML
    private ImageView pellet1, pellet2, pellet3, pellet4;

    @FXML
    private TextField usernameInput;

    @FXML
    private Label pacManText;
    
    @FXML
    private Label username;
    
    //PacMan model
    @FXML
    private ImageView pacManGif;
    
    @FXML
    private Label score;
    
    @FXML
    private Text yourScoreText;
    
    @FXML 
    private Rectangle rectScore;

    //PacManGameOver
    @FXML
    private TextArea seeHighScore;
    
    // PacManHighScores
    @FXML
    private TextArea highScores;

    @FXML
    private Button backButton;
    
    //Regular attributes
    private Stage stage;
    private PacMan pacMan;
    private List<Rectangle> walls = new ArrayList<>();
    private List<ImageView> pellets = new ArrayList<>();
    
    /**
     * Controller constructor
     */
    public PacManController() {
        return;

    }
    
    /**
     * Initializes the game
     */
    public void initialize() {

        //Adds walls to array
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

        //Adds pellets to array
        pellets.add(pellet1);
        pellets.add(pellet2);
        pellets.add(pellet3);
        pellets.add(pellet4);
        
        //Disables startbutton
        startButton.setDisable(true);

        //Hides the score
        rectScore.setVisible(false);
        yourScoreText.setVisible(false);
        score.setVisible(false);
        
        updateGUI();
    }
    
    
    //Main game-loop
    Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {

            //Updates PacMan's position
            pacMan.setXPosition(pacMan.getXPosition() + PacMan.dx);
            pacMan.setYPosition(pacMan.getYPosition() + PacMan.dy);

            //Updates PacMan's graphical location
            pacManGif.setLayoutX(pacMan.getXPosition());
            pacManGif.setLayoutY(pacMan.getYPosition());

            //Checks collision with walls and pellets
            pacMan.checkWallCollision(pacManGif, walls);
            pacMan.checkPelletCollision(pacManGif, pellets);

            //Displays score
            score.setText(Integer.toString(pacMan.getScore()));

            //Rotates PacMan
            pacManGif.setRotate(pacMan.rotationAngle());
        }
    }));

    /**
     * Stops game, saves score
     */
    public void gameOver() {
        timeline1.stop();
        PacmanReadAndWrite.saveScore(pacMan.getScore()); //Saves score to username
        setScoreGameOverScreen(); //Changes text so user can see their score
        switchToGameOverBackground(); //Switches to game over screen
    }

    @FXML
    private void handleStartButton() {
        try {

            //Removes startscreen
            startButton.setVisible(false);
            startScreen.setVisible(false);
            username.setVisible(false);
            usernameInput.setVisible(false);
            pacManText.setVisible(false);

            //Starts main game-loop
            timeline1.setCycleCount(Timeline.INDEFINITE);
            timeline1.play();

            //Generates new PacMan object
            pacMan = new PacMan();

            //Displays score
            score.setText("0");
            rectScore.setVisible(true);
            yourScoreText.setVisible(true);
            score.setVisible(true);


            PacmanReadAndWrite.saveUserName(usernameInput.getText());
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not start game");
        }
    }

    @FXML
    private void handleHighScoreButton() {
        highScores.setText(PacmanReadAndWrite.fetchScoreBoard()); // fetches highscores and sets text area to this
        // TODO: update and reset highscoretable every time highscore button is pressed
        switchToPacManHighScore();
        // TODO: legge inn restart knapp her også
    }

    @FXML
    public void handleRestartButton() {
        handleStartButton();
        switchToPacMan(); // change to PacMan screen, unsure if this is needed here
    }

    @FXML
    public void handleBackButton() {
        switchToGameOverBackground();
    }

    public void setScoreGameOverScreen() {
        seeHighScore.appendText(String.valueOf(pacMan.getScore()));
    }

    /**
     * Updates the graphical elements
     * Validates username to not contain any spaces
     */
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

    public void switchToPacManHighScore() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PacManHighScore.fxml"));
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

}
