/**
 * @author Liam Clark, Josh Boss
 * @Class BallGrower
 * @Purpose To represent a type of powerup that makes the ball radius grow
 * @Dependencies breakout.PowerUps
 * @Assumptions BallGrower is never in the root at the same time as another powerup
 * @Example create a new BallGrower with PowerUp myBallGrower = new BallGrower(), then change information about the player using a method like
 * myBallGrower.createPowerUpAtPoint()
 */
package breakout.PowerUps;

import breakout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class BallGrower extends PowerUp {
    private final Paint BALL_GROWER_COLOR = Color.MEDIUMPURPLE;
    private static final String GROWBALL_TEXT = "BG";
    private Circle thisBallGrower;
    public BallGrower(){
        /**
         * Creates the instance of ball grower object. Sets speed and the specific Type.
         */
        setType(GROWBALL_TEXT);
        setSpeed(this.getSpeed());
    }

    public void createPowerUpAtPoint(int x, int y){
        /**
         * This public function creates a power up at the point specified by the input parameters. More specifically,
         * it creates a circle which will move down the screen and represent the ball grower power up.
         */
        BallGrower bg = this;
        thisBallGrower = new Circle(x,y,this.getSize(), BALL_GROWER_COLOR);
        setThisPowerUp(thisBallGrower);
        thisBallGrower.setId(GROWBALL_TEXT);
        bg.setThisPowerUp(thisBallGrower);
    }

    @Override
    public void doThePowerUp(Player myPlayer, Ball myBall, Platform myPlatform) {
        /**
         * This method executes the bigBall powerup - it takes in myPlayer, myBall, and myPlatform, as it is an implementation
         * of an abstract method that needs all of those fields. This method makes the ball bigger.
         */
        myBall.bigBall();
    }

}

