/**
 * @author Liam Clark, Josh Boss
 * @Class Platform
 * @Purpose To represent the player controlled platform that is responsible for ensuring that the ball does not go out of bounds
 * @Dependencies breakout package
 * @Assumptions Platform cannot change y direction, will only change X direction left or right
 * @Example create a new platform with Platform myPlatform = new Platform(int level), then create the platform using
 * using myPlatform.createPlatformFromLevel(int level)
 */
package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Platform extends Game{
    public Rectangle thisPlatform;
    public static int thisLevel;
    public static int platformSpeed;

    public static final Paint PLATFORM_COLOR = Color.GRAY;
    public static int platformSize = 80;
    public static final int SCREEN_SIZE = 600;
    public static final int VERTICAL_OFFSET = 40;
    public static final String PLATFORM_ID = "platform";
    public static final int GROWTH_FACTOR = 10;

    public Platform(int level){
        /**
         * Creates platform object from level input
         */
        thisLevel = level;
        createPlatformFromLevel(thisLevel);
    }

    private void createPlatformFromLevel(int level){
        thisPlatform = new Rectangle(SCREEN_SIZE / 2 - platformSize / 2, SCREEN_SIZE - VERTICAL_OFFSET, platformSize - 10 * level, platformSize / 4);
        thisPlatform.setFill(PLATFORM_COLOR);
        thisPlatform.setId(PLATFORM_ID);
        platformSpeed = 20 + (level * 10);
    }

    public double getX(){
        return thisPlatform.getX();
    }
    public double getY(){
        return thisPlatform.getY();
    }

    public void setX(int newX){
        thisPlatform.setX(newX);
    }
    public void setY(int newY){
         thisPlatform.setY(newY);
    }

    public double getWidth(){
        return thisPlatform.getWidth();
    }


    public double getHeight(){
        return thisPlatform.getHeight();
    }
    public void grow(){
        platformSize += GROWTH_FACTOR;
        thisPlatform.setWidth(platformSize - GROWTH_FACTOR * thisLevel);
    }



    public void flipPlatDirection(){
        platformSpeed *= -1;
    }
    public int getPlatSpeed(){
        return platformSpeed;
    }
    public void changePlatSpeed(int newSpeed){
        platformSpeed = newSpeed;
    }

    public Rectangle getThisPlatform(){
        return thisPlatform;
    }

    public void setThisPlatform(Rectangle newPlatform ){
        thisPlatform = newPlatform;
    }


}
