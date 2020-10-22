package breakout.screens;

import breakout.Screen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

public class LevelFinishedScreen extends Screen {
    private static final String LEVEL_UP_MESSAGE = "LEVEL COMPLETE";
    private static final String BUTTON_MESSAGE = "NEXT LEVEL";
    private static final Paint BACKGROUND_PAINT = Color.AQUAMARINE;
    private List<Text> textList = new ArrayList<>();

    public LevelFinishedScreen(){
        createScreen();
    }

    public void createScreen() {
        /**
         * This method calls the create screen method from the superclass to make a levelFinished  screen
         */
        textList.add(super.createTextAboveButton(LEVEL_UP_MESSAGE));
        super.createNewScreen(BUTTON_MESSAGE, textList, BACKGROUND_PAINT);

    }

}
