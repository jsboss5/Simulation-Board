# Simulation Design Final
### Names Liam Clark & Josh Boss

## Team Roles and Responsibilities

 * Team Member #1 Liam Clark - co-Chief Programmer

 * Team Member #2 Josh Boss - co-Chief Programmer



## Design goals

#### What Features are Easy to Add

Our main design goal was to use abstraction to make our code follow the open closed principle.
Easy to add features are new levels, new types powerups and new types of balls/platforms.


## High-level Design

#### Core Classes

Ball.java - represents a ball object, the moving object that the player controls with the paddle to break the blocks
Block.java - represents a representation of Block, tried to make Block abstract so it was easy to extend and make different Block derivatives 
BlockMaker.java - the class that reads the level files and populates the BlockList
Game.java - the class that integrates all of our classes to create the playable game
Key.java - the class that represents a key that the ball must acquire in order to unlock a locked block
Level.java - the class that holds and stores objects specific to a given level
Platform.java - the class the represents the player controlled platform
Player.java - the class that contains instance data about a player, such as the players score and lives remaining
PowerUp.java - an abstract class that represents the different types of powerups that can fall randomly from blocks
Screen.java - the class that handles splash screens in between levels


## Assumptions that Affect the Design

We assume that the player knows the controls of the game before they play, 
and also that the player doesn't know of the existence of cheat keys, and also that
objects in our game can be represented by shapes and don't need to implement sprites

#### Features Affected by Assumptions

All classes that get added to root are at their core just rectangles and circles with features specific to their class.
Thus, the display is cartoonish and limited to what is capable of being drawn solely with rectangles and circles.


## New Features HowTo

Can add new features by creating a class of the feature you want to add, by creating an appropriate shape to represent 
the object, instance variables that provide data about the new feature and methods that allow to new feature to perform 
its desired tasks. After this, you can then adding the object shape to the level scene root. 

#### Easy to Add Features

New PowerUp- create a new powerUp (BallSlower) by creating a BallSlower.java class that extends PowerUp abstract class.
Then, override the doThePowerUp method that calls a method on the ball class that sets the ball speed to less than what the ball
speed already was. Fix the chooseRandom powerUp method so that the new powerUp has a chance at spawning

#### Other Features not yet Done
Moving blocks- need to add a move() method to the block class, or finish refactoring the Block.java class so that it can be extended,
and create a MovingBlock.java class that has a move() method. I'd have to add a checkBlockBoundaryCollision method in Game.java that
negates a block's speed if it collides with the boundary of the screen.

Make the ball path more controllable: I tried to do this in the project, by accelerated the balls speed if the platform is moving to the right
and decelerating the ball if the platform is moving to the left. This makes the ball path vary slightly, but not as much as I would have liked.
If I had more time, I would pin point the point of collission between the block and paddle and then corrrelate the new xVelocity based upon how centered the
contact was between the ball and the paddle; if the ball hits the left part of the paddle it should bounce off to the left, and it should bounce off to the right if 
the collision occurs on the right side of the paddle.


