module PacMan.core {
    requires transitive javafx.graphics;
    requires com.google.gson;

    exports core;
    exports persistence;

    opens core to com.google.gson;
}
