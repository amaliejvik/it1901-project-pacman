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

  
**2. Implemented some new features**
   - The board is filled with pellets
   - A soundtrack is added to enhance resembelence with the old-school PacMan
   - The score is visible in the top right corner whilst playing

<br>

**3. Improved the test coverage**
   
   We have written a more detailed test for the user-interface and PacManController ([PacManAppTest](/gr2372/ui/src/test/java/ui/PacManAppTest.java))
   We now have a test coverage above 60%.

<br>
   
**4. Connected our data tier to JSON**

   Userdata is now stored in [Scores](/gr2372/ui/src/main/resources/ui/JSON/scores.json) as a .json file, instead of being stored in a .txt-file. This has a few practical consequences:

   - Instead of storing the userdata as strings in a .txt file, the scores are stored as objects
   - An object of this type (PacManUser), is an object that stores the username (String) and the score (int) of the player.
   - This has been changed since JSON allows text representation of java-objects. This makes the code easier to understand than with strings.
   - The conversion from java-objects to JSON and back has been done with GSON in the class [PacManPersistence.java](/gr2372/core/src/main/java/Persistence/PacManPersistence.java) to simplify the conversion-process. Version of the GSON-dependency is documented in the root-README.
   
<br>

**5. Created a seqential-diagram and class-diagram with PlantUML**
   
   The sequential-diagram illustrates the sequence of messages between objects in an interaction

   The class-diagram gives a clear picture on how the different classes are connected. 

<br>

**6. Implemented Spotbugs and Checkstyle**
   
   Spotbugs and Checkstyle are tools for checking our code quality. While Spotbugs looks for bug patterns in the code, Checkstyle makes sure that our code adheres to a coding standard. Together with jacoco which was implemented in release 1, these tools guarantees a solid code quality check.

<br>

**7. Eclipse Che**

   Click the link below to open the project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

   [Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)


# Images from the game

The board is now filled with pellets, and you can see the player's score in the top right corner. 

![Pellets and score](src/main/resources/README-Images/../../../../../../ui/PacMan/ui/README-Images/pellets-and-score.png)



