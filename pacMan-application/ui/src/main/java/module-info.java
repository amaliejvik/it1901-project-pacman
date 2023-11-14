module PacMan.ui {
    requires PacMan.core;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires java.net.http;
    requires com.google.gson;

    opens ui to javafx.graphics, javafx.fxml;
}
