# The core module

The core module holds the main logic for our application, and consists of two tiers:

1. **core** - The application tier

2. **persistence** - The data tier

## The logic behind our game

We have built our PacMan-application mainly based on collision logic between different FXML-elements. The maze is a photo, and on each "wall", we placed a Rectangle which is an FXML-element. The other elements in our game such as PacMan, the four Ghosts, the Pellets and the Cherry are represented by the FXML-element called ImageView.

With this as a foundation of our application, we could write logic for how these elements would interact with each other in order to resemble the classic features of the old school PacMan. Here are some examples:

- If PacMan (ImageView) collides with the walls (Rectangles), he is to stop

- If PacMan (ImageView) collides with the pellets or the cherry (ImageView) the pellet/cherry should disappear and the score increases

- If PacMan (ImageView) collides with one of the ghosts (ImageView), the game is over

For the ghosts, we placed special "collisionRectangles" around the maze. With some help from collision logic once again, this granted us the opportunity to hard code a path for each ghost. This is done in the pathing()-method in each of the four ghost classes, giving each of them a unique path in the maze. When a ghost collide with a collisionRectangle, it is sent off in certain direction. More on why we chose to implement it like this below under "Comment on Pathing".

## Description of classes in Core Module

**Core** contains the following classes:

- PacMan
- PacManUser
- Ghost
- Blinky
- Inky
- Pinky
- Clyde

**Persistence** contains the following classes:

- PacManPersistence

## PacMan

Controls the logic connected to user-input in form of arrowkeys, and handles the response to these events in form of speed and rotation on PacMan

### Methods

**NOTE:** Getters and setters exists for all attributes, but are excluded from this list

- reset() -> void: Resets PacMan's position, speed and rotation to the default start values

- changeDirection(String) -> void: Receives arrowkey inputs from PacManApp.java, and sets the static variables dx, dy and rotation to the corresponding values

- rotationAngle() -> double:  Returns the correct rotation-degree value corresponding to PacMan's current direction of travel

- validateDirection(String)->void: Validation method for possible directions for PacMan. If String is not valid, an IllegalArgumentException is thrown

## PacManUser

Handles the userdata connected to the player of a game, in specific username and score

### Methods

**NOTE:** Getters and setters exists for all attributes, but are excluded from this list

- reset() -> void: Resets the score to 0, useful when player restarts game
- validateUsername(String) -> boolean: Returns true if username is valid, else false. A username is invalid if it contains any spaces, is empty or if it is shorter than 3 characters
- toString() -> String: Gives PacManUser-objects a textual representation on the form "Username={username}, Score={score}".

## Ghost

Superclass of the ghosts, which contains logic for collision and which direction the ghosts move around in the maze. This is common for all 4 ghosts.

### Methods

**NOTE:** Getters and setters exists for all attributes, but are excluded from this list

- changeDirection(String) -> void: Changes the ghost's direction of travel, so it corresponds with the input String

- checkWallCollision(ImageView, Rectangle) -> boolean: Returns true if the ghost (ImageView) collides with the wall (Rectangle), else false.  Collision equals to the two objects intersecting.

## Inky

Inky is the blue ghost, and inherits logic for colliison and direction from the superclass Ghost. This class additionaly contains unique pathing for Inky.

### Unique methods

**NOTE:** Since Inky inherits from the Ghost class, it also has all of the methods from this class. However, these will not be listed here again.

- reset() -> void: Resets Inky to having the default-start position and direction, ready for a new game to begin

- pathing(Imageview, List<'Rectangle'>) -> sets the path for Inky through the maze. When colliding with the different rectangles in the List<'Rectangle'>, inky is sent in a certain direction.

## Blinky

Blinky is the red ghost, and inherits logic for colliison and direction from the superclass Ghost. This class additionaly contains unique pathing for BlInky.

### Unique methods

**NOTE:** Since Blinky inherits from the Ghost class, it also has all of the methods from this class. However, these will not be listed here again.

- reset() -> void: Resets Blinky to having the default-start position and direction, ready for a new game to begin

- pathing(Imageview, List<'Rectangle'>) -> sets the path for Blinky (Imageview) through the maze. When colliding with the different rectangles in the List<'Rectangle'>, Blinky is sent in a certain direction.

## Pinky

Pinky is the pink ghost, and inherits logic for colliison and direction from the superclass Ghost. This class additionaly contains unique pathing for Pinky.

### Unique methods

**NOTE:** Since Pinky inherits from the Ghost class, it also has all of the methods from this class. However, these will not be listed here again.

- reset() -> void: Resets Pinky to having the default-start position and direction, ready for a new game to begin
- pathing(Imageview, List<'Rectangle'>) -> sets the path for Pinky (Imageview) through the maze. When colliding with the different rectangles in the List<'Rectangle'>, Pinky is sent in a certain direction.

## Clyde

Clyde is the orange ghost, and inherits logic for colliison and direction from the superclass Ghost. This class additionaly contains unique pathing for Clyde.

### Unique methods

**NOTE:** Since Clyde inherits from the Ghost class, it also has all of the methods from this class. However, these will not be listed here again.

- reset() -> void: Resets Clyde to having the default-start position and direction, ready for a new game to begin

- pathing(Imageview, List<'Rectangle'>) -> sets the path for Clyde (Imageview) through the maze. When colliding with the different rectangles in the List<'Rectangle'>, Clyde is sent in a certain direction.

## Comment on Pathing

We are aware that the pathing()-methods for each of the ghosts are not of very "good" code standards. This is because the paths are hard coded: each turn the ghost takes is linked to an "else if"-statement. When we decided that we wanted to implement ghosts, we found out that this was the easiest and least time consuming way to make it happen. Since the functionality of the app is not what is mainly emphasized in this subject, we decided that we did not want to spend a lot of time figuring out a more clever solution to this. The code provided the desired functionality, and that was most important to us. However, this solution created some more problems when we were going to write test for the classes. This problem is addressed further down in this README-file under the Test Coverage section.

![Pathing method](/gr2372/docs/release3/jacoco3/pathing.png)

## Why did we choose inheritance for the ghosts?

Originally, the pathing methods were in PacManController. We only had one Ghost-class called Ghost and four different instances of it called Inky, Pinky, Blinky and Clyde were created in PacManController. However, we soon realized that it would be best if the long pathing()-methods were moved out of the PacManController in order to satisfy the convention of trying to reduce the amount of logic in the Controller. Additionally, we noticed that the four ghosts had the exact same state and behavior except for their unique pathing()-method. At this point, we got the idea of creating the four classes Inky, Pinky, Blinky and Clyde, which all inherited from the Ghost class.  In this way, all the ghosts got access to their common methods and fields from the super Ghost-class, while their unique pathing()-method were defined in each class individually. We are happy with this solution, and believe it contributed to better code quality for our project.

## PacManPersistence

Handles the persistence in the application, in other words storing of a player's username and score.

### Methods

- saveHighscore(String1, double, String2) -> void: Writes the username (String1) and score (double) to a .json file which path is given by String2

- fetchHighscore(String) -> List<'PacManUser'>: Reads from a .json file which path is given by the input parameter String, and transforms this into a list of PacManUser-objects

- deserializeHighScoreList(String) -> List<'PacManUser'>:  Uses GSON to deserialize JSON data given by the input parameter String into an an array of PacManUser-objects, which again is converted to a list for easier access

- deserializeIndividualHighScore(String) -> PacManUser: Uses GSON to deserialize JSON data given by the input parameter String into a single PacManUser-object which is returned

<br>

# Approach to testing of the core module

We have four different test classes:

- GhostTest
- PacManTest
- PacManUserTest
- PacManPersistenceTest

This is an illustration of our test coverage in the core module generated by jacoco. Below you can read about the choices we have made regarding testing of each class.  

![Core code coverage](/gr2372/docs/release3/jacoco3/core.png)

## GhostTest

A common test for both the super class Ghost and the subclasses Inky, Pinky, Blinky and Clyde. We have tested the reset functionality of all four ghosts and the common method that controls their direction. This leads to a decent test coverage in Ghost, but unfortunately not in the subclasses.

### Comment on low coverage for subclasses

The subclasses Inky, Pinky, Blinky and Clyde have gotten very low test coverage, due to their pathing()-methods not being tested. Even though the rest of the code is tested perfectly to 100%, the result is a low percentage because the pathing()-methods are very long and make up about 80-95% of the code.

This has been a difficult issue, because the pathing()-methods are being tested in the ui-tests and work as they should. We see this because the ghosts are moving just as they are supposed to in the PacManAppTest. However, since the code itself (the pathing()-methods) lies in the core module and the testing happens in the ui-module, the jacoco report does not register them as tested. The outcome of this issue is a low percentage not only in the Inky, Pinky, Blinky and Clyde classes, but also in the whole core module since they make up 4 out of 7 classes.

Even though this is unfortunate, we did not see an easy fix for this problem. It is difficult to test the pathing()-methods in core, because they take input parameters that are FXML-elements belonging in the ui-module and check if they intersect. This would be difficult to simulate, and although it may would have been feasible, it would be very time consuming. Due to little time on the third release and many other more critical issues, we chose not to prioritize this. After all, as mentioned, the methods are tested in the ui-test. The same argumentation goes for why we have not tested the checkWallCollision() method in the Ghost-class.

![Ghost coverage](/gr2372/docs/release3/jacoco3/ghost.png)

![Inky coverage](/gr2372/docs/release3/jacoco3/inky.png)

![Blinky coverage](/gr2372/docs/release3/jacoco3/blinky.png)

![Clyde coverage](/gr2372/docs/release3/jacoco3/clyde.png)

![Pinky coverage](/gr2372/docs/release3/jacoco3/pinky.png)

<br>

## PacManTest

Tests movement of PacMan and that the correct speed and rotation is set in all four directions.

As the jacoco report illustrates, we have very good test coverage in this class. The only method not tested is the constructor,  this is because all methods in the class are static. We therefore never actually create an instance of PacMan in our code, and furthermore we did not see testing this as a necessity.

![PacMan coverage](/gr2372/docs/release3/jacoco3/pacMan.png)

<br>

## PacManUserTest

Tests validation of username, the transformation of a PacManUser object into a String and the reset function. The jacoco report below illustrates our test coverage.

![PacManUser coverage](/gr2372/docs/release3/jacoco3/pacManUser.png)

<br>

## PacManPersistenceTest

In PacManPersistence, we have 4 methods. The two first hold logic for reading and writing user data to file when playing locally, and two last deserialize JSON data into (a list of) PacManUser-objects. We have written tests that asserts that this works as expected, and the test coverage is shown below. In fetchHighscore() and saveHighscore() it is not 100%, because catching of exceptions are not tested. We did not see this as necessary, because the relative file path is always given directly when the methods are used in the application.

![PacManPersistence coverage](/gr2372/docs/release3/jacoco3/pacManPersistence.png)
