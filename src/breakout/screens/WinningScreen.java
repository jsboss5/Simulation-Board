package breakout.screens;

import breakout.Screen;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class WinningScreen extends Screen {
    private static final String WINNING_MESSAGE = "CONGRATS, YOU WON";
    private static final String BUTTON_MESSAGE = "Play Again";
    private static final Paint BACKGROUND_PAINT = Color.AQUAMARINE;
    private List<Text> textList = new ArrayList<>();

    public WinningScreen(){
        createScreen();
    }

    public void createScreen(){
        /**
         * This method calls the create screen method from the superclass to make a game winning screen
         */
        textList.add(super.createTextAboveButton(WINNING_MESSAGE));
        super.createNewScreen(BUTTON_MESSAGE, textList, BACKGROUND_PAINT);
    }

}
