# Simulation Lab Discussion
## Franklin WU (fyw4), Alex Chao (ac590), Joshua Boss (jsb91)


## Rock Paper Scissors

### High Level Design Ideas

Player class (abstract) - representative of a player in the game
- RealPlayer class vs Bot class
- different probabilities to choose different weapons 
- update its own score, etc

Weapon class (abstract) - extendable class containing properties of all weapons
  - knows all weapons and which weapons beat others; compares players to determine winner
- Rock class
- Paper class
- Scissors class
    
DataReader class - reads in weapons data in files
- method to store all possible weapons

Game class - runs the game and facilitates interaction between other classes
- determine which player wins in a round
- calls all other classes


### CRC Card Classes

This class's purpose or value is to manage something:

```java
 public abstract class Player {
     public void resetScore();
     public void incrementScore();
     public int getScore();
 }
```

This class's purpose or value is to be useful:

```java
 public abstract class Weapon {

     public Map<String, List<String>> weaponFunctions;

     public Weapon compare(Weapon opponent);
     

 }
```

### Use Cases

### Use Cases

 * A new game is started with five players, their scores are reset to 0.
 ```java
Game game = new Game();
game.addPlayers(5);
game.start();
//start calls resetScore on Player


 ```

 * A player chooses his RPS "weapon" with which he wants to play for this round.
 ```java
player.chooseWeapon();

 ```

 * Given three players' choices, one player wins the round, and their scores are updated.
 ```java
for (int i = 0; i < playerList.length(); i++)
  for (int j = i + 1; j < playerList.length(); j++)
    playerList[i].play(playerList[j]);
    

 ```

 * A new choice is added to an existing game and its relationship to all the other choices is updated.
 ```java
Reader setStateReader = new Reader();
setStateReader.read(pathway)

 ```

 * A new game is added to the system, with its own relationships for its all its "weapons".
 ```java
 Something thing = new Something();
 Value v = thing.getValue();
 v.update(13);
 ```


## Cell Society

### High Level Design Ideas

GameBoard
GamePiece
- Cell


### CRC Card Classes

This class's purpose or value is to manage something:
```java
public class Something {
    public int getTotal (Collection<Integer> data)
    public Value getValue ()
}
```

This class's purpose or value is to be useful:
```java
public class Value {
    public void update (int data)


}
```

### Use Cases

* Apply the rules to a cell: set the next state of a cell to dead by counting its number of neighbors using the Game of Life rules for a cell in the middle (i.e., with all of its neighbors)
```java
Something thing = new Something();
Value v = thing.getValue();
v.update(13);
```

* Move to the next generation: update all cells in a simulation from their current state to their next state
```java
Something thing = new Something();
Value v = thing.getValue();
v.update(13);
```

* Switch simulations: load a new simulation from a data file, replacing the current running simulation with the newly loaded one
```java
Something thing = new Something();
Value v = thing.getValue();
v.update(13);
```