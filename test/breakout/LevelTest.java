package breakout;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


class LevelTest extends DukeApplicationTest{
    private static final String TITLE = "BALL TESTS";
    private static final Game myGame = new Game();
    private Stage myStage;
    private Circle myBallShape;

    private static final String EXPECTED_SCORE_TEXT = "Score: 0";
    private static final String EXPECTED_LEVEL_TEXT = "LEVEL 2";
    private static final String EXPECTED_LIVES_TEXT = "Lives left: 3";
    private List<Block> blockList;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it

        myStage = stage;
        Scene myScene = myGame.setupScene(2);
        myStage.setScene(myScene);
        myStage.setTitle(TITLE);
        myStage.show();

    }

    @BeforeEach
    public void before() throws FileNotFoundException {
        BlockMaker testBlockMaker = new BlockMaker(2);

        Group testRoot = new Group();
        blockList = testBlockMaker.createBlocks(testRoot);
    }
    @Test
    void testInitialText(){
        assertEquals(myGame.getMyLevel().getScoreText().getText(), EXPECTED_SCORE_TEXT);
        assertEquals(myGame.getMyLevel().getLevelText().getText(), EXPECTED_LEVEL_TEXT);
        assertEquals(myGame.getMyLevel().getLivesText().getText(), EXPECTED_LIVES_TEXT);
    }
    @Test
    void correctLayoutForLevel_2() throws FileNotFoundException {
        assertEquals(blockList.get(0).getThisBlock().getX(), 200);
        assertEquals(blockList.get(0).getThisBlock().getY(), 0);
        assertEquals(blockList.get(1).getThisBlock().getX(), 300);
        assertEquals(blockList.get(1).getThisBlock().getY(), 0);
        assertEquals(blockList.get(2).getThisBlock().getX(), 100);
        assertEquals(blockList.get(2).getThisBlock().getY(), 20);
        assertEquals(blockList.get(3).getThisBlock().getX(), 200);
        assertEquals(blockList.get(3).getThisBlock().getY(), 20);
        assertEquals(blockList.get(4).getThisBlock().getX(), 300);
        assertEquals(blockList.get(4).getThisBlock().getY(), 20);
        assertEquals(blockList.get(5).getThisBlock().getX(), 400);
        assertEquals(blockList.get(5).getThisBlock().getY(), 20);
    }
}