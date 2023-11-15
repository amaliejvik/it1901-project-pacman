# README for release 3 of PacMan



This is the README for the third and last release of our PacMan game. 

## Filestructure

   ```
├── pacMan-application
|   ├── .vscode  
|   |      ├── launch.json
|   |      └── settings.json                        
|   ├── config
|   |      ├── checkstyles
|   |      |     └── eclipse-java-google-style.xml
|   |      └──spotbugs
|   |            └──exclude.xml
|   ├── core
|   |      └── src
|   |      |      ├── main/java
|   |      |      |       ├── core
|   |      |      |       |     ├── Blinky.java
|   |      |      |       |     ├── Clyde.java
|   |      |      |       |     ├── Ghost.java
|   |      |      |       |     ├── Inky.java
|   |      |      |       |     ├── PacMan.java
|   |      |      |       |     ├── PacManUser.java
|   |      |      |       |     └── Pinky.java
|   |      |      |       ├── persistance
|   |      |      |       |         ├──JSON
|   |      |      |       |         |   └──remoteScores.json
|   |      |      |       |         └── PacManPersistence.java
|   |      |      |       └── module-info.java
|   |      |      └── test
|   |      |            └── java/core
|   |      |                    ├──JSON
|   |      |                    |   └── testScores.json
|   |      |                    ├── GhostTest.java
|   |      |                    ├── PacManPersistenceTest.java
|   |      |                    ├── PacManTest.java
|   |      |                    └── PacManUserTest.java
|   |      ├── pom.xml 
|   |      └── README.md        
|   ├── docs
|   |      ├── codequality
|   |      |         └── README.md
|   |      ├── diagrams
|   |      |         ├── release2
|   |      |         |      ├── class.png
|   |      |         |      ├── class.puml
|   |      |         |      ├── package.png
|   |      |         |      ├── package.puml
|   |      |         |      ├── sequence.png
|   |      |         |      └──sequence.puml
|   |      |         └── release3
|   |      |                ├── class.png
|   |      |                ├── class.puml
|   |      |                ├── package.png
|   |      |                ├── package.puml
|   |      |                ├── README.md
|   |      |                ├── sequence_local.png
|   |      |                ├── sequence_local.puml
|   |      |                ├── sequence_remote.png
|   |      |                └──sequence_remote.puml
|   |      ├── release1
|   |      |       ├── PacMan , code coverage - JaCoCoReport, release1.png
|   |      |       └── README.md
|   |      ├── release2
|   |      |        ├── README.md
|   |      |        └── PacMan , code coverage - JaCoCoReport, release2.png
|   |      ├── release3
|   |      |        ├── jacoco3
|   |      |        |      ├── blinky.png
|   |      |        |      ├── clyde.png
|   |      |        |      ├── core.png
|   |      |        |      ├── ghost.png
|   |      |        |      ├── inky.png
|   |      |        |      ├── pacMan.png
|   |      |        |      ├── pacManController.png
|   |      |        |      ├── pacManPersistence.png
|   |      |        |      ├── pacManUser.png
|   |      |        |      ├── pinky.png
|   |      |        |      ├── remotePacManController.png
|   |      |        |      └── ui.png
|   |      |        └── README.md
|   |      ├──testing
|   |      |        └── README.md    
|   |      ├── userstories
|   |      |        ├── userstory1.md
|   |      |        ├── userstory2.md
|   |      |        ├── userstory3.md
|   |      |        └── userstory4.md
|   |      └──workflow
|   |      |        └── README.md
|   ├── springboot/restserver       
|   |              ├── src    
|   |              |      ├──  main/java 
|   |              |      |      ├── pacmann/springboot/restserver  
|   |              |      |      |      ├── PacManModelApplication.java
|   |              |      |      |      ├── PacManModelController.java
|   |              |      |      |      └── PacManModelService.java
|   |              |      |      └── module-info.java
|   |              |      └── test/java/pacmann/springboot/restserver
|   |              |             └── PacManModelApplicationTests.java
|   |              ├── pom.xml 
|   |              └── README.md
|   ├── ui
|   |    ├── src
|   |    |     ├── main
|   |    |     |    ├── java
|   |    |     |    |    ├──ui
|   |    |     |    |    |   ├── Collisions.java
|   |    |     |    |    |   ├── PacManApp.java
|   |    |     |    |    |   ├── PacManController.java
|   |    |     |    |    |   ├── RemotePacManApp.java
|   |    |     |    |    |   ├── RemotePacManController.java
|   |    |     |    |    |   └── RemotePacManModelAccess.java
|   |    |     |    |    └── module-info.java
|   |    |     |    └── resources/ui
|   |    |     |           ├── app
|   |    |     |           |     └── PacMan.fxml
|   |    |     |           ├── JSON
|   |    |     |           |     ├── appTestsScores.json
|   |    |     |           |     └── scores.json
|   |    |     |           ├── remote-app
|   |    |     |                └── RemotePacMan.fxml
|   |    |     | 
|   |    |     └── test
|   |    |         ├── PacManAppTest.java
|   |    |         └── RemotePacManAppTest.java
|   |    ├── pom.xml
|   |    └── README.md   
|   ├── .gitignore                              : Files and directories to be ignored by git    
|   ├── pom.xml                                 : Maven file to correctly load structure and dependecies in the project
|   └── README.md                               : Description of this repository
├── .gitignore                                  : Files and directories to be ignored by git 
├── devfile.yaml                                : File that enables the project to be opened with Eclipse Che 
```

## What have we done since the second release?

For the third release, the group could either extend the JavaFX application with new functionality or create a new client with new technology such as React. After some discussion, we chose new features with JavaFX, as we saw it more natural to implement the functionality we wanted, before creating a new client. None of the team members had earlier experience with the new frontend technologies suggested. Although it would be interesting to learn something new, we concluded it would be very time consuming considering the size and relative complexity of our code base.

<br>

### 1. Implement new functionality

As mentioned above, we chose to implement new functionality for our application.

This is what we chose to implement for the 3rd release, based on [Userstory4](/pacMan-application/docs/userstories/userstory4.md):

- Ghosts: Inky, Pinky, Blinky and Clyde from the original PacMan game have added to the gave. If they collide with PacMan, it's game over.
- Berries: after playing a while a berry pops up on the screen, and if PacMan eats it, it gets an extra points
- Color choice: you can now chose PacMan to 4 different colours: pink, green, yellow and orange.

<br>

### 2. Implement REST API with SpringBoot

One of the primary goals for this release is to eliminate the need for the client to store their highscores locally. Instead we aimed to implement a REST API to enable the application to store highscores remotely on a server. This implementation has numerous benefits, but most importantly the ability for multiple users to save their highscores in the same place. This means that users can compete with eachother indirectly from different machines.
<br>
<br>
There are numerous ways to implement a RESTAPI, and we chose to use Spring Boot which is a tool that makes this possible. We opted for Spring Boot because to its inherent simplicity, widespread adoption, and its significant relevance in a professional environment.

<br>

### 3. Write tests for new functionality and improve overall test coverage

The implementation of the RestAPI as well as adding new functionality to the application led to many new classes and methods in multiple modules.
In other words, a lot of new code needed to be tested in order to maintain a well functioning code base.

More on the tests made for release3 can be found at the bottom of the READMEs for each of the modules:

- [Approach to testing in Core](/pacMan-application/core/README.md#approach-to-testing-of-the-core-module)

- [Approach to testing in UI](/pacMan-application/ui/README.md#approach-to-testing-of-the-ui-module)

- [Approach to testing in Restserver](/pacMan-application/springboot/restserver/README.md#approach-to-testing-of-the-springbootrestserver-module)


<br>

### 4. Update the package- class- and sequential-diagram with PlantUML

In the new release we have added a new sequential diagram that shows how scores are storage remotely. This makes it easier to understand the similarities and differences between local and remote version of the application. The other diagrams, class and architecture, have been updated to reflect the new functionality and restserver implementation. You can read more about the diagrams and see them [here](/pacMan-application/docs/diagrams/release3/README.md).


<br>

### 5. Made PacMan a shippable product

*TODO*

<br>

### 6. Improved our code quality
Multiple tools have been used to ensure a high degree of quality in our code. Spotbugs and Checkstyle has been used for this. The current release has zero checkstyle warnings, and every class is formatted according to Google Style. Spotbugs does show a warning about certain "classes needed for analysis were missing", but this has been determined to be a bug with Spotbugs documented [here](https://stackoverflow.com/questions/56279567/how-to-fix-the-following-classes-needed-for-analysis-were-missing).

Older code has also been revised, so that no duplicate code is present. This involved rewriting certain methods to also be used in tests, using inheritance and moving code out of the controllers.

## Comment on implicit storage
In our program we chose to use implicit storage, meaning that the user doesn't have to handle the storage process. In other words, when a user interacts with the program, such as saving their name, our program automatically determines the appropriate location to store this data. This makes it easier for users to manage their data, since they don't need to worry about the details surrounding the storage process. We believe this gives a more user-friendly experience.

## Images from the application

**Image 1:** Start screen with PacMan-color menu
![Start Screen](/pacMan-application/ui/src/main/resources/ui/README-Images/startScreenRelease3.png)

**Image 2:** Ghosts, cherry and yellow PacMan
![Ghosts and cherry](/pacMan-application/ui/src/main/resources/ui/README-Images/cherryRelease3.png)

**Image 3:** Lightmode with green PacMan
![Light mode](/pacMan-application/ui/src/main/resources/ui/README-Images/lightModeRelease3Image.png)

**Image 4:** Highscore list revealed when the game is over
![Highscore list](/pacMan-application/ui/src/main/resources/ui/README-Images/highscoreRelease3.png)
