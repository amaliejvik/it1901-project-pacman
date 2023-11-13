# README for PacMan

This is the main documentation for a JavaFX version of the game PacMan, from the class IT1901 (1.semester 2023-2024).
It has been made collaboratively with Søren Boucher, Amalie Johansen-Vik, Jenny Müller and Herman Østenby.
It will contain a total of 3 releases.

## About the application

Our goal for this application was to create a game that resembles the original PacMan arcade game. The user enters a username and can choose between lightmode/darkmode and different colors of PacMan, before starting the game. PacMan is controlled with the arrow keys, and the goal is to move around the maze gathering as many points as possible by eating pellets. This must be done without crashing in the four ghosts roaming the board. The game is over when hit by a ghost or when all pellets are eaten, and a highscorelist is revealed.

## How to build and run the application
*TODO*: local or remote?
We are using the project management build tool, Maven.

To build the application, run  `mvn install -DskipTests` from the root-folder (**gr2372**-folder). In addition to building, this command will run all tests and code-quality-checks.

```bat
cd gr2372
mvn install -DskipTests
```

To run the application, run  `mvn javafx:run` from the **ui**-module (>gr2372>**ui**). This can be done by first running `cd gr2372/ui` followed by `mvn javafx:run`.

```bat
cd gr2372/ui
mvn javafx:run
```

## How to test the application

 To run the tests on the application, run  `mvn test` from the (**gr2372**-folder).

 ```bat
cd gr2372
mvn test
```

## Documentation and User Scenario

By clicking on the links below you will be redirected to the README-files from each release.

[Documentation for release1](/gr2372/docs/release1/README.md)

[Documentation for release2](/gr2372/docs/release2/README.md)

[Documentation for release3](/gr2372/docs/release3/README.md)

By clicking the links below, you will be redirected to our 4 different user stories, which the functionality has been based upon.

[User Scenario 1: Roger](/gr2372/docs/userstories/userstory1.md)

[User Scenario 2: Selma](/gr2372/docs/userstories/userstory2.md)

[User Scenario 3: Turid](/gr2372/docs/userstories/userstory3.md)

[User Scenario 4: Eric](/gr2372/docs/userstories/userstory4.md)

The rest of the documentation for this project can be found in the [docs-folder](/gr2372/docs). This includes README-files for our workflow, our approach to testing, code quality and diagrams.

## Eclipse Che

Click the link below to open the project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

[Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)

## Project Architecture

The project is organized into distinct modules, with each module dedicated to specific functionalities or aspects of the architecture. We have categorized them into core, UI, and Spring Boot/REST server:

- [core](/gr2372/core/README.md): Includes classes for the representation and storage of high scores.

- [ui](/gr2372/ui/README.md): Encompasses the application user interface, developed using JavaFX and FXML.

- [springboot/restserver](/gr2372/springboot/restserver/README.md): Involves the REST API and server built on the Spring Boot framework.

Underneath you can see the architecture diagram for the project, which is thoroughly explained in the [readme](/gr2372/docs/diagrams/release3/README.md).
![Package diagram](image-1.png)


## Workflow

The group has attempted having the best possible workflow during this project. This can be read about in detail under [workflow](/gr2372/docs/workflow/README.md) in docs.

## Testing
*TODO*

## Current versions of software

Java version: 17.0.8

Maven version: 3.9.4

## Dependencies required to run application and tests

**JavaFX:**

    javafx-controls
    Version 17.0.8

    javafx-fxml
    Version 17.0.8

    javafx-media
    Version 17.0.8

**JUnit testing with jupiter:**

    junit-jupiter-api
    Version 5.10.0

    junit-jupiter-engine
    Version 5.10.0

    junit-jupiter-params
    Version 5.10.0

**Test JavaFX with TextFX:**

    testfx-junit5
    Version 4.0.16-alpha

    testfx-core
    Version 4.0.16-alpha

    hamcrest
    Version 2.2

**Jacoco:**

    org.jacoco.agent
    Version 0.8.7

**GSON:**

    com.google.code.gson
    Version 2.10.1