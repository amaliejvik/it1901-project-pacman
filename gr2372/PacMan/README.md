# README for release 1 of PacMan

(Please read the README in the root folder before this.)

This is the README for the first release of our PacMan game.

The first release of PacMan contains basic gameplay mechanics. It includes: 
- A PacMan that is controllable with the corresponding arrow-keys
- A map with functional walls
- A set of "pellets", that PacMan is supposed to collect
- A scoring system to keep track of how many pellets PacMan has collected
- A system for storing scores, reading and displaying highscores
- Functionality for replay
- A user story to highlight the possibilities and limitations of the game
- Documentation of the current state of the game

## Repo structure
```
├── README.md                               : Description of this repository
├── pom.txt                                 : Maven file to correctly load structure and dependecies in the project
│── .gitignore                              : Files and directories to be ignored by git
└─ src                                      : Project code, resource files and tests
    ├─ main                                 : Project code and resource files
    │   ├── resources                       : Folder for various resources such as images, gifs, scores and fxml
    │   └── java                            : Folder for source code and modules-info
    │       ├── app                         : Folder for source code
    |       |   ├── PacMan.java             : Collisions, position, speed and rotation of PacMan
    |       |   ├── PacManApp.java          : Launching the app, user input
    |       |   ├── PacManController.java   : Manipulating graphical interfaces
    |       |   └── PacManReadAndWrite.java : Reading previous scores and writing new ones
    |       └── modules-info.java           : Requirements
    └─ test                                 : Project code and resource files
        ├── AppTest.java                    : 
        └── PacManReadAndWriteTest.java     : Testing reading and writing
```

# Images from the game

This is the start-screen for the game, where the player can register their score with a username:

![Startscreen](src/main/resources/README-Images/startScreen.png)

This is the main game-screen:

![Gamescreen](src/main/resources/README-Images/gameScreen.png)

This is the gameover-screen, where previous results are displayed:

![GameoverScreen](src/main/resources/README-Images/gameoverScreen.png)