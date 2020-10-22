package cellsociety.controller;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.view.Display;
import exceptions.InvalidPropertiesFileException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class ControllerTest extends DukeApplicationTest {
  // create an instance of our game to be able to call in tests (like step())
  private final Display conwayDisplay = new Display();
  // keep created scene to allow mouse and keyboard events
  private Properties english;
  // keep any useful elements whose values you want to test directly in multiple tests

  @Override
  public void start(Stage stage) {
    english = conwayDisplay.createPropertiesObject("resources/Text_Properties_Files/English.properties");
    conwayDisplay.generateSplashScreen(english,stage);
    conwayDisplay.chooseSimulation("ConwayGameOfLife",english);
    conwayDisplay.setNewSimulation("TestConway.properties");
    stage.show();
  }

  @Test
  void missingPropertiesTest(){
    assertThrows(InvalidPropertiesFileException.class,() -> new Controller("MissingProperty.properties", english));
    assertDoesNotThrow(() -> javafxRun(() -> conwayDisplay.setNewSimulation("MissingProperty.properties")));
  }

  @Test
  void notAPropertiesFileTest(){
    assertThrows(InvalidPropertiesFileException.class,() -> new Controller("default.png", english));
    assertDoesNotThrow(() -> javafxRun(() -> conwayDisplay.setNewSimulation("default.png")));
  }

  @Test
  void invalidCSVDimensions(){
    assertThrows(InvocationTargetException.class,() -> new Controller("BadCSVConway.properties", english));
    assertDoesNotThrow(() -> javafxRun(() -> conwayDisplay.setNewSimulation("BadCSVConway.properties")));
  }
  @Test
  void invalidCSVStates(){
    assertThrows(InvocationTargetException.class,() -> new Controller("InvalidStatesConway.properties", english));
    assertDoesNotThrow(() -> javafxRun(() -> conwayDisplay.setNewSimulation("BadCSVConway.properties")));
  }

}