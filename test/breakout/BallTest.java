package breakout;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BallTest extends DukeApplicationTest{
    private static final String TITLE = "BALL TESTS";
    private static final Game myGame = new Game();
    private Stage myStage;
    private Circle myBallShape;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it


        myStage = stage;
        Scene myScene = myGame.setupScene(10);
        myStage.setScene(myScene);
        myStage.setTitle(TITLE);
        myStage.show();

        myBallShape = (lookup("#ball").query());
    }

    @Test
    void createBallFromLevel(){
        /**
         * Tests to make sure initial starting position and initial speeds are
         * correct based on level
         */
        Ball test1 = new Ball(1);
        Ball test2 = new Ball(2);
        Ball test3 = new Ball(3);

        assertEquals(test1.getCenterX(), Game.SIZE/2);
        assertEquals(test1.getCenterY(),Game.SIZE/2);
        assertEquals(test1.getSpeedX(), 50 + 10*1);

        assertEquals(test2.getCenterX(), Game.SIZE/2);
        assertEquals(test2.getCenterY(),Game.SIZE/2);
        assertEquals(test2.getSpeedX(), 50 + 10*2);

        assertEquals(test3.getCenterX(), Game.SIZE/2);
        assertEquals(test3.getCenterY(),Game.SIZE/2);
        assertEquals(test3.getSpeedX(), 50 + 10*3);

    }
    @Test
    public void testBallInCorner() throws IOException {
        //myBall = new Ball(1);

        int initialX = Game.SIZE - (int)myBallShape.getRadius();
        int initialY = (int)myBallShape.getRadius();
        //Ball test1 = new Ball(1);

        myBallShape.setCenterX(initialX - 2);
        myBallShape.setCenterY(initialY - 2);

        sleep(1, TimeUnit.SECONDS);
        myGame.step(10/Game.FRAMES_PER_SECOND);
        sleep(1, TimeUnit.SECONDS);
        assertEquals(initialX - 2, myBallShape.getCenterX());
        assertEquals(initialY - 2, myBallShape.getCenterY());

        sleep(1, TimeUnit.SECONDS);
        myGame.step(Game.SECOND_DELAY);
        sleep(1, TimeUnit.SECONDS);
        assertEquals(initialX + .5, myBallShape.getCenterX());
        assertEquals(initialY + 3, myBallShape.getCenterY());

    }

}