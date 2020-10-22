package breakout;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest extends DukeApplicationTest{
    private static final String TITLE = "Block TESTS";

    private static final Game myGame = new Game();
    private Stage myStage;
    private Scene myScene;
    private Circle myBallShape;
    private Rectangle myPlatformShape;
    private Ball myBall;
    private Platform myPlatform;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it

        myStage = stage;
        myScene = myGame.setupScene(11);
        myStage.setScene(myScene);
        myStage.setTitle(TITLE);
        myStage.show();

        myBallShape = lookup("#ball").query();
        myPlatformShape = lookup("#platform").query();
    }

    @Test
    void testScoreOfBlockDecreasesWhenHit() throws IOException {

        int ballInitialX = BlockMaker.BLOCK_WIDTH + 2*(int)myBallShape.getRadius();
        int ballInitialY = BlockMaker.BLOCK_HEIGHT + 2*(int)myBallShape.getRadius()+BlockMaker.BLOCK_HEIGHT;

        myBallShape.setCenterX(ballInitialX);
        myBallShape.setCenterY(ballInitialY);

        sleep(1, TimeUnit.SECONDS);
        int i = 0;

        while(i < 100) {
            myGame.step(Game.SECOND_DELAY);
            sleep(100, TimeUnit.MILLISECONDS);
            i++;
            if(checkBallBlockCollisionAndPowerUp()){
                break;
            }
            }
        }
    public boolean checkBallBlockCollisionAndPowerUp(){
        for(Block block : myGame.getBlockList()){
            Shape intersection = Shape.intersect(block.getThisBlock(), myBallShape);

            if(intersection.getBoundsInLocal().getWidth()!=-1){

                int scoreBeforeHit = block.getNumberOfHitsLeft();
                block.updateBlocks(myBall);
                myGame.getMyPlayer().addScore();
                int scoreAfterHit = block.getNumberOfHitsLeft();
                assertEquals(scoreBeforeHit, scoreAfterHit+1); //CHECKS SCORE IS DECREASED
                return true;
            }
            }
        return false;
    }

    }











