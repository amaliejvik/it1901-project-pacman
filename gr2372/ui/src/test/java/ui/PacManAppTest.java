package ui;
/* 
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
    public void initializeGame() {
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
        PacMan pacman = new core.PacMan();

        double pacManStartX = PacMan.getXPosition();
        double pacManStartY = PacMan.getYPosition();

        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);

        double pacManXRight = PacMan.getXPosition();
        double pacManYRight = PacMan.getYPosition();

        assertTrue((pacManStartX < pacManXRight) && (pacManStartY == pacManYRight),
                "Check that PacMan moves to the right when right-arrow-key is pressed");

        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);
        press(KeyCode.LEFT);

        double pacManXLeft = PacMan.getXPosition();
        double pacManYLeft = PacMan.getYPosition();

        assertTrue((pacManXRight > pacManXLeft) && (pacManYLeft == pacManYRight),
                "Check that PacMan moves to the left when left-arrow-key is pressed");

        press(KeyCode.UP);
        press(KeyCode.UP);
        press(KeyCode.UP);
        press(KeyCode.UP);

        double pacManXUp = PacMan.getXPosition();
        double pacManYUp = PacMan.getYPosition();

        assertTrue((pacManXLeft == pacManXUp) && (pacManYLeft > pacManYUp),
                "Check that PacMan moves UPWARDS when upwards-arrow-key is pressed");

        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        press(KeyCode.DOWN);
        release(KeyCode.DOWN);

        double pacManXDown = PacMan.getXPosition();
        double pacManYDown = PacMan.getYPosition();

        assertTrue((pacManXUp == pacManXDown) && (pacManYUp < pacManYDown),
                "Check that PacMan moves DOWNWARDS when downwards-arrow-key is pressed");

        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);
        press(KeyCode.RIGHT);

        assertEquals(50, pacman.getScore(), "Check that score increases when PacMan eats a pellet");

    }
}
*/