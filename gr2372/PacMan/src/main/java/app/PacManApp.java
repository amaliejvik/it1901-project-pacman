package app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class PacManApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PacMan.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.RIGHT) {
                    PacManController.changeDirection("RIGHT");
                } else if (event.getCode() == KeyCode.LEFT) {
                    PacManController.changeDirection("LEFT");
                } else if (event.getCode() == KeyCode.DOWN) {
                    PacManController.changeDirection("DOWN");
                } else if (event.getCode() == KeyCode.UP) {
                    PacManController.changeDirection("UP");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}