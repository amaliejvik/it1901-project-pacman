package ui;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import core.PacMan;

import static org.testfx.api.FxAssert.verifyThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class RemotePacManAppTest extends ApplicationTest {

  private Parent root;
  private RemotePacManController controller;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("remote-app/RemotePacMan.fxml"));
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

    }

    @Test
    @DisplayName("Test PacMan movement")
    public void testPacManMovementAndScore() {
        PacMan.reset();

        // Check that yellow PacMan is default
        verifyThat("#checkMark", NodeMatchers.isVisible());
        String expectedImageUrlYellow = "file:src/main/resources/ui/PacManModelYellow.gif";
        Image imageYellow = controller.getPacmanGif().getImage();
        String currentImageUrlYellow = imageYellow.getUrl();

        Assertions.assertEquals(expectedImageUrlYellow, currentImageUrlYellow);
        Assertions.assertEquals(427, controller.getCheckMark().getLayoutX());
        Assertions.assertEquals(242, controller.getCheckMark().getLayoutY());

        // Simulate choosing green PacMan
        clickOn("#greenPacManPhoto");
        verifyThat("#checkMark", NodeMatchers.isVisible());
        String expectedImageUrlGreen = "file:src/main/resources/ui/PacManModelGreen.gif";
        Image imageGreen = controller.getPacmanGif().getImage();
        String currentImageUrlGreen = imageGreen.getUrl();

        Assertions.assertEquals(expectedImageUrlGreen, currentImageUrlGreen);
        Assertions.assertEquals(497, controller.getCheckMark().getLayoutX());
        Assertions.assertEquals(242, controller.getCheckMark().getLayoutY());

        // Simulate choosing pink PacMan
        clickOn("#pinkPacManPhoto");
        verifyThat("#checkMark", NodeMatchers.isVisible());
        String expectedImageUrlPink = "file:src/main/resources/ui/PacManModelPink.gif";
        Image imagePink = controller.getPacmanGif().getImage();
        String currentImageUrlPink = imagePink.getUrl();

        Assertions.assertEquals(expectedImageUrlPink, currentImageUrlPink);
        Assertions.assertEquals(565, controller.getCheckMark().getLayoutX());
        Assertions.assertEquals(242, controller.getCheckMark().getLayoutY());

        // Simulate choosing orange PacMan
        clickOn("#orangePacManPhoto");
        verifyThat("#checkMark", NodeMatchers.isVisible());
        String expectedImageUrlOrange = "file:src/main/resources/ui/PacManModelOrange.gif";
        Image imageOrange = controller.getPacmanGif().getImage();
        String currentImageUrlOrange = imageOrange.getUrl();

        Assertions.assertEquals(expectedImageUrlOrange, currentImageUrlOrange);
        Assertions.assertEquals(625, controller.getCheckMark().getLayoutX());
        Assertions.assertEquals(242, controller.getCheckMark().getLayoutY());

        // Simulate choosing Light Mode
        clickOn("#toggleLightmode");

        // Simulate clicking on startbutton
        clickOn("#startButton");

        String expectedImageUrlLightMode = "file:src/main/resources/ui/mapgridLight.png";
        Image imageLightMode = controller.getMapGrid().getImage();
        String currentImageUrlLightMode = imageLightMode.getUrl();
        Assertions.assertEquals(expectedImageUrlLightMode, currentImageUrlLightMode);

        controller.startTimeline();

        double startXPos = controller.getPacmanGif().getLayoutX();

        while (true) {
            type(KeyCode.RIGHT, 1);
            if (Collisions.pacmanWallCollision(controller.getPacmanGif(),
                    controller.getTestCollisionRectangles().get(0))) {
                break;
            }
        }

        // Test that PacMan has moved to the right and rotation angle
        double xPosRight = controller.getPacmanGif().getLayoutX();
        double yPosRight = controller.getPacmanGif().getLayoutY();
        Assertions.assertTrue(startXPos < xPosRight);
        Assertions.assertEquals(0, controller.getPacmanGif().getRotate());

        while (true) {
            type(KeyCode.DOWN, 1);
            if (Collisions.pacmanWallCollision(controller.getPacmanGif(),
                    controller.getTestCollisionRectangles().get(1))) {
                break;
            }
        }

        // Test that PacMan has moved downwards and rotation angle
        double xPosDown = controller.getPacmanGif().getLayoutX();
        double yPosDown = controller.getPacmanGif().getLayoutY();
        Assertions.assertTrue(yPosRight < yPosDown);
        Assertions.assertEquals(90, controller.getPacmanGif().getRotate());

        while (true) {
            type(KeyCode.LEFT, 1);
            if (Collisions.pacmanWallCollision(controller.getPacmanGif(),
                    controller.getTestCollisionRectangles().get(2))) {
                break;
            }
        }

        // Test that PacMan has moved to the left and rotation angle
        double xPosLeft = controller.getPacmanGif().getLayoutX();
        double yPosLeft = controller.getPacmanGif().getLayoutY();
        Assertions.assertTrue(xPosDown > xPosLeft);
        Assertions.assertEquals(180, controller.getPacmanGif().getRotate());

        while (true) {
            type(KeyCode.UP, 1);
            if (Collisions.pacmanWallCollision(controller.getPacmanGif(),
                    controller.getTestCollisionRectangles().get(3))) {
                break;
            }
        }

        // Test that PacMan has moved upwards and rotation angle
        double yPosUp = controller.getPacmanGif().getLayoutY();
        Assertions.assertTrue(yPosLeft > yPosUp);

        Assertions.assertEquals(180, controller.getPacManUser().getScore());
        Assertions.assertEquals(270, controller.getPacmanGif().getRotate());

    }

    @Test
    @DisplayName("Test collision with ghosts and cherry")
    public void testCollision() {

        clickOn("#greenPacManPhoto");

        // Simulate clicking on startbutton
        clickOn("#startButton");

        controller.startTimeline();

        while (true) {
            type(KeyCode.RIGHT, 1);
            if (Collisions.pacmanWallCollision(controller.getPacmanGif(),
                    controller.getTestCollisionRectangles().get(0))) {
                break;
            }
        }

        while (true) {
            type(KeyCode.LEFT, 1);
            if (Collisions.pacmanGhostCollision(controller.getPacmanGif(), controller.getGhosts())) {
                break;
            }
        }
        assertEquals(170, controller.getPacManUser().getScore());

        controller.gameOver();
        clickOn("#restartGame");

    }
  }