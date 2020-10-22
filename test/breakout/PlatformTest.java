package breakout;

import breakout.DukeApplicationTest;
import breakout.Game;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PlatformTest extends DukeApplicationTest {
    // create an instance of our game to be able to call in tests (like step())
    private final Game myGame = new Game();
    // keep created scene to allow mouse and keyboard events
    private Scene myScene;
    public static final int PLATFORM_SIZE = 80;
    public static final int BALL_SIZE = 30;
    // keep any useful elements whose values you want to test directly in multiple tests
    private Circle myBall;
    private final int SIZE = 600;
    private Rectangle myPlatform;
    public static final int VERTICAL_OFFSET = 40;

    private static Stage STAGE;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it

        STAGE = stage;
        myScene = myGame.setupScene(1);
        stage.setScene(myScene);
        stage.show();

        // find individual items within game by ID (must have been set in your code using setID())
        //Player p1 = new Player();
        //Level lvl = new Level(1, p1);
        myPlatform = lookup("#platform").query();
    }


    @Test
    public void testPlatformMovebad () throws FileNotFoundException {
        /**
         * Test to make sure platform moves according to key request
         */
        Player p1 = myGame.getMyPlayer();

        int initialX = SIZE / 2 - PLATFORM_SIZE / 2;
        int initialY = SIZE - VERTICAL_OFFSET;

        myPlatform.setX(initialX);
        myPlatform.setY(initialY);
        //Scene scene = myGame.getMyLevel().getScene();

        sleep(1, TimeUnit.SECONDS);
        press(myScene, KeyCode.LEFT);
        press(myScene, KeyCode.RIGHT);
        sleep(1, TimeUnit.SECONDS);

        assertTrue(initialX - 60 < myPlatform.getX() && myPlatform.getX() <= initialX);
        assertEquals(initialX - 30, myPlatform.getX());
        assertEquals(initialY, myPlatform.getY());

        sleep(1, TimeUnit.SECONDS);
        press(myScene, KeyCode.RIGHT);
        sleep(1, TimeUnit.SECONDS);

        assertEquals(initialX, myPlatform.getX());
        assertEquals(initialY, myPlatform.getY());
    }

    @Test
    public void testPlatformMove () {
        int initialX = SIZE / 2 - PLATFORM_SIZE / 2;
        int initialY = SIZE - VERTICAL_OFFSET;
        myPlatform.setX(initialX);
        myPlatform.setY(initialY);

        sleep(1, TimeUnit.SECONDS);
        press(myScene, KeyCode.LEFT);
        sleep(1, TimeUnit.SECONDS);

        assertTrue(initialX - 31 < myPlatform.getX() && myPlatform.getX() < initialX - 28);
        assertEquals(initialX - 30, myPlatform.getX());
        assertEquals(initialY, myPlatform.getY());

        sleep(1, TimeUnit.SECONDS);
        press(myScene, KeyCode.RIGHT);
        sleep(1, TimeUnit.SECONDS);

        assertEquals(initialX, myPlatform.getX());
        assertEquals(initialY, myPlatform.getY());
    }

    @Test
    void flipPlatDirection() {
        // TO DO
    }

    @Test
    void getPlatSpeed() {
        // TO DO
    }

    @Test
    void changePlatSpeed() {
        // TO DO
    }
}