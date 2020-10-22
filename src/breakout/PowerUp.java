/**
 * @author Liam Clark, Josh Boss
 * @Class PowerUp
 * @Purpose To abstractly represent a powerup that can introduces various player-friendly changes to the game, depending on the subclass constructor that is called
 * @Assumptions Two powerups do not spawn at the same time, PowerUps can be one of three types (OneUp, PlatformGrower, BallGrower), and each type has an equal, random probability of spawning
 * @Dependencies breakout package
 * @Example create a new powerup with PowerUp myPowerUp = new PowerUp(), then change information about the player using a method like
 * myPowerUp.createPowerUpAtPoint()
 */
package breakout;

import breakout.PowerUps.BallGrower;
import breakout.PowerUps.OneUp;
import breakout.PowerUps.PlatformGrower;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import java.util.concurrent.ThreadLocalRandom;

public abstract class PowerUp {
    private Circle thisPowerUp;
    private int speed = 40;
    private String type;
    private final int POWER_UP_SIZE = 10;
    private static final PowerUp[] listOfPossiblePowerUps = new PowerUp[]{new PlatformGrower(), new BallGrower(), new OneUp()};

    public static PowerUp chooseRandomPowerUP(){
        /**
         * This chooses a random powerup from the list of possible powerups declared as a constant above. This is static there is
         * no unique powerup object itself, as it is an abstract class. This method chooses one of the types of
         * powerups, and then where it is called a new instance of that specific powerup
         * will be generated.
         */
        int randomInt = ThreadLocalRandom.current().nextInt(0, listOfPossiblePowerUps.length);
        PowerUp chosenPowerUp = listOfPossiblePowerUps[randomInt];
        return chosenPowerUp;
    }

    public Circle getThisPowerUp() {
        return thisPowerUp;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public int getSize(){
        return POWER_UP_SIZE;
    }
    public String getType(){
        return type;
    }
    public void setType(String newType){
        type = newType;
    }
    public void setThisPowerUp(Circle newPowerUp){
        thisPowerUp = newPowerUp;
    }

    public abstract void createPowerUpAtPoint(int x, int y);

    public abstract void doThePowerUp(Player myPlayer, Ball myBall, Platform myPlatform);
    public double getCenterX(){
        return thisPowerUp.getCenterX();
    }
    public double getCenterY(){
        return thisPowerUp.getCenterY();
    }
}
