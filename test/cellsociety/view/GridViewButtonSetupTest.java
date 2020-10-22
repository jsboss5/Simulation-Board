package cellsociety.view;

import java.util.Properties;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class GridViewButtonSetupTest extends DukeApplicationTest {

  private final Display myDisplay = new Display();


  @Override
  public void start(Stage stage) {
    Properties english = myDisplay.createPropertiesObject("resources/Text_Properties_Files/English.properties");
    myDisplay.generateSplashScreen(english,stage);
    myDisplay.chooseSimulation("ConwayGameOfLife",english);
    myDisplay.setNewSimulation("TestConway.properties");
    stage.show();
  }

  @Test
  public void testButtonGeneration() {

    lookup("#LoadFile").queryButton();
    lookup("#Play").queryButton();
    lookup("#SaveFile").queryButton();
    lookup("#Pause").queryButton();
    lookup("#Image").queryButton();
  }

  @Test
  public void testRunButton() {
    Button runButton = lookup("#Play").queryButton();

    Rectangle cell1 = lookup("#cell1,0").query();
    Rectangle cell2 = lookup("#cell0,1").query();
    Assertions.assertEquals(Color.BLUE, cell1.getFill());
    Assertions.assertEquals(Color.RED, cell2.getFill());
    runButton.fire();
    javafxRun(() -> myDisplay.step());
    Assertions.assertEquals(Color.RED, cell1.getFill());
    Assertions.assertEquals(Color.BLUE, cell2.getFill());

  }

  @Test

  public void testPauseButton() {

    Button pause = lookup("#Pause").queryButton();

    Rectangle cell1 = lookup("#cell1,0").query();
    Rectangle cell2 = lookup("#cell0,1").query();
    Assertions.assertEquals(Color.BLUE, cell1.getFill());
    Assertions.assertEquals(Color.RED, cell2.getFill());

    javafxRun(() -> myDisplay.nextGen());
    Assertions.assertEquals(Color.RED, cell1.getFill());
    Assertions.assertEquals(Color.BLUE, cell2.getFill());

    pause.fire();

    javafxRun(() -> myDisplay.step());
    Assertions.assertEquals(Color.RED, cell1.getFill());
    Assertions.assertEquals(Color.BLUE, cell2.getFill());

  }

  @Test
  public void testStepButton() {

    Button stepButton = lookup("#StepOnce").queryButton();

    Rectangle cell1 = lookup("#cell1,0").query();
    Rectangle cell2 = lookup("#cell0,1").query();
    Assertions.assertEquals(Color.BLUE, cell1.getFill());
    Assertions.assertEquals(Color.RED, cell2.getFill());

    stepButton.fire();
    Assertions.assertEquals(Color.RED, cell1.getFill());
    Assertions.assertEquals(Color.BLUE, cell2.getFill());

  }

  @Test
  public void testImageButton() {
    Button imageButton = lookup("#Image").queryButton();
    javafxRun(() -> imageButton.fire());
    ImageView cell1 = lookup("#cell1,0").query();
    ImageView cell2 = lookup("#cell0,1").query();
  }
}
