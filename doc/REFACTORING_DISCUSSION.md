## Lab Discussion
### Team 1
### Josh Boss, Alex Chao, Franklin Wu


### Issues in Current Code

#### All of our classes
 * Magic numbers
 
 According to the design coach tool provded to us, we have 22 instances of magic numbers where they shouldn't
 exist. We can simply add constants to the classes to replace them, or refactor our code to not need them in the first place. 

 * Unnecessary imports
 
 We have many imports for classes that are obselete as we don't use them anymore. We can simply remove them 
 from our classes and get rid of this code smell. 

#### burningNExtGen method inside of the SpreadingFire.java model class
 * Design issues

This method is far too long and encompasses multiple things that could be seperated into different methods.
As you can see, there are multiple condidtionals nested inside of for loops, meaning that we could 
extract the inner conditionals into a helper method so that each method is accomplishing only one task
and it is also more readable.  
```java
public boolean burningNextGen(int currentRow, int currentColumn) {
  
    if (isEmpty(currentRow, currentColumn)) {
      return false;
    }
    for (int i = currentRow - 1; i <= currentRow + 1; i++) {
      for (int j = currentColumn - 1; j <= currentColumn + 1; j++) {
        if (getGameBoard().inBounds(i, j) &&
            isDirectNeighbor(i, j, currentRow, currentColumn) &&
            isBurning(i, j)) {
          Random rand = new Random();
          double probability = rand.nextDouble();
          return probability > probCatch;
        }
      }
    }
  
    return false;
``` 

#### Display.java

 * Incorrect usage of private field
 
 We are using a private field called speedAdjuster, which is an instance of the Slider class. We should 
 instead of using this just pass it to relevant methods. There is no reason to create unnecessary fields
 when they are not needed. 


### Refactoring Plan

 * What are the code's biggest issues?
 
 In general our code is not super closed, meaning that in order to change things we have to go back into
 parent classes and fix them. In particular our button settup is pretty bad, and we have to edit about 7 different
 lines of code to input a new button. We also are not using reflection as well as we could be or enums. There 
 are still some bugs which we need to fix as well. OVerall we have a decent amount of work to do. 

 * Which issues are easy to fix and which are hard?

The magic numbers and unnecesary import stuff will be easy to fix. Restructuring entire classes and what not
will be much harder. Especially adding more abstraction and focusing on data driven design.


 * What are good ways to implement the changes "in place"?

We make sure all of the tests run, then change the code one item at a time, and continually test, to make sure
we can slowly improve our design without breaking everything. Overall it is a good way to do implement consistent changes. 

### Refactoring Work

 * Issue chosen: Fix and Alternatives

Button layout. We need to fix how we build buttons. We are planning on using data driven design in which the 
resource property files will contain information about which buttons need to be made for which screens, 
and then the display class will parse that and make the appropriate buttons with their appropriate set on action
methods. Alternatives to this are to have button subclasses that each hve their own set on action method. 
We also could use lambda functions. 


 * Issue chosen: Fix and Alternatives
 
 We also need to redo how we are generating text for our screens. We are not currently using .properties files
 right now to store our text and instead are hardcoding everything.