/**
 * @author Liam Clark, Josh Boss
 * @Class Block
 * @Purpose To represent every block in a level that player needs to destroy
 * @Dependencies breakout package
 * @Example create an instance of class Block myBlock = new Block(int numHits, int x, int y),
 *          then call a method such as myBlock.updateBlocks( //parameters )
 */

package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.List;

public class Block {
    private int numberOfHitsLeft;
    private int centerX;
    private int centerY;
    private Rectangle thisBlock;
    private static final Paint BLOCK_COLOR_1 = Color.GREEN;
    private static final Paint BLOCK_COLOR_2 = Color.GREENYELLOW;
    private static final Paint BLOCK_COLOR_3 = Color.YELLOW;
    private static final Paint BLOCK_COLOR_4 = Color.ORANGE;
    private static final Paint BLOCK_COLOR_5 = Color.RED;
    private static final Paint BLOCK_COLOR_EXPLOSIVE = Color.BLACK;
    private static final Paint LOCK_BLOCK_COLOR = Color.DARKGRAY;
    private static final Paint UNLOCK_BLOCK_COLOR = Color.WHITE;
    private static final String BLOCK_ID = "block";
    private boolean isLocked = false;
    private Text boomText;
    private boolean isExplosive = false;

    private HashMap<Integer, Paint> colorMap = new HashMap<>();

    private Paint BLOCK_COLOR;


    public Block(int numberHits, int x, int y){
        numberOfHitsLeft = numberHits;
        createColorMap();
        BLOCK_COLOR = colorMap.get(numberHits);
        centerX = x + BlockMaker.BLOCK_WIDTH / 2;
        centerY = y + BlockMaker.BLOCK_HEIGHT / 2;
        thisBlock = new Rectangle(x, y, BlockMaker.BLOCK_WIDTH, BlockMaker.BLOCK_HEIGHT);
        thisBlock.setFill(BLOCK_COLOR);
        thisBlock.setId(BLOCK_ID);
    }

    public Block(int numberHits, int x, int y, boolean explosive, boolean locked, Group root){
        /**
         * Takes in paramaters int numberHits, int x, int y, boolean explosive, boolean locked, and a root:
         * Creates an instance of a block
         */
        isExplosive = explosive;
        isLocked = locked;
        if(isLocked){
            numberOfHitsLeft = 200;
            BLOCK_COLOR = LOCK_BLOCK_COLOR;
        }
        else if(isExplosive){
            numberOfHitsLeft = 6;
            BLOCK_COLOR = Color.BLACK;
        }
        else {
            numberOfHitsLeft = numberHits;
            createColorMap();
            BLOCK_COLOR = colorMap.get(numberHits);
        }
        centerX = x + BlockMaker.BLOCK_WIDTH / 2;
        centerY = y + BlockMaker.BLOCK_HEIGHT / 2;
        thisBlock = new Rectangle(x, y, BlockMaker.BLOCK_WIDTH, BlockMaker.BLOCK_HEIGHT);
        thisBlock.setFill(BLOCK_COLOR);
        thisBlock.setId(BLOCK_ID);
    }

    //todo - add update to make sure that if it hits 0 it actually deletes the block from the blockList

    public void updateBlocks(Ball myBall){
        /**
         * This takes in a ball object and determines what should happen when a block gets hit. It checks to see which type of block
         * was interesected and gives it the appropriate outcome.
         */
        if(this.isLocked() && !myBall.hasKey()){
            thisBlock.setFill(LOCK_BLOCK_COLOR);
        }
        else if(this.isLocked() && myBall.hasKey()){
            thisBlock.setFill(Color.WHITE);
            this.unlock();
        }
        else {
            numberOfHitsLeft--;
            if (!isExplosive) {
                BLOCK_COLOR = colorMap.get(numberOfHitsLeft);
                thisBlock.setFill(BLOCK_COLOR);
            }
        }
    }

    private void createColorMap(){
        colorMap.put(1, BLOCK_COLOR_1);
        colorMap.put(2, BLOCK_COLOR_2);
        colorMap.put(3, BLOCK_COLOR_3);
        colorMap.put(4, BLOCK_COLOR_4);
        colorMap.put(5, BLOCK_COLOR_5);
        colorMap.put(6, BLOCK_COLOR_EXPLOSIVE);
        colorMap.put(7, LOCK_BLOCK_COLOR);
    }


    public static void explode(List<Block> blockList, Block bomb, Ball myBall){
        /**
         * This method explodes the whole list of blocks (clearing the board). If a block is explsoive then it clears the board .
         * It takes in the blockList, the bomb block and the myBall as paramters.
         */


        for(Block block : blockList){
            if(bomb.isExplosive()){
                    block.updateBlocks(myBall);
                    blockList.clear();
                    break;
            }
        }
    }

    public Rectangle getThisBlock(){
        return thisBlock;
    }

    public void unlock(){
        isLocked = false;
    }

    public boolean isExplosive(){
        return isExplosive;
    }
    public boolean isLocked(){
        return isLocked;
    }

    public boolean isTouching(Block other){
        return Shape.intersect(this.thisBlock, other.thisBlock) != null;
    }

    public int getNumberOfHitsLeft(){
        return numberOfHitsLeft;
    }

    public int setNumberOfHitsLeft(int numberOfHitsLeft){
        return numberOfHitsLeft;
    }

    public int getCenterX(){ return centerX;}
    public int setCenterX(int centerX){
        return centerX;
    }
    public int getCenterY(){ return centerY;}
    public int setCenterY(int centerY){
        return centerY;
    }


}
