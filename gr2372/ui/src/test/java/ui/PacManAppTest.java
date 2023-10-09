package ui;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import core.PacMan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PacManAppTest extends ApplicationTest {

    private Parent root;
    private PacManController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("app/PacMan.fxml"));
        root = fxmlLoader.load();
        this.controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT) {
                    PacMan.changeDirection("RIGHT");
                } else if (event.getCode() == KeyCode.LEFT) {
                    PacMan.changeDirection("LEFT");
                } else if (event.getCode() == KeyCode.DOWN) {
                    PacMan.changeDirection("DOWN");
                } else if (event.getCode() == KeyCode.UP) {
                    PacMan.changeDirection("UP");
                }
            }
        });

    }

    public Parent getRootNode() {
        return root;
    }

    @BeforeEach
    public void initializeGame(){
        // Simulate clicking on the username TextField
        clickOn("#usernameInput");

        // Simulate typing a username
        write("TestUser");

        // Simulate clicking on startbutton
        clickOn("#startButton");

        controller.initialize();
        controller.startTimeline();
    }

    @Test
    public void testPacManMovementAndScore() {

        double pacManStartX = controller.getPacMan().getXPosition();
        double pacManStartY = controller.getPacMan().getYPosition();

        while (controller.getPacMan().getXPosition() < 548){
            if(controller.getPacMan().getXPosition() >= 548){
                break;
            }
            type(KeyCode.RIGHT, 1);
        }

        double pacManXRight = controller.getPacMan().getXPosition();
        double pacManYRight = controller.getPacMan().getYPosition();

        assertTrue((pacManStartX < pacManXRight), "Check that PacMan moves to the RIGHT when right-arrow-key is pressed");

        while(controller.getPacMan().getYPosition() < 378){
            if(controller.getPacMan().getYPosition()>= 378){
                break;
            }
            type(KeyCode.DOWN, 1);
        }

        double pacManXDown = controller.getPacMan().getXPosition();
        double pacManYDown = controller.getPacMan().getYPosition();

        assertTrue((pacManYRight < pacManYDown), "Check that PacMan moves DOWNWARDS when downwards-arrow-key is pressed");

        while(controller.getPacMan().getXPosition() > 239){
            if(controller.getPacMan().getXPosition() <= 239){
                break;
            }
            type(KeyCode.LEFT, 1);
        }

        double pacManXLeft = controller.getPacMan().getXPosition();
        double pacManYLeft = controller.getPacMan().getYPosition();

        assertTrue((pacManXDown > pacManXLeft), "Check that PacMan moves to the LEFT when left-arrow-key is pressed");
 
        while(controller.getPacMan().getYPosition() > 110){
            if(controller.getPacMan().getYPosition() <= 110){
                break;
            }
            type(KeyCode.UP, 1);
        }

        double pacManXUp = controller.getPacMan().getXPosition();
        double pacManYUp = controller.getPacMan().getYPosition();
    
        assertTrue((pacManYLeft > pacManYUp), "Check that PacMan moves UPWARDS when upwards-arrow-key is pressed");

        assertEquals(controller.getPacMan().getScore(), 140);
        
    }

}   