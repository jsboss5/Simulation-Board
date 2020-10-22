/**
 * @author Liam Clark, Josh Boss
 * @Class OneUp
 * @Purpose To represent a type of powerup that grants the player an additional life
 * @Dependencies breakout.PowerUps
 * @Assumptions OneUp is never in the root at the same time as another powerup
 * @Example create a new OneUp with PowerUp myOneUp = new OneUp(), then change information about the player using a method like
 * myOneUp.createPowerUpAtPoint()
 */
package breakout.PowerUps;

import breakout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class OneUp extends PowerUp {
    private final Paint ONE_UP_COLOR = Color.SPRINGGREEN;
    private static final String ONE_UP_TEXT = "1 UP";
    private Circle thisOneUp;
    public OneUp(){
        /**
         * Creates the instance of oneUP  object. Sets speed and the specific Type.
         */
        setType(ONE_UP_TEXT);
        setSpeed(this.getSpeed());
        //setPowerUpColor(ONE_UP_COLOR);
    }

    public void createPowerUpAtPoint(int x, int y){
        /**
         * This public function creates a power up at the point specified by the input parameters. More specifically,
         * it creates a circle which will move down the screen and represent the level up power up.
         */
        OneUp ou = this;
        thisOneUp = new Circle(x,y,this.getSize(), ONE_UP_COLOR);
        setThisPowerUp(thisOneUp);
        thisOneUp.setId(ONE_UP_TEXT);
        ou.setThisPowerUp(thisOneUp);  //made this powerup
    }

    @Override
    public void doThePowerUp(Player myPlayer, Ball myBall, Platform myPlatform){
        /**
         * This method executes the oneUp powerup - it takes in myPlayer, myBall, and myPlatform, as it is an implementation
         * of an abstract method that needs all of those fields. This method makes the player have an additional life.
         */
        myPlayer.addLife();
    }

}

