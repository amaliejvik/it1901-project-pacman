# README for PacMan

This is the main documentation for a JavaFX version of the game PacMan, from the class IT1901 (1.semester 2023-2024).
It has been made collaboratively with Søren Boucher, Amalie Johansen-Vik, Jenny Müller and Herman Østenby.
It will contain a total of 3 releases.

## About the application

Our goal for this application was to create a game that resembles the original PacMan arcade game. The user enters a username and can choose between lightmode/darkmode and different colors of PacMan, before starting the game. PacMan is controlled with the arrow keys, and the goal is to move around the maze gathering as many points as possible by eating pellets. This must be done without crashing in the four ghosts roaming the board. The game is over when hit by a ghost or when all pellets are eaten, and a highscorelist is revealed.

## How to build and run the application

We used Maven for project management. 

**TODO** *Change between local and remote?*

**All commands shown below assume that your terminal is in the gr2372 folder.** If unsure, open a new terminal tab and try the commands again.

An initial [mvn clean install -DskipTests](#clean-install) must be performed before starting the server or running or testing the application.

#### Clean install

To build the application, run `mvn clean install -DskipTests` from the folder containing the parent pom.xml file. The parent pom is located in the *gr2372/**pacMan-application*** directory. The clean install command cleans all previous build files, if any, and creates new class files. The tests are skipped for this preliminary command to avoid any potetential errors with out of date class files. If a test fails or throws an error the clean install process is interrupted and the correct class files are not installed. The following commands navigate to the correct folder and initiate the clean install.

```bat
cd pacMan-application
mvn clean install -DskipTests
```

#### Start the server

The server that the application uses to store high scores must be started before running the application. To start the server, navigate to the *gr2372/pacMan-application/springboot/**restserver*** directory, and run the `mvn spring-boot:run` command. After the server has started, the application must be run from a different terminal tab or window. Terminal commands shown below.

```bat
cd pacMan-application/springboot/restserver
mvn spring-boot:run
```

#### Run the application

In a new terminal tab or window, navigate to the the **ui**-module and run the `mvn javafx:run` command. The **ui**-module is located in the *gr2372/pacMan-application/**ui*** directory. Terminal commands shown below.
```bat
cd pacMan-application/ui
mvn javafx:run
```

## How to test the application

 To run the tests on the application, run the  `mvn test` command from the **pacMan-application** folder. The server must be running before beginning the tests. See [Start the Server](#start-the-server) for more information.

 ```bat
cd pacMan-application
mvn test
```

## Documentation and User Scenario

By clicking on the links below you will be redirected to the README-files from each release.

[Documentation for release1](/pacMan-application/docs/release1/README.md)

[Documentation for release2](/pacMan-application/docs/release2/README.md)

[Documentation for release3](/pacMan-application/docs/release3/README.md)

By clicking the links below, you will be redirected to our 4 different user stories, which the functionality has been based upon.

[User Scenario 1: Roger](/pacMan-application/docs/userstories/userstory1.md)

[User Scenario 2: Selma](/pacMan-application/docs/userstories/userstory2.md)

[User Scenario 3: Turid](/pacMan-application/docs/userstories/userstory3.md)

[User Scenario 4: Eric](/pacMan-application/docs/userstories/userstory4.md)

The rest of the documentation for this project can be found in the [docs-folder](/pacMan-application/docs). This includes README-files for our workflow, our approach to testing, code quality and diagrams.

## Eclipse Che

Click the link below to open the project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

[Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)

## Project Architecture

The project is organized into distinct modules, with each module dedicated to specific functionalities or aspects of the architecture. We have categorized them into core, UI, and Spring Boot/REST server:

- [core](/pacMan-application/core/README.md): Includes classes for the representation and storage of high scores.

- [ui](/pacMan-application/ui/README.md): Encompasses the application user interface, developed using JavaFX and FXML.

- [springboot/restserver](/pacMan-application/springboot/restserver/README.md): Involves the REST API and server built on the Spring Boot framework.

Underneath you can see the architecture diagram for the project, which is thoroughly explained in the [readme](/pacMan-application/docs/diagrams/release3/README.md).
![Package diagram](/pacMan-application/docs/diagrams/release3/package.png)


## Workflow

The group has attempted having the best possible workflow during this project. This can be read about in detail under [workflow](/pacMan-application/docs/workflow/README.md) in docs.

## Testing

The group's approach to testing of the application can be read about in detail [here](/pacMan-application/docs/testing/README.md).


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