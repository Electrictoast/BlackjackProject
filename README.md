# Blackjack Project
#### Skill Distillery homework - week 4

### Overview
This program simulates a casino style Blackjack game where the user plays against an automated dealer.
First the user is asked to give their name to a dealer chosen from a list of names. Then the initial hand is dealt and the player is presented a menu with three options. "1. check cards" will display both the users hand of cards and the dealers hand with one card hidden. "2. hit" will give the user an additional card. "3. stay" will stop the users turn and pass play to the dealers automated logic. After the dealers turn ends win conditions are checked and the user is given the option to play again.

### Technologies used
* Java
* git
* OOD
* Enumerators

### Lessons learned/Plans for the future
This project reinforced my understanding of Object Oriented design, the CardtoAscii class was much more challenging than I originally thought it would be but I was very satisfied with the outcome.
If I revisit this project I would like to add a multiplayer feature by adding a number of players to an ArrayList and adding a for loop in the initial deal and player turn methods. I would have to think more about how to implement win conditions with multiple checks for bust scenarios and score comparisons. I would also add a money tracking system with a betting mechanic and an overall loss condition and possibly a high score text file that would persist between games.