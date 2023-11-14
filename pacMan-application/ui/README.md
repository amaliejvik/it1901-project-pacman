# The UI-module

The UI module is responsible of the user interaction and the user interface for our application (the frontend). It is built with JavaFX and Scenebuilder.

## Description of classes in UI module

**UI** contains the following classes:

### LocalUI-classes

- PacManApp
- PacManController

### RemoteUI-classes

- RemotePacManApp
- RemotePacManController
- RemotePacManModelAccess

### Logic-classes

- Collisions

### Comment on the Local- and Remote-UI-classes

The RemoteUI-classes were added in the third release after we implemented the Rest API. They are nearly identical to the  LocalUI-classes.

After the implementation of Rest API, the application now supports being run both locally and remotely. The difference lies in where the userdata is saved; locally in the scores.json-file or remotely via a server using the API in the remoteScores.json file. This can be set in the UI-pom.xml file found in the ui-folder, in line 97 where which app used is specified.

![Illustration](pacMan-application/docs/release3/jacoco3/uiPom.png)

**In short:**

- the application uses the RemoteUI-classes when the "RemotePacManApp" is specified in the pom.xml file

- the application uses the LocalUI-classes when the "PacManApp" is specified in in the pom.xml file

## PacManApp

This class is responsible for starting the application, and extends Application.

### Methods

- start(Stage) -> void: Launches the JavaFX application by using the PacMan.fxml file which is linked to PacManController. Also registers user input in form of arrow keys pressed

- main(String[]) -> void: Main start method for application

## PacManController

This class controls the main game-loop and holds the methods controlling the graphical elements in the game, which the user interacts with. The score is saved locally when the game is over.

### Important methods

- createAndConfigureTimeline() -> void: Creates the main game-loop (timeline) for the application which constantly updates PacMan's position and rotation, checks for collisions, updates score and triggers gameover()

- startTimeline() -> void: Starts the main game-loop (timeline)

- initialize() -> void:  Initializes the music-player, organises the FXML-elements into lists, creates instances of the ghosts and sets them to their start-default values and initializes the PacMan. In other words, makes sure everything is ready for the game to start, and is executed automatically when the application  launches

- updateGui() -> void: Disables the startbutton if the username is invalid

- handleStartButton() -> void: Tries to hide the  FXML-elements connected to the startscreen, to update the MapGrid so it corresponds to the user's choice and to start the game and music. Exceptions are caught. Is executed when user clicks on the #startButton

- gameOver() -> void: Stops the main game-loop (timeline) and the music, saves userdata to file and displays a game-over screen with highscores. Executed when PacMan collides with a ghost or has eaten all pellets

- handleRestartGameButton() -> void: Resets PacMan1s and the ghosts' position, speed and direction to default start-values . In addition,  score is reset to 0 and the startscreen is displayed. Executed when user clicks on #restartButton

- chooseYellowPacMan() -> void: Sets position of checkmark to correspond with the yellow PacMan being chosen, and the Yellow PacManGif is assigned to the ImageView representing PacMan. Executed when user clicks on the Yellow PacMan in the choose-color-of-PacMan-menu on the start screen

- chooseGreenPacMan() -> void: Sets position of checkmark to correspond with the green PacMan being chosen, and the Green PacManGif is assigned to the  ImageView representing PacMan. Executed when user clicks on the Yellow PacMan in the choose-color-of-PacMan-menu on the start screen

- choosePinkPacMan() -> void: Sets position of checkmark to correspond with the pink PacMan being chosen, and the Pink PacManGif is assigned to the ImageView representing PacMan. Executed when user clicks on the Pink PacMan in the choose-color-of-PacMan-menu on the start screen

- chooseOrangePacMan() -> void: Sets position of checkmark to correspond with the orange PacMan being chosen, and the Orange PacManGif is assigned to the ImageView representing PacMan. Executed when user clicks on the Orange PacMan in the choose-color-of-PacMan-menu on the start screen

- setComponentsVisible(boolean, Node...) -> void: Sets the visibility of all the components given in the input parameter Node... to the input parameter boolean

## RemotePacManApp

Almost identical to PacManApp, this class also launches the JavaFX application, but uses the RemotePacMan.fxml file. This fxml file is linked to the RemotePacManController, resulting in storing of user data happens through a remote server.

All other methods are the same, and we will therefore not explain them again.

## RemotePacManController

Almost identical to PacManController, this class also controls the main game-loop and  holds the methods controlling the graphical elements in the game. The only difference is that the userdata is stored remotely on a server, using a RestAPI.

All other methods are the same , and we will therefore not explain them again.

## RemotePacManModelAccess

This class contains logic for making remote requests to the PacMan-model API, so that userdata can be fetched or saved from/to the server.

### Methods

- getHighScores() -> List<'PacManUser'> : Sends a HTTP GET request to the remote endpoint in order to retrieve the highscores from the server. The response is given as JSON data, so it is deserialized into a PacManUser list, which then is returned. Else, a RuntimeException is thrown

- putHighScore(String, double) -> void: Tries to save the input parameters String (username) and double (score) remotely. The PacManUser is serialized into JSON using GSON, before a HTTP PUT request is sent to the remote endpoint to add the user data. Else, a RuntimeException is thrown

- deserializeHighScoreList(String) -> List<'PacManUser'> : Deserializes the input parameter String from JSON to a list of PacManUser-objects using GSON, and returns this list

## Collisions

Handles the general collision-logic, which the application is built upon.

### Methods

- pacManWallCollision(Imageview, List<'Rectangle'>) -> boolean: Returns true if PacMan (ImageView) collides with a wall (Rectangle) in the List<'Rectangle'>, else false. If true, PacMan's movement stops and PacMan's position is bounced back 3px from the wall to ensure PacMan does not get stuck in the wall

- pacManWallCollision(Imageview, Rectangle) -> booelan: Returns true if PacMan (ImageView) collides with the specific wall (Rectangle), false else

- pacManPelletCollision(ImageView, List<'ImageView'>) -> boolean: Returns true if PacMan (ImageView) collides with a pellet (ImageView) in the List<'ImageView'>, else false

- pacManGhostCollision(ImageView, List<'ImageView'>) -> boolean: Returns true if PacMan (ImageView) collides with a ghost (ImageView) in the List<'ImageView'>, else false

- pacManCherryCollision(ImageView1, ImageView2) -> boolean: Returns true if PacMan (ImageView1) collides with a Cherry (ImageView2) , else false.

<br>

# Approach to testing of the UI module

We have two different test classes for the UI module:

- PacManAppTest
- RemotePacManAppTest

PacManAppTest tests the application when it is ran locally, while RemotePacManAppTest tests the application when ran remotely. If you look away from this, the two classes are identical with the same tests. We saw this as a reasonable solution, because the Controllers that are tested (PacManController and RemotePacManController) are also identical except from the local/remote storing of user data.

This is an illustration of our test coverage in the UI module generated by jacoco. Below you can read about the choices we have made regarding testing of each class.  

![UI coverage](/pacMan-application/docs/release3/jacoco3/ui.png)

## PacManAppTest

Tests the PacManController by simulating a game. Tests different scenarios we think of as important in the game such as; entering a username, choosing PacManColor, choosing light mode, pressing startButton, moving PacMan in all directions, ghostMovement, eating pellets and the cherry, being hit by a ghost and pressing the restartButton. All this functionality is tested in two JUNIT tests.

### Comment on incremental testing

Optimally we would prefer to use incremental testing, meaning splitting the tests up in even smaller units, having only a small part of the functionality tested in each test. We made use of this technique when testing the core-module, because it makes it a lot easier to identify and isolate issues when they arise.

However, when we attempted to split the PacManAppTest into smaller JUNIT tests, we experienced that running the tests got a lot more unstable for no good reason. Without changing any code, sometimes they ran, sometimes they did not. We believe this perhaps has something to do with Maven. Because of this, we only created two JUNIT tests.

### Comment on test coverage
As illustrated below in the first photo, our tests grant a good test coverage of the PacManController.

The two first methods are not tested that well, because of a choice we made for our gameOver()-method. In order to have the user data from the tests being saved in a different file than the ones from when you actually run the application, we created an if-else statement along with a boolean in PacManController. The boolean states if it is a test or not. In PacManAppTest it is set to true whilst when you run the application normally, it is set to false. Depending on this boolean, the scores are saved in either scores.json or testScores.json in the gameOver()-method.

In the test, the code snippet where saving happens to scores.json will never happen. Hence, the code coverage is a bit low. The second photo below highlights the part of the code in gameOver() that is not covered by the test in red, because this code snippet only happens when running the application normally "not as a test" as the if-statement suggests.

![PacManController](/pacMan-application/docs/release3/jacoco3/pacManController.png)

![gameOver](/pacMan-application/docs/release3/jacoco3/gameOver.png)

### RemotePacManAppTest

As mentioned, this test is practically identical to PacManAppTest and it tests the exact same events. RemotePacManAppTest tests the RemotePacManController by simulating a game.

Test coverage is illustrated below.

![RemotePacManController](/pacMan-application/docs/release3/jacoco3/remotePacManController.png)