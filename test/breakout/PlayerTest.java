package breakout;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends DukeApplicationTest{

    private static final String TITLE = "PLAYER TESTS";
    private static final Game myGame = new Game();
    private Stage myStage;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // create game's scene with all shapes in their initial positions and show it

        myStage = stage;
        Scene myScene = myGame.setupScene(11);
        myStage.setScene(myScene);
        myStage.setTitle(TITLE);
        myStage.show();

       // myBallShape = (lookup("#ball").query());
    }






}