package ui;

import core.PacMan;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;
import static org.testfx.api.FxAssert.verifyThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    }

    @Test
    public void testGameStart() {

        // Check that username was written
        verifyThat("#usernameInput", hasText("TestUser"));

        // Simulate clicking on startbutton
        clickOn("#startButton");

    }


    @Test
    public void testPacManMovementAndScore() {

        // Simulate clicking on startbutton
        clickOn("#startButton");

        controller.initialize();
        controller.startTimeline();

        while (true) {
            type(KeyCode.RIGHT, 1);
            if (Collisions.PacmanWallCollision(controller.getPacmanGif(), controller.getCollisionRectangles())) {
                break;
            }
        }

        while (true) {
            type(KeyCode.DOWN, 1);
            if (Collisions.PacmanWallCollision(controller.getPacmanGif(), controller.getCollisionRectangles())) {
                break;
            }
        }

        while (true) {
            type(KeyCode.LEFT, 1);
            if (Collisions.PacmanWallCollision(controller.getPacmanGif(), controller.getCollisionRectangles())) {
                break;
            }
        }

        while (true) {
            type(KeyCode.UP, 1);
            if (Collisions.PacmanWallCollision(controller.getPacmanGif(), controller.getCollisionRectangles())) {
                break;
            }
        }

        assertEquals(180, PacMan.getScore());
        
    }

}
