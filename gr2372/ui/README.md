# The ui-module

The ui-module consists of the presentation tier.

## Presentation tier
The presentation tier is responsible of the user interaction, and the user interface. 

The user interface of our PacMan application consists of a maze-gameboard, a yellow PacMan and white pellets spread around the board. After running the application, you will see a start-window where you can enter your chosen username before clicking the start-button. 

Once this button is clicked, the whole board is revealed to you. When you press the arrow keys, the user interface will follow your movement by moving PacMan. As you eat pellets, they will disappear, and you can see your score being updated in the top corner. 

When you finish the game, a gameover-window pops up, and you can see a highscore list with your name and score on it. You also have a restart-button, which will lead you back to the start-window. 

Our user interface is created in JavaFX and FXML, and the code is to be found in [ui](gr2372/ui/src/main/java/ui).

