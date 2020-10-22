package cellsociety.view;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.controller.Controller;
import java.util.Properties;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class PopUpWindowTest extends DukeApplicationTest {
  private final Display myDisplay = new Display();
  private Properties english;
  // keep created scene to allow mouse and keyboard events
  // keep any useful elements whose values you want to test directly in multiple tests

  @Override
  public void start(Stage stage) {
    english =  myDisplay.createPropertiesObject("resources/Text_Properties_Files/English.properties");
    myDisplay.generateSplashScreen(english,stage);
    myDisplay.chooseSimulation("ConwayGameOfLife",english);
    myDisplay.setNewSimulation("TestConway.properties");
    stage.show();
  }

  @Test
  void testPopUpWindowPopulates() {
    // TODO: Finish this test

    Button saveFileButton = lookup("#SaveFile").queryButton();

    Platform.runLater(          // Code in this one was taken from Stack OverFlow -> The platform
        () -> {
          saveFileButton.fire();
          Assertions
              .assertDoesNotThrow(() -> new PopUpWindow(myDisplay, myDisplay.getController().getGameBoard(), english));
        }
    );

    sleep(2000);

  }

}