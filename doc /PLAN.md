# Game Plan
## Josh Boss, Liam Clark


### Breakout Variation Ideas

### Interesting Existing Game Variations

* 1996 – DX-Ball Series
 
In this break variation, they included different shapes for the structures that the walls could create.
In addition, they added changes to the possible ball speeds and ball types. At some points in the game 
the ball was bigger or smaller. At other points they had a fireball that would take out nearby balls.

 * Through a specific path
  
In this variation idea we had, the goal of the game was to get through a small window on the 
perimeter of the board that would change based on levels. The goal wouldn't be to destroy all 
the blocks, but instead figure out how to get your ball to escape.


#### Block Ideas

 * Block 1 - Strong block - this block takes twice as much damage as a normal block to destroy

 * Block 2 - Blocks that can duplicate, and generate more blocks

 * Block 3 - Blocks that can become stronger


#### Power Up Ideas

 * Power Up 1   -    Increase the size of the ball

 * Power Up 2   - Fireball power up that destroys surrounding blocks 

 * Power Up 3  -   More powerful block
 
 * Power Up 4 -    More than one ball


#### Cheat Key Ideas

 * Press the number one key and it takes you to the begining of number one
    
 * Press the number 2 key and it takes you to the begining of number two... and so on
    
 * Press the h key to increase difficulty and the l key to lower the difficulty (speed of the balls)
    
 * Press the s key to change the size of the ball
 
 * Press the p key to pause
    
    
   



#### breakout.Level Descriptions

 * breakout.Level 1
   * Block Configuration: This configuration is a zigzag starting 
   from the top left of the screen and moving diagonally right until it hits the left 
   wall and then comes back the other way. It will look like this.
   
   *** 
      ***
         ***
            *** 
                ***
                   ***
                ***
            ***
         ***
      ***
   ***         
      ***
         ***
            ***
               *** 
                   ****
   * Variation features: This level will likely be very similar to a traditional brickbreaker game,
   except there will be different strengths of blocks corresponding to different colors that 
   deteriorate over time as the ball hits them more. 

 * breakout.Level 2
   * Block Configuration: The configuration of this level is more stacked
   So there are significantly more blocks to break, and their strength on average is larger.  
   It will look something like this...
   
          ******
        **********
       ************
       ************
       ************
       ************
       ************
        *        *
        *        * 
        *        *
       **        **

   * Variation features: In this level, there will be powerups that you can attain
   such as change in ball size.  

 * breakout.Level 3
   * Block Configuration: This block configuration will be different from level two in 
   that there will be less time for the player to react because there will be many strong blocks lower down in the window. It might look something like this.
   
     
     * *   * 
    2 2 2 2 2 2
    2 3 2 2 3 2
    2 3 3 3 3 2
    1 3 2 2 3 1
    2 3 1 1 2 1
    2 2 1 1 2 2
      2 3 3 2 
      2 3 3 2 
      2 2 2 2 
      2 2 2 2 
        2 2 
        2 2  
         
    5 1 5 1 5 1
    1 5 1 5 1 5
    5 1 5 1 5 1
   
     
 
   * Variation features: This level will include more powerups that weren't used in the 
   second level, such as changes in speed, the addition of more difficult blocks that duplicate, 
   and different types of balls. 


### Possible Classes

 * Class 1: Game
   * Purpose: Purpose of the game class is to run the program. It generates the game board, creates the
   ball, paddle and blocks and is overall the engine for the program.

   * Method: A method from this class is checkStageBoundary
   which determines whether or not the ball is inside of the stage 
   or not and changes the balls direction accordingly.

 * Class 2: Block
   * Purpose: This class is created in order to create block objects, 
   which will be dispersed throughout the game board. The reason for having it
   in its own class is so that we can a bunch of individual block objects,
   each with their own properties, such as hits left, type, ect.  

   * Method: updateBlock method will update a block if it gets hit by a ball. For instance, 
   if a ball hits a block object, update method will be called and it will in turn decrease its strength
   and change it's score accordingly. 


 * Class 3: BlockMaker
   * Purpose: The purpose of this class is to create the block layout
   for the game board. It reads in the text file that determines that layout
   and makes a block layout with the coinciding format.  

   * Method: A method from this class is createBlocks, which loops through the file 
   and creates block objects to disperse around the board. 

 * Class 4: breakout.Level class
   * Purpose: This class would exist in order to separate specifications between different levels.
   For instance, it would have different blockMaker objects with different gameboard layouts, and possibly even 
   different ways of winning. 

   * Method: A method in the breakout.Level class might be a changePowerUp method, which 
   would apply a powerup object at a certain moment given a certain input. 

 * Class 5:  ball class
   * Purpose: The purpose of a specific ball class would be to be have certain
   properties be associated with the balls of different levels. For instance, ball size, 
   ball speed, ball damage, etc. 

   * Method: A method in the power-up class might be a fireBall method 
   which would cause the ball to inflict damage on surrounding blocks.   