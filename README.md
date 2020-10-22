game
====

This project implements the game of Breakout.

Name: Joshua Boss, Liam Clark

### Timeline

Start Date: 09/05

Finish Date: 09/29

Hours Spent: 70

### Resources Used
* Stack Overflow 
* Lectures
* Readings

### Running the Program
Game Class - Simply run the start method of the game class to play the game!

#### Main class: 
Game.java

#### Data files needed: 
No Data files needed - if there is no file for high score, the program creates one

#### Key/Mouse inputs:
Cheat keys:

LEFT: move paddle left 

RIGHT: move paddle right

SPACE: pause game

R: reset Paddle And Ball

L: add life to player

P: generate a powerUp

D: destroy first block (top left most block)

1: jump to level 1

2: jump to level 2

3: jump to level 3

S: add 10 points to the score

W: grow the platform


Known Bugs:

1. If you press powerup key (P) and there is already a power up droppign than it stops 
the one that is dropping in the middle of the screen

Extra credit: We added cut screens for before the game starts, in between each of the levels, and after 
the user wins. We also added buttons there too to allow for a more interactive experience. 


### Notes/Assumptions

##### Special Blocks:
1. There is a "nuke" block, colored black, which destroys all the blocks in a level if you hit it.
2. There is a "locked block" shaded in light gray. This block will not be destroyed unless the "key" is collected. The key is the 
little yellow dot on the screen. 

##### Assumptions

1. There are really no assumptions that we make, other than there are 3 levels - but we set that. 
2. Test levels are 10, 11.. so on. Where as real levels are 1,2,3.... so on.

### Impressions
Overall, we really enjoyed this project. We learned a lot about abstraction, open closed principle, OOD, and structuring a large
program with tons of classes and methods. This was the best piece of code I've written to date. 
