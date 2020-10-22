/**
 * @author Liam Clark, Josh Boss
 * @Class BlockMaker
 * @Purpose To read level files from testMaps directory and populates blockList with Block objects
 * @Dependencies breakout package
 * @Example create an instance of class BlockMaker bm = new BlockMaker(int level),
 *          then call a method such as myBlock.createBlocks( //parameters )
 */

package breakout;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BlockMaker {
    final String LEVEL_PATH = "data/maps/level";
    final String TEST_PATH = "data/maps/testMaps/test";
    final String EXTENSION = ".txt";
    private Scanner input;
    //public static final int SIZE = 600;
    public static final int BLOCK_WIDTH = 100;
    public static final int BLOCK_HEIGHT = 20;
    private static final int BLOCK_ROWS = 18;
    private static final int FIRST_TEST_LEVEL=10;
    private static final int HORIZONTAL_BUFFER = 50;
    private static final int VERTICAL_BUFFER = 10;
    private static final int DEFAULT_LEVEL = 1;
    private static final int NUM_HITS_LOCK_BLOCK = 200;
    private static final int NUM_HITS_SPLODE_BLOCK = 10;
    private static final int LEVEL_DIVISOR_FACTOR = 10;

    private static final int MAX_VAL_OF_NORM_BLOCK = 5;
    private static boolean IS_EXPLOSIVE = true;
    private static boolean IS_LOCKED = true;
    private static final String SPACE = " ";
    private static final String BOOM_TEXT = "BOOM!";

    public BlockMaker() throws FileNotFoundException {
        input = new Scanner(new File(LEVEL_PATH + DEFAULT_LEVEL + EXTENSION));
    }

    public BlockMaker(int level) throws FileNotFoundException {
        /**
         * creates blockMaker object based on a given level - sets input scanner instance variable
         */
        String pathName;
        if(level< FIRST_TEST_LEVEL){
            pathName = LEVEL_PATH + level + EXTENSION;
        }
        else{
            pathName = TEST_PATH + level%LEVEL_DIVISOR_FACTOR + EXTENSION;
        }
        input = new Scanner(new File(pathName));
    }

    //TODO - might want to split adding to list and adding to root into different methods but for now this works
    public List<Block> createBlocks(javafx.scene.Group root){
        /**
         * This method is called from the level class to create all of the blocks and add them to the scene.
         * It takes in the root as a parameter and calls the other helper methods which actually do the work of adding the
         * blocks to the scene.
         */
        List<Block> blockList = new ArrayList<>();
        while(input.hasNextLine()){
            for(int y = 0; y < BLOCK_ROWS * BLOCK_HEIGHT - VERTICAL_BUFFER; y += BLOCK_HEIGHT) {
                createBlockRow(root, blockList, y);
            }
        }

    return blockList;
    }

    private void createBlockRow(Group root, List<Block> blockList, int y) {
        String[] numbers = input.nextLine().split(SPACE);
        int i = 0;

        for (int x = 0; x < Game.SIZE - HORIZONTAL_BUFFER; x += BLOCK_WIDTH ) {
            int specifiedBlockValue = Integer.parseInt(numbers[i]);
            if(specifiedBlockValue > MAX_VAL_OF_NORM_BLOCK){
                addSpecialBlock(root, blockList, specifiedBlockValue,x, y);
            }

            else if(Integer.parseInt(numbers[i])!=0) {
                addBlockToRootAndList(root, blockList, new Block(Integer.parseInt(numbers[i]), x, y, !IS_EXPLOSIVE, !IS_LOCKED, root));
            }
            i++;
        }


    }
    private void addSpecialBlock(Group root, List<Block> blockList, int valOfBlock, int x, int y){
        addBlockToRootAndList(root, blockList, new Block(getProperHitsForSpecial(valOfBlock), x, y, checkExplosive(valOfBlock) , checkLocked(valOfBlock), root));
    }

    private int getProperHitsForSpecial(int valOfBlock){
        return checkLocked(valOfBlock) ? NUM_HITS_LOCK_BLOCK : NUM_HITS_SPLODE_BLOCK;
    }

    private boolean checkExplosive(int valOfBlock){
        return valOfBlock%6==0 && valOfBlock>=6;
    }

    private boolean checkLocked(int valOfBlock){
        return valOfBlock % 7 == 0 && valOfBlock>=7;
    }

    private void addBlockToRootAndList(Group root, List<Block> blockList, Block newBlock1) {
        Block newBlock = newBlock1;
        if(newBlock.isExplosive()){
            Text boomText = new Text(newBlock.getCenterX(), newBlock.getCenterY(), BOOM_TEXT);
            boomText.setFill(Color.WHITESMOKE);
            final StackPane stack = new StackPane();
            stack.getChildren().addAll(newBlock.getThisBlock(), boomText);
        }
        blockList.add(newBlock);
        root.getChildren().add(newBlock.getThisBlock());
    }
}
