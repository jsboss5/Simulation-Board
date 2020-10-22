/**
 * @author Liam Clark, Josh Boss
 * @Class Screen
 * @Purpose To abstractly represent a screen that is displayed either before the game is started, in between levels, and after the game is won/lost.
 * @Dependencies breakout package
 * @Assumptions Each screen has one button, an array of text, and hsa one background color
 * @Example create a new screen with  createNewScreen(String buttonMessage, List<Text> textArray, Paint backgroundPaint), then change information such as the displayed
 * text with createTextAboveButton(String textAboveButton)
 */
package breakout;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public abstract class Screen {

    private Scene myScene;
    private Button myButton;
    private static final int VERTICAL_OFFSET = 20;
    private static final int BUTTON_SIZE = 90;
    private static final int BUTTON_TEXT_SIZE = 15;
    private static final String FONT = "verdana";

    public void createNewScreen(String buttonMessage, List<Text> textArray, Paint backgroundPaint){
        /**
         * This method takes in a buttonMessage string, an array of text, and a background color to make a specific type of screen
         * depending on what is specified by the certain subclass. It sets the scene in the myScene instance variable
         */

        myButton = setSingleButton(buttonMessage);
        Group root = new Group();
        root.getChildren().add(myButton);
        for(Text text: textArray){
            root.getChildren().add(text);
        }
        myScene = new Scene(root, Game.SIZE, Game.SIZE, backgroundPaint);

    }

    public Text createTextAboveButton(String textAboveButton) {
        /**
         * This method creates a text object and formats correctly to be placed a button in the middle of the screen.
         * it takes in what will be displayed above the button.
         */
        Text text = new Text();
        text.setText(textAboveButton);
        text.setFont(Font.font(FONT, BUTTON_TEXT_SIZE ));

        double width = text.getLayoutBounds().getWidth();
        text.setX(Game.SIZE/2 - width/2);
        text.setY(Game.SIZE/2 - VERTICAL_OFFSET);
        return text;
    }


    public Button setSingleButton(String buttonMessage) {
        /**
         * This method takes a string as a parameter and makes a button and places it in the middle of the screen with the
         * string parameter written on it. It returns the formatted button.
         */
        Button tempButton = new Button(buttonMessage);
        double buttonWidth = tempButton.getLayoutBounds().getCenterX();
        System.out.println(buttonWidth);
        tempButton.setLayoutX(Game.SIZE/2 - BUTTON_SIZE/2);
        tempButton.setLayoutY(Game.SIZE/2);
        return tempButton;
    }

    public abstract void createScreen();

    /**
     * all subclasses must create a screen with this method
     * @return
     */

    public Scene getMyScene(){
        /**
         * This method returns the scene instance variable
         */
        return myScene;
    }

    public Button getMyButton(){
        /**
         * This method returns the current button
         */
        return myButton;
    }


}
