# README for release 2 of PacMan



This is the README for the second release of our PacMan game.

# What have we done since the first release?

**1. Changed the file structure from javafx-template to modular file structure**
   
   Our application is now split into a three-tier architecture. We have the
   - presentation tier; the userinterface (**ui**-folder)
   - application tier; the logic (**core**-folder)
   - data tier; the storing of the application data (**json**)

   ```
├── .vscode  
|      ├── launch.json
|      └── settings.json                        
├── config
|      ├── checkstyles
|      |     └── eclipse-java-google-style.xml
|      └──spotbugs
|            └──exlude.xml
├── core
|      └── src
|      |      ├── main
|      |      |   ├── core
|      |      |   |     ├── PacMan.java
|      |      |   |     └── PacManUser.java
|      |      |   ├── Persistance
|      |      |   |         ├── PacManPersistence.java
|      |      |   └── module-info.java
|      |      └── test
|      |            ├──JSON
|      |             |    └── testScores.json
|      |            ├── PacManPersistenceTest.java
|      |            └── PacManTest.java
|      ├── README.md
|      └── pom.xml           
├── docs
|      ├── diagrams
|      |         ├── class.png
|      |         ├── class.puml
|      |         ├── package.png
|      |         ├── package.puml
|      |         ├── sequence.png
|      |         └── sequence.puml
|      ├── release1
|      |       ├── PacMan , code coverage - JaCoCoReport, release1.png
|      |       └── README.md
|      ├── release2
|      |        ├── README.md
|      |        └── PacMan , code coverage - JaCoCoReport, release2.png
|      └── userstories
|               ├── userstory1.md
|               ├── userstory2.md
|               └── userstory3.md
├── ui
|    ├── src
|    |     ├── main
|    |     |    ├── java
|    |     |    |      ├──ui
|    |     |    |      |   ├──PacManApp.java
|    |     |    |      |   └──PacManController.java
|    |     |    |      └── module-info.java
|    |     |    └── resources   
|    |     └──test
|    |         └──PacManAppTest.java
|    ├── pom.xml
|    └──README.       
├── pom.txt                                 : Maven file to correctly load structure and dependecies in the project
├── README.md                               : Description of this repository
├── .gitignore                              : Files and directories to be ignored by git
├── devfile.yaml                            : File that enables the project to be opened with Eclipse Che 
```

  

README-files for these tiers can be found in both core and ui-folder.

<br>
  
**2. Implemented some new features**
   - The board is filled with pellets
   - A soundtrack is added to enhance resembelence with the old-school PacMan
   - The score is visible in the top right corner whilst playing
   - Possible to switch between light mode and dark mode

Images that illustrates these photos can be found at the bottom of this README-file. 

<br>

**3. Improved the test coverage**
   
   We have written a more detailed test for the user-interface and PacManController ([PacManAppTest](/gr2372/ui/src/test/java/ui/PacManAppTest.java))
   We now have a test coverage on 38% in core, 82% in persistence  and 71% in ui.

   The two photos of the generated jacoco-reports can be found in docs>release2. 

   More detailed information on our approach to testing below. 

<br>
   
**4. Connected our data tier to JSON**

   Userdata is now stored in [Scores](/gr2372/ui/src/main/resources/ui/JSON/scores.json) as a .json file, instead of being stored in a .txt-file. This has a few practical consequences:

   - Instead of storing the userdata as strings in a .txt file, the scores are stored as objects
   - An object of this type (PacManUser), is an object that stores the username (String) and the score (int) of the player.
   - This has been changed since JSON allows text representation of java-objects. This makes the code easier to understand than with strings.
   - The conversion from java-objects to JSON and back has been done with GSON in the class [PacManPersistence.java](/gr2372/core/src/main/java/Persistence/PacManPersistence.java) to simplify the conversion-process. Version of the GSON-dependency is documented in the root-README.
   
<br>

**5. Created a package-diagram, seqential-diagram and class-diagram with PlantUML**
   
   The package-diagram demonstrates the relationship inbetween the different packages/modules, as well as their dependencies

   The sequential-diagram illustrates the sequence of messages between objects in an interaction

   The class-diagram gives a clear picture on how the different classes are connected. 

   The diagrams can be found in [diagrams](gr2372/docs/diagrams), both photos of them and their PlantUML script.


<br>

**6. Implemented Spotbugs and Checkstyle**
   
   Spotbugs and Checkstyle are tools for checking our code quality. While Spotbugs looks for bug patterns in the code, Checkstyle makes sure that our code adheres to a coding standard. Together with jacoco which was implemented in release 1, these tools guarantee a solid code quality check.

   A more thorough explination on these tools can be found [here](/gr2372/docs/codequality/README.md).

<br>

**7. Implemented Eclipse Che**
   
   Eclipse Che is a Cloud Developement Environtment (CDE), allowing us to access the project by a URL. This cloud-based approach enhances accessibility to and collaboration on the project by requiring only a web browser and an internet connection. Additionally, Eclipse Che offers time-saving benefits, as the entire development environment comes preconfigured, and it automates the Git setup process.

   Click the link below to open the PacMan-project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

   [Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)

<br>

# Our workflow and workhabits

We have written about our workflow and work habits  [here](/gr2372/docs/workflow/README.md).



# Our approach to testing

Testing of the code is an important part of developing an application. It is closely related to code quality and therefore contributes to increasing the quality of our application. 

In order to test our code, we started by reviewing what our application is supposed to do. This helped us gain a clearer view on which elements of the code that needed to be tested. In release 2, we switched to modular file structure as mentioned  earlier, meaning that our application is now built up by a three-tier architecture. It consists of the presentation tier (ui), the application tier (core/logic) and the data tier (persistence). It is important to test all these layers (modules), in order to ensure reliability, robustness and to make sure that all layers work as they should so they can successfully work together for the entire application. 

<br>

**Testing of the application tier**

In the application tier (core), we have the code for the main logic, for instance the PacMan-class that holds the username, the score, PacMan’s position and PacMan’s speed. We found it appropriate to test that PacMan actually will move in the direction given by the user through the arrow keys, because this is one of the main functionalities of the game. The logic for this lies in the method changeDirection(), and is tested in PacManTest. Here, we also test that PacMan start position is correct (x-coordinate = 330 and y-coordinate = 115). 

<br>

**Testing of the presentation tier**

In the presentation tier, we have the code for the UI and how users interact with our application. Here, we found it appropriate to test that the visible PacManGif actually moves on the screen in the correct direction when the user presses the arrow keys and that the score in the top corner increases when PacMan eats/collides with a pellet.  

<br>

**Testing of the data tier**

In the data tier (persistence), we have the code for storing data. We store a player’s username and score in the form of a PacManUser-obejct in a json-file in order to display this in a highscorelist. JSON is a text format that allows Java to store information in the form of objejects, and not just plain text. We therefore decided to store the data in an object-form to decrease the likelihood of string-concatenation errors. This data is read to and written from the json-file by using GSON in the PacManPersistence class. GSON is a tool developed by Google to easily transform a Java object into the correct format for JSON. We decided to use this instead of Jackson or some other library because of how much GSON simplifies the code.  This is all tested in PacManPersistenceTest. This testing is important to ensure that the data-transfer to and from the file is not corrupted in any way, and  works by checking that the data written to the file is the same as the data read from it, at a later point in time. We use a separate JSON-file to do this, testScores.json. This is to avoid the test-objects being mixed into the actual userdata.

<br>

# Tools for checking code quality and settings for them

Writing quality code is an essential part of any project. We chose the Checkstyle and SpotBugs tools to ensure quality, consistency and uniformity across our entire code base. Another reason to why we chose these tools are their easy integration with Maven.

**Checkstyle** is a tool that ensures our code adheres to a given standard. One of the major benefits of automatically formatted code is that the developer does not have to make style or format choices and can focus on the code itself, instead of spaces and tabs. We chose Google Java Style because of its popularity and ubiquity. Unfortunately, we were unable to setup VScode such that it would format in Google Java Format automatically and it would be inefficient to make the hundreds of formatting changes manually. We spoke with two TAs from the IT-Helpdesk who could not resolve this issue either. Because of this, our code is not formatted in the desired style. Our code follows the formatting criteria given by the RedHat extension, the only tool with which we were able to format. This is something we will address in the next release.

SpotBugs is a program that uses static analysis to find bugs in java code. There are many bugs and errors that aren’t picked up by the IDE before code is compiled. To mitigate these errors and ensure that our code is as consistent and bug free as possible, we used SpotBugs. We would like our program to be stable and reliable. SpotBugs helps us realize that aspiration. This tool found errors with static and instance-based overlap in various methods in the PacMan and controller class and found a recursive string concatenation which should have been a String Buffer. The arrow key inputs that relate to Pac Man’s movement and rotation must be static so the KeyListener class can access them when the player presses an arrow key. This caused all of Pac Man movement code to be static and these errors may not have been found without SpotBugs.

# Images from the game

The board is now filled with pellets, and you can see the player's score in the top right corner. 

![Pellets and score](src/main/resources/README-Images/../../../../../../ui/PacMan/ui/README-Images/pellets-and-score.png)

<br>
Ligth mode can be enabled/disabled from start screen by a toggle switch

![LightmodeToggle](src/main/resources/README-Images/../../../../../../ui/PacMan/ui/README-Images/light-mode-toggle.png)

<br>
Ligth mode visualised with a lighter maze and an orange PacMan

![LightmodeToggle](src/main/resources/README-Images/../../../../../../ui/PacMan/ui/README-Images/light-mode.png)