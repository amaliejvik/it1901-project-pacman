# The core module 

The core module consists of two tiers; the application tier and the data tier for [PacMan](gr2372/README.md).


## The application tier

In the application tier, you can find the main logic for the application. It is responsible for processing data, implementing the core functionality of the application, and performing tasks such as data validation, calculations, and decision-making.

Since we are making PacMan, our application tier consists of a class to represent PacMan and how he moves around the board as well as a class that handle saving of data such as username and score. It can be found in [core](gr2372/core/src/main/java/core).


## The data tier

The data tier is responsible for storing and managing data as well as the logic connected to this. 
In our application, this data is mainly the username and the score of a player.
We have implemented JSON with GSON in order to write username and score to the highscore list. 
This code can be found in [persistence](gr2372/core/src/main/java/persistence).
