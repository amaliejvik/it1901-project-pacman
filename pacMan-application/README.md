# README for PacMan

This is the main documentation for a JavaFX version of the game PacMan, from the class IT1901 (fall semester 2023).
It has been made collaboratively by Søren Boucher, Amalie Johansen-Vik, Jenny Müller and Herman Østenby.
It contains a total of 3 releases.

The rest of the documentation for this project can be found in the [docs-folder](/pacMan-application/docs). This includes README-files for our workflow, our approach to testing, code quality and diagrams.

**Key points:**

- [README for PacMan](#readme-for-pacman)
  - [About the application](#about-the-application)
  - [How to build and run the application](#how-to-build-and-run-the-application)
      - [Clean install](#clean-install)
      - [Start the server](#start-the-server)
      - [Run the application](#run-the-application)
  - [How to test the application](#how-to-test-the-application)
  - [Eclipse Che](#eclipse-che)
  - [Shippable product](#shippable-product)
  - [Releases](#releases)
  - [Userstories](#userstories)
  - [Project Architecture](#project-architecture)
  - [Workflow](#workflow)
  - [Testing](#testing)
  - [Current versions of software](#current-versions-of-software)
  - [Dependencies required to run application and tests](#dependencies-required-to-run-application-and-tests)
  - [Plugin Versions](#plugin-versions)
  - [Comment on MediaPlayer](#comment-on-mediaplayer)

## About the application

Our goal for this application was to create a game that resembles the original PacMan arcade game. The user enters a username and chooses whether he/she wants to enable lightmode. Additionally, the user can choose between four different colors on PacMan, before starting the game. PacMan is controlled with the arrow keys, and the goal is to move around the maze gathering as many points as possible by eating pellets. This must be done without crashing in the four ghosts roaming the board. The game is over when PacMan is hit by a ghost or when all pellets are eaten, and a highscore list is revealed.

## How to build and run the application

We used Maven for project management. 

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

## Eclipse Che

Click the link below to open the project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

After entering the workspace, follow the guide on [How to build and run the application](#how-to-build-and-run-the-application) and [How to test the application](#how-to-test-the-application).

[Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)

**NOTE 1**: On the start screen of the application, a green checkmark appears on the PacMan-color the user has chosen, in order to fulfill design principles on feedback. For some reason, this checkmark does not appear when the application is ran in Eclipse Che. We are not sure why this problem has arisen, since it works perfectly when run locally with Maven and with JPackage. 

How it is supposed to look is illustraded below:
![StartScreen](/pacMan-application/ui/src/main/resources/ui/README-Images/pacManStartScreen.png)

**NOTE 2**: The use of Mediaplayer is also documented [here](#comment-on-mediaplayer)

## Shippable product

The application can be produced into a shippable product.
A guide can be found in the [here](/pacMan-application/docs/release3/README.md#5-made-the-application-a-shippable-product) in READme for release 3.

## Releases

During the semester, we have made three releases of the application.

 By clicking on the links below you will be redirected to the README-files from each release.

[Documentation for release1](/pacMan-application/docs/release1/README.md)

[Documentation for release2](/pacMan-application/docs/release2/README.md)

[Documentation for release3](/pacMan-application/docs/release3/README.md)

## Userstories

In order to visualise and understand which functionality our app should have, we made different user stories.

By clicking the links below, you will be redirected to our 4 different user stories, upon which the functionality has been based.

[User Scenario 1: Roger](/pacMan-application/docs/userstories/userstory1.md)

[User Scenario 2: Selma](/pacMan-application/docs/userstories/userstory2.md)

[User Scenario 3: Turid](/pacMan-application/docs/userstories/userstory3.md)

[User Scenario 4: Eric](/pacMan-application/docs/userstories/userstory4.md)

## Project Architecture

The project is organized into distinct modules, with each module dedicated to specific functionalities or aspects of the architecture. We have categorized them into core, UI, and Spring Boot/REST server:

- [core](/pacMan-application/core/README.md): Includes classes for the representation and storage of high scores.

- [ui](/pacMan-application/ui/README.md): Encompasses the application user interface, developed using JavaFX and FXML.

- [springboot/restserver](/pacMan-application/springboot/restserver/README.md): Utilizes the REST API to build a server with the Spring Boot framework.

The architecture diagram for the project, which is thoroughly explained in the [Diagram-README](/pacMan-application/docs/diagrams/release3/README.md), is shown below.
![Package diagram](/pacMan-application/docs/diagrams/release3/package.png)


## Workflow

The group aimed to have an efficient workflow during this project. Detailed information can be found under [workflow](/pacMan-application/docs/workflow/README.md) in docs.

## Testing

The group's approach to testing of the application can be read about in detail under [testing](/pacMan-application/docs/testing/README.md) in docs.


## Current versions of software

Java version: 17.0.8

Maven version: 3.11.0

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

    testfx-core
    Version 4.0.16-alpha

    testfx-junit5
    Version 4.0.16-alpha

    hamcrest
    Version 2.2

**Jacoco:**

    org.jacoco.agent
    Version 0.8.10

**GSON:**

    com.google.code.gson
    Version 2.10.1

**Springboot**

    spring-boot-starter-web
    Version 2.7.5

    spring-boot-starter-jetty
    Version 2.7.5

    spring-boot-starter-test
    Version 2.7.5

## Plugin Versions

    Checkstyle
    Version 10.3.4

<br>

    SpotBugs
    Version 4.7.3.6

<br>

    JPackage
    Version 1.4.0

## Comment on MediaPlayer

In release 2, we added music as a new feature to our application with a MediaPlayer in PacManController. When clicking the start button, the old school PacMan soundtrack started playing. This worked perfectly when running the application locally with Maven. 

However, this led to an error when trying to run it with Eclipse Che. We tried to reach out to both our Teaching Assistent, on Piazza and to the professional staff of the subject but no one seemed to understand what caused this problem. 

As a result, we chose to comment out the code tied to the MediaPlayer in both PacManController and RemotePacManController. We did not want to remove it completely, because it was an important part of our expanded functionality in release 2. In addition we have documentation and a user story connected to it. 

If you are to run the application or test *locally with Maven*, simply comment in the following lines in these classes, and you will hear the sound track:

**PacManController**

- Line 38-39
- Line 62
- Line 448-458
- Line 565

**RemotePacManController:**

- Line 36-37
- Line 62
- Line 448-458
- Line 578