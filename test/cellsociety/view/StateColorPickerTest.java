package cellsociety.view;

import cellsociety.controller.Controller;
import java.util.Properties;
import javafx.scene.AccessibleAction;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class StateColorPickerTest extends DukeApplicationTest {

  // create an instance of our game to be able to call in tests (like step())
  private final Display conwayDisplay = new Display();
  // keep created scene to allow mouse and keyboard events
  private Scene myScene;
  // keep any useful elements whose values you want to test directly in multiple tests

  @Override
  public void start(Stage stage) {
    Properties english = conwayDisplay.createPropertiesObject("resources/Text_Properties_Files/English.properties");
    conwayDisplay.generateSplashScreen(english,stage);
    conwayDisplay.chooseSimulation("ConwayGameOfLife",english);
    conwayDisplay.setNewSimulation("TestConway.properties");
    stage.show();
  }

  @Test
  void testColorChanges() {
    // TODO: 2020-10-13 ask how to test this
    ColorPicker colorPicker = lookup("#0color").query();
    Rectangle cell = lookup("#cell1,0").query();
    Assertions.assertEquals(Color.BLUE, cell.getFill());

    javafxRun(() -> colorPicker.setValue(Color.PURPLE));
    //javafxRun(() -> colorPicker.notifyAll());

    javafxRun(() -> conwayDisplay.nextGen());

    Assertions.assertEquals(Color.PURPLE, cell.getFill());
  }
}