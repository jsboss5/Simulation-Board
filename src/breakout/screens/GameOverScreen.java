package breakout.screens;

import breakout.Game;
import breakout.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameOverScreen extends Screen {
    private static final String GAME_OVER_MESSAGE = "GAME OVER";
    private static final String BUTTON_MESSAGE = "Play Again";
    private static final Paint BACKGROUND_PAINT = Color.AQUAMARINE;
    private List<Text> textList = new ArrayList<>();

    public GameOverScreen(){
        createScreen();
    }

    public void createScreen(){
        /**
         * This method calls the create screen method from the superclass to make a game over screen
         */

        textList.add(super.createTextAboveButton(GAME_OVER_MESSAGE));
        super.createNewScreen(BUTTON_MESSAGE, textList , BACKGROUND_PAINT);
    }

}
