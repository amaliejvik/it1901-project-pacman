package app;

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

    //ATTRIBUTTER
    @FXML
    private ImageView mapGrid;
    
    @FXML
    private Button startbutton; 
    
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

    //TIMELINE

    Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent event) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'handle'");
        }
        

        
    }));
    

    @FXML
    private void handleStartButton(){
        try{
            mainBackground.getChildren().removeAll(startbutton, startScreen,username,usernameInput,pacManText);
        }
        catch (Exception e){
            System.out.println("Could not start animation");
        }

    }

    public void gameOver(){
        timeline1.stop();
        Rectangle gameoverScreen = new Rectangle(250, 250);
        Button restartGame = new Button("Restart Game", gameoverScreen);
        //Legge inn fxml sånn at vi får en game over screen med highscore
        mainBackground.getChildren().add( gameoverScreen);
        
         //lagre score automatisk på brukernavnet som er oppgitt
        
    }

    public void restartGame(){
        handleStartButton();
        //starte spillet på nytt igjen
    }


    private PacMan pacMan;

    public PacManController() {

        return;
    }
}
