package cellsociety.view;

import cellsociety.controller.Controller;
import java.util.Properties;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;


class SimulationBoardTest extends DukeApplicationTest {

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
  void testStateChangesOnClick() {
    Rectangle cell1 = lookup("#cell1,0").query();
    clickOn("#cell1,0");
    Assertions.assertEquals(Color.RED, cell1.getFill());
    clickOn("#cell1,0");
    Assertions.assertEquals(Color.BLUE, cell1.getFill());
  }
  @Test
  void testImageChangesOnClick() {
    Button imageButton = lookup("#Image").queryButton();
    javafxRun(() -> imageButton.fire());
    ImageView cell1 = lookup("#cell1,0").query();
    ImageView cell2 = lookup("#cell0,1").query();
    Image cell1image = cell1.getImage();
    Image cell2image = cell2.getImage();
    clickOn(cell1);
    clickOn(cell2);
    ImageView cell1nextGen = lookup("#cell1,0").query();
    ImageView cell2nextGen = lookup("#cell0,1").query();
    Assertions.assertNotEquals(cell1image,cell1nextGen.getImage());
    Assertions.assertNotEquals(cell2image,cell2nextGen.getImage());
  }
}