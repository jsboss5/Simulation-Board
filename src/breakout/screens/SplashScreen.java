package breakout.screens;

import breakout.Screen;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends Screen {
    private static final String GAME_START_MESSAGE = "Are You Ready?";
    private static final String BUTTON_MESSAGE = "Click to Play";
    private static final Paint BACKGROUND_PAINT = Color.DARKSLATEGRAY;
    private static final int INSTRUCTION_HEADER_VERT_OFFSET = 50;
    private static final int INSTRUCTION_HORIZONTAL_OFFSET = 50;

    private static final int HEADER_FONT_SIZE = 30;
    private static final int BODY_FONT_SIZE = 15;
    private static final int BODY_ADDITIONAL_OFFSET = 40;
    private static final int HEADER_ADDITIONAL_OFFSET = 0;
    private static final String FONT = "verdana";

    private static final String INSTRUCTION_HEADER_TEXT = "Instructions";
    private static final String INSTRUCTIONS_TEXT = "1. Use the left and right arrow keys to move the paddle \n\n" +
            "2. Don't let the ball drop bellow the paddle \n\n" +
            "3. Clear the board of all blocks to advance \n\n" +
            "4. You have 3 lives... Good Luck!!";


    private List<Text> textList = new ArrayList<>();

    public SplashScreen(){
        createScreen();
    }

    @Override
    public void createScreen() {
        /**
         * This method calls the newInstructions Text method below and the createNewScreen super method to create a splash screen
         * to be displayed before the game starts.
         */

        textList.add(newInstructionsText(INSTRUCTION_HEADER_TEXT,HEADER_FONT_SIZE,HEADER_ADDITIONAL_OFFSET,FontWeight.BOLD));
        textList.add(newInstructionsText(INSTRUCTIONS_TEXT,BODY_FONT_SIZE,BODY_ADDITIONAL_OFFSET, FontWeight.NORMAL));
        textList.add(super.createTextAboveButton(GAME_START_MESSAGE));

        super.createNewScreen(BUTTON_MESSAGE, textList, BACKGROUND_PAINT);
    }

    private Text newInstructionsText(String text, int fontSize, int additionalVerticalOffset, FontWeight fontWeight) {
        Text instructions = new Text();
        instructions.setText(text);
        instructions.setFont(Font.font(FONT, fontWeight, fontSize ));
        instructions.setX(INSTRUCTION_HORIZONTAL_OFFSET);
        instructions.setY(INSTRUCTION_HEADER_VERT_OFFSET + additionalVerticalOffset);

        return instructions;
    }

}
