/**
 * @author Liam Clark, Josh Boss
 * @Class PlatformGrower
 * @Purpose To represent a type of powerup that makes the platform width grow
 * @Dependencies breakout.PowerUps
 * @Assumptions PlatformGrower is never in the root at the same time as another powerup
 * @Example create a new BallGrower with PowerUp myPlatformGrower = new PlatformGrower(), then change information about the player using a method like
 * myPlatformGrower.createPowerUpAtPoint()
 */
package breakout.PowerUps;

import breakout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PlatformGrower extends PowerUp {
    private final Paint PLATFORM_GROWER_COLOR = Color.GRAY;
    private static final String PLATFORM_GROWER_TEXT = "PG";
    private Circle thisPlatformGrower;
    public PlatformGrower(){
        /**
         * Creates the instance of platform grower object. Sets speed and the specific Type.
         */
        setType(PLATFORM_GROWER_TEXT);
        setSpeed(this.getSpeed());
    }

    @Override
    public void createPowerUpAtPoint(int x, int y) {
        /**
         * This public method creates a power up at the point specified by the input parameters. More specifically,
         * it creates a circle which will move down the screen and represent the platformGrower power up.
         */
        PlatformGrower pg = this;
        thisPlatformGrower = new Circle(x,y,this.getSize(), PLATFORM_GROWER_COLOR);
        setThisPowerUp(thisPlatformGrower);
        thisPlatformGrower.setId(PLATFORM_GROWER_TEXT);
        pg.setThisPowerUp(thisPlatformGrower);
    }

    @Override
    public void doThePowerUp(Player myPlayer, Ball myBall, Platform myPlatform) {
        myPlatform.grow();
    }
    /**
     * This method executes the platformGrower powerup - it takes in myPlayer, myBall, and myPlatform, as it is an implementation
     * of an abstract method that needs all of those fields. This method makes the platform grow.
     */
}