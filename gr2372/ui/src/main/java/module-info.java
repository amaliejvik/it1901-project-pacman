module PacMan.ui {
    requires PacMan.core;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ui to javafx.graphics, javafx.fxml;
}
