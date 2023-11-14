module PacMan.springboot.rest {
    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter;
    requires com.google.gson;
    requires java.net.http;
    requires transitive PacMan.core;
    exports pacmann.springboot.restserver;
}
