package breakout;

import breakout.PowerUps.OneUp;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PowerUpTest extends DukeApplicationTest {
    // create an instance of our game to be able to call in tests (like step())
    private final Game myGame = new Game();
    private Stage myStage;
    private final String TITLE = "POWER UP TESTS";
    public static final int VERTICAL_OFFSET = 40;
    private static final String TEST_PATHNAME = "data/maps/testMaps/test1.txt";
    private OneUp myBallGrower;

    Game br = new Game();

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show i

        myStage = stage;
        Scene myScene = myGame.setupScene(11);
        myStage.setScene(myScene);
        myStage.setTitle(TITLE);
        myStage.show();

    }

    @BeforeEach
    public void before() throws FileNotFoundException {
        myBallGrower = new OneUp();
        Group testRoot = new Group();
        testRoot.getChildren().add(myBallGrower.getThisPowerUp());
    }

    @Test
    void testOneUpGetterMethods() throws FileNotFoundException {

        myBallGrower.createPowerUpAtPoint(100,200);
        myBallGrower.getSpeed();
        assertEquals(myBallGrower.getSpeed(), 40);
        myBallGrower.setSpeed(50);
        assertEquals(myBallGrower.getSpeed(), 50);
        myBallGrower.setSpeed(-20);
        assertEquals(myBallGrower.getSpeed(), -20);

        assertEquals(myBallGrower.getSize(), 10);


    }

    @Test
    void testPlatformGrowerUpGetterMethods() throws FileNotFoundException {

        myBallGrower.createPowerUpAtPoint(100,200);
        myBallGrower.getSpeed();
        assertEquals(myBallGrower.getSpeed(), 40);
        myBallGrower.setSpeed(50);
        assertEquals(myBallGrower.getSpeed(), 50);
        myBallGrower.setSpeed(-20);
        assertEquals(myBallGrower.getSpeed(), -20);

        assertEquals(myBallGrower.getSize(), 10);


    }

    @Test
    void testBallGrowerUpGetterMethods() throws FileNotFoundException {

        myBallGrower.createPowerUpAtPoint(100,200);
        myBallGrower.getSpeed();
        assertEquals(myBallGrower.getSpeed(), 40);
        myBallGrower.setSpeed(50);
        assertEquals(myBallGrower.getSpeed(), 50);
        myBallGrower.setSpeed(-20);
        assertEquals(myBallGrower.getSpeed(), -20);

        assertEquals(myBallGrower.getSize(), 10);


    }

    @Test
    void createPowerUp_Some_Location() throws FileNotFoundException {

        myBallGrower.createPowerUpAtPoint(100,200);
        assertEquals(myBallGrower.getCenterX(), 100);
        assertEquals(myBallGrower.getCenterX(), 200);

        myBallGrower.createPowerUpAtPoint(200,300);
        assertEquals(myBallGrower.getCenterX(), 200);
        assertEquals(myBallGrower.getCenterX(), 300);

        myBallGrower.createPowerUpAtPoint(600,600);
        assertEquals(myBallGrower.getCenterX(), 600);
        assertEquals(myBallGrower.getCenterX(), 600);

    }


        @Test
        public void testPowerUpStillWhileBlockIsPresent() throws IOException {
        /*
        Tests if powerups are still while "inside" a block"
         */
            myBallGrower.createPowerUpAtPoint(200, 100);

        sleep(1, TimeUnit.SECONDS);
        myGame.step(Game.SECOND_DELAY);
        sleep(1, TimeUnit.SECONDS);

        assertEquals(200, myBallGrower.getThisPowerUp().getCenterX());
        assertEquals(100, myBallGrower.getThisPowerUp().getCenterY());
    }

    @Test
    void testPowerUpMoveWhileBlockIsBroke() throws IOException {
        /*
        Tests if powerups drop
         */
        myBallGrower.createPowerUpAtPoint(100, 100);
        myBallGrower.createPowerUpAtPoint(200, 100);


        sleep(1, TimeUnit.SECONDS);
        myGame.step(Game.SECOND_DELAY);
        myGame.step(Game.SECOND_DELAY);
        myGame.step(Game.SECOND_DELAY);
        myGame.step(Game.SECOND_DELAY);
        sleep(1, TimeUnit.SECONDS);

        assertEquals(180, myBallGrower.getThisPowerUp().getCenterX());
        assertEquals(100, myBallGrower.getThisPowerUp().getCenterY());
    }
}