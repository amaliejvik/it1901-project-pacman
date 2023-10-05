module PacMan.core {
    requires transitive javafx.graphics;
    requires com.google.gson;

    exports core;
    exports Persistence;

    opens core to com.google.gson;
}
