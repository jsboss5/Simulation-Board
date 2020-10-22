package breakout;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BlockMakerTest extends DukeApplicationTest {

    private static final String TEST_PATHNAME = "data/maps/testMaps/test1.txt";
    private static final String TITLE = "BALL TESTS";
    private static final Game myGame = new Game();
    private Stage myStage;
    private List<Block> blockList;

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
        BlockMaker testBlockMaker = new BlockMaker();

        Group testRoot = new Group();
        blockList = testBlockMaker.createBlocks(testRoot);
        System.out.print(blockList.get(3).getNumberOfHitsLeft());
    }

    @Test
    void createBlocks_Some_Block_Location() throws FileNotFoundException {
        assertEquals(blockList.get(0).getThisBlock().getX(), 0);
        assertEquals(blockList.get(0).getThisBlock().getY(), 0);

        assertEquals(blockList.get(1).getThisBlock().getX(), 400);
        assertEquals(blockList.get(1).getThisBlock().getY(), 0);


        assertEquals(blockList.get(2).getThisBlock().getX(), 100);
        assertEquals(blockList.get(2).getThisBlock().getY(), 20);

        assertEquals(blockList.get(3).getThisBlock().getX(), 200);
        assertEquals(blockList.get(3).getThisBlock().getY(), 40);

        assertEquals(blockList.get(4).getThisBlock().getX(), 300);
        assertEquals(blockList.get(4).getThisBlock().getY(), 60);

        assertEquals(blockList.get(5).getThisBlock().getX(), 400);
        assertEquals(blockList.get(5).getThisBlock().getY(), 80);

        assertEquals(blockList.get(6).getThisBlock().getX(), 500);
        assertEquals(blockList.get(6).getThisBlock().getY(), 100);



    }
    @Test
    void createBlocks_ALL_Block_Scores() throws FileNotFoundException {
        assertEquals(blockList.get(0).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(1).getNumberOfHitsLeft(),6);
        assertEquals(blockList.get(2).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(3).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(4).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(5).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(6).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(7).getNumberOfHitsLeft(),5);
        assertEquals(blockList.get(8).getNumberOfHitsLeft(),3);
        assertEquals(blockList.get(9).getNumberOfHitsLeft(),4);
        assertEquals(blockList.get(10).getNumberOfHitsLeft(),2);
        assertEquals(blockList.get(11).getNumberOfHitsLeft(),1);
        assertEquals(blockList.get(12).getNumberOfHitsLeft(),200);
        assertEquals(blockList.get(13).getNumberOfHitsLeft(),5);
    }



}