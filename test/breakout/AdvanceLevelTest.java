package breakout;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AdvanceLevelTest extends DukeApplicationTest {
    private final Game myGame = new Game();
    private Scene myScene;
    public static final int PLATFORM_SIZE = 80;
    public static final int BALL_SIZE = 30;
    private  Stage STAGE;
    private Circle ballShape;
    private Rectangle platformShape;
    private Rectangle currentBlock;
    @Override
    public void start(Stage stage) throws FileNotFoundException{
        STAGE = stage;
        myScene = myGame.setupScene(1);
        STAGE.setScene(myScene);
        STAGE.setTitle("GAME TESTS");
        STAGE.show();
        ballShape = lookup("#ball").query();
        platformShape = lookup("#platform").query();
        currentBlock = lookup("#block").query();
    }

    @Test
    public void advanceLevel() throws IOException {
        for(int i = 0; i<myGame.getBlockList().size()-1; i++){
            myGame.getBlockList().remove(i);
            //myScene.getRoot().getChildren();
        }

        ballShape.setCenterX(Game.SIZE - 10);
        ballShape.setCenterY(350);
        sleep(2000);
        for(int i = 0; i<100;i++){
            myGame.step(Game.SECOND_DELAY);
            sleep(100);
        }


    }





}