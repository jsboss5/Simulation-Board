/**
 * @author Liam Clark, Josh Boss
 * @Class Level
 * @Purpose To set up and configure a level with instance variables and other data specific to that level
 * @Dependencies breakout package
 * @Assumptions A root already exists that we can add level specific objects to
 * @Example create a new level with Level myLevel = new Level(int level, Player myPlayer), then can set up scene
 * using myLevel.setUpScene()
 */

package breakout;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.List;
import javax.sound.sampled.*;

public class Level extends JFrame {
    private static final int DEFAULT_LEVEL = 1;

    private static final String BALL_ID = "ball";
    private static final String PLATFORM_ID = "platform";
    private int currentLevel;

    private Scene currentScene;

    private List<Block> blockList;
    private Ball myBall;
    private Key myKey;
    private Platform myPlatform;
    private Player myPlayer;
    private PowerUp myPowerUp;
    private Text scoreText;
    private Text levelText;
    private Text livesText;
    private Group root;

    public Level(int level, Player player) throws FileNotFoundException {
        /**
         * Sets instance variables from int level, and Player player instance variables.
         */

        myPlayer = player;
        currentLevel = level;
        currentScene = setUpScene();
    }

    public Level(Player player) throws FileNotFoundException {
        /**
         * Calls the other level constructor with default level
         */
        this(DEFAULT_LEVEL, player);
    }

    private Scene setUpScene() throws FileNotFoundException {
        root = new Group();

        System.out.println(currentLevel);

        BlockMaker blockSetup = new BlockMaker(currentLevel);
        //it makes sense that ball, platform, blocklist are all inherent to the level and change with new level

        myBall = new Ball(currentLevel);
        myKey = new Key(currentLevel);
        myBall.getThisBall().setId(BALL_ID);
        //myPowerUp = new PowerUp();
        myPlatform = new Platform(currentLevel);
        myPlatform.getThisPlatform().setId(PLATFORM_ID);
        blockList = blockSetup.createBlocks(root);  //Todo - add level as a paramter for new blocklist
        generateGameText();
        return addToRoot(root);
    }

    private void generateGameText(){
        scoreText = new Text(10, 20, Game.SCORE_HEADER + myPlayer.getScore());
        levelText = new Text(250, 20, Game.LEVEL_HEADER + currentLevel);
        livesText = new Text(500, 20, Game.LIVES_HEADER + myPlayer.getLivesLeft());
        scoreText.setFill(Color.WHITESMOKE);
        levelText.setFill(Color.WHITESMOKE);
        livesText.setFill(Color.WHITESMOKE);
    }

    private Scene addToRoot(Group root){
        root.getChildren().add(myBall.getThisBall());
        root.getChildren().add(myKey.getThisKey());
        root.getChildren().add(scoreText);
        root.getChildren().add(levelText);
        root.getChildren().add(livesText);
        root.getChildren().add(Game.getHighScoreText());
        root.getChildren().add(Game.getNewHighScore());
        root.getChildren().add(myPlatform.getThisPlatform());
        // create a place to see the shapes
        Scene scene = new Scene(root, Game.SIZE, Game.SIZE, Game.BACKGROUND);
        return scene;
    }

    public Scene getScene(){
        return currentScene;
    }

    public PowerUp getPowerUp(){
        return myPowerUp;
    }

    public Ball getMyBall(){
        return myBall;
    }

    public Platform getMyPlatform(){
        return myPlatform;
    }
    public Key getMyKey(){
        return myKey;
    }

    public Player getMyPlayer(){
        return myPlayer;
    }


    public List<Block> getBlockList(){
        return blockList;
    }

    public Text getScoreText() {
        return scoreText;
    }
    public Text getLevelText(){
        return levelText;
    }
    public Text getLivesText(){
        return livesText;
    }

    public  int getCurrentLevel(){
        return currentLevel;
    }
    public Group getRoot() {
        return root;
    }
}
