package breakout;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest extends DukeApplicationTest {
    // create an instance of our game to be able to call in tests (like step())
    private final Game myGame = new Game();
    // keep created scene to allow mouse and keyboard events
    private Scene myScene;
    public static final int PLATFORM_SIZE = 80;
    public static final int BALL_SIZE = 30;
    // keep any useful elements whose values you want to test directly in multiple tests
    private Ball myBall;
    private final int SIZE = 600;
    private Platform myPlatform;
    public static final int VERTICAL_OFFSET = 40;
    private static  Circle ballShape;
    private  Stage STAGE;
    private Rectangle platformShape;
    /**
     * Start special test version of application that does not animate on its own before each test.
     *
     * Automatically called @BeforeEach by TestFX.
     */

    //TODO
    // 1. actually pass ball objects instaed of ball shapes
    // 2. Figure out how to do different sc
    // 3. REset

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it

        STAGE = stage;
        myScene = myGame.setupScene(1);
        STAGE.setScene(myScene);
        STAGE.setTitle("GAME TESTS");
        STAGE.show();
        //STAGE.show();

        myBall = new Ball(1);
        myPlatform = new Platform(1);
        myBall.setThisBall(lookup("#ball").query());
        myPlatform.setThisPlatform(lookup("#platform").query());
        ballShape = lookup("#ball").query();
        platformShape = lookup("#platform").query();
        // find individual items within game by ID (must have been set in your code using setID())

    }

    @Test
    public void testInitialPositions () {

        // GIVEN, start of the game
        // WHEN, no events have happened
        // THEN, check elements are correctly positioned (to as much detail as yuo need)
        assertEquals(300, myBall.getCenterX());
        assertEquals(300, myBall.getCenterY());
        assertEquals(15, myBall.getRadius());

        assertEquals(260, myPlatform.getX());
        assertEquals(560, myPlatform.getY());
        assertEquals(70, myPlatform.getWidth());
        assertEquals(20, myPlatform.getHeight());

        sleep(1, TimeUnit.SECONDS);    // PAUSE: not typically recommended in tests, but helps "see" results
    }


    @Test
    public void testKeyBlocks () {
        /**
         * Test to make a large portion of blocks are in the correct place
         */
        assertEquals((int)myGame.getBlockList().get(0).getThisBlock().getX(), 0);
        assertEquals((int)myGame.getBlockList().get(0).getThisBlock().getY(), 0);

        assertEquals((int)myGame.getBlockList().get(1).getThisBlock().getX(), 400);
        assertEquals((int)myGame.getBlockList().get(1).getThisBlock().getY(), 0);

        assertEquals((int)myGame.getBlockList().get(2).getThisBlock().getX(), 100);
        assertEquals((int)myGame.getBlockList().get(2).getThisBlock().getY(), 20);

        assertEquals((int)myGame.getBlockList().get(3).getThisBlock().getX(), 200);
        assertEquals((int)myGame.getBlockList().get(3).getThisBlock().getY(), 40);

        assertEquals((int)myGame.getBlockList().get(4).getThisBlock().getX(), 300);
        assertEquals((int)myGame.getBlockList().get(4).getThisBlock().getY(), 60);

        //assertEquals();
    }


    @Test
    public void testBallBounceBack () throws IOException {
        /**
         * Tests to make srue ball bounces off block correctly
         */
        //start(new Stage());
        int ballInitialX = BlockMaker.BLOCK_WIDTH + BALL_SIZE;
        int ballInitialY = BlockMaker.BLOCK_HEIGHT + BALL_SIZE+BlockMaker.BLOCK_HEIGHT;
        myBall.setCenterX(ballInitialX);
        myBall.setCenterY(ballInitialY);

        sleep(1, TimeUnit.SECONDS);
        int i = 0;
        boolean lowerYCoord = false;

        while(i < 100) {
            myGame.step(Game.SECOND_DELAY);
            sleep(100, TimeUnit.MILLISECONDS);
            i++;
            if(myBall.getCenterY()> ballInitialY){
                lowerYCoord = true;
                break;
            }
        }
        assertTrue(lowerYCoord);

    }
    @Test
    public void testOffScreen() throws IOException {
        /**
         * Tests to see if the ball resets position when it goes off screen and
         */

        int i = 0;
        boolean reset = false;
        Player myPlayer = myGame.getMyPlayer();
        int livesLeft = myPlayer.getLivesLeft();
        ballShape.setCenterX(SIZE /2);
        ballShape.setCenterY(SIZE - 5);

        myBall.setSpeedY(100);
        myBall.setSpeedX(50);

        while(i < 1000) {
            myGame.step(Game.SECOND_DELAY);
            sleep(10, TimeUnit.MILLISECONDS);
            i++;
            if(myBall.getCenterX() == SIZE/2 && myBall.getCenterY() == SIZE/2){
                myGame.checkBottomBoundary(ballShape);
                myGame.resetPaddleAndBall();
                reset = true;
                assertEquals(livesLeft - 1, myPlayer.getLivesLeft());
                sleep(2, TimeUnit.SECONDS);
                break;
            }
        }
        assertTrue(reset);
    }

    @Test
    void checkKeyCodes(){
        myScene.setOnKeyPressed(e -> {
            try {
                myGame.handleKeyInput(e.getCode());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
            int ogNumBlocks = myGame.getBlockList().size();
            sleep(3000);
            press(myScene, KeyCode.D);
            sleep(3000);
            int newNumBlocks = myGame.getCurrentBlockList().size();
            assertEquals(ogNumBlocks - 1, newNumBlocks);

    }




}