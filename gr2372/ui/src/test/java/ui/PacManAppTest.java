package ui;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;
import static org.testfx.api.FxAssert.verifyThat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PacManAppTest extends ApplicationTest {

    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("app/PacMan.fxml"));
        root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public Parent getRootNode() {
        return root;
    }

    @Test
    public void testGameStart() {

        // Simulate clicking on the username TextField
        clickOn("#usernameInput");

        // Simulate typing a username
        write("TestUser");

        // Check that username was written
        verifyThat("#usernameInput", hasText("TestUser"));

        // Simulate clicking on startbutton
        clickOn("#startButton");

    }

}
