# README for PacMan

This is the main documentation for a JavaFX version of the game PacMan, from the class IT1901 (1.semester 2023-2024).
It has been made collaboratively with Søren Boucher, Amalie Johansen-Vik, Jenny Müller and Herman Østenby.
It will contain a total of 3 releases (only 2 has currently been made).

# Documentation and User Scenario

[Documentation for release1](/gr2372/docs/release1/)

[Documentation for release2](/gr2372/docs/release2)

[User Scenario](/gr2372/docs/brukerhistorier/brukerhistorier.md)

# How to build and run the application
We are using the project management build tool, Maven.

To build the application, run  `mvn install` from the root-folder (**gr2372**-folder). In addition to building, this command will run all tests and code-quality-checks.

To run the application, run  `mvn javafx:run` from the **ui**-module (>gr2372>**ui**). This can be done by first running `cd gr2372/ui` followed by `mvn javafx:run`. 

**Eclipse Che**

   Click the link below to open the project in Eclipse Che. Please note you must have access to the repository in GitLab, as this is a private project.

   [Open in Eclipse Che](https://che.stud.ntnu.no/dashboard/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2372/gr2372?new)


# Current versions of software

Java version: 17.0.8

Maven version: 3.9.4

# Dependencies required to run application and tests

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
