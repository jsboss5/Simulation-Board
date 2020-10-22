package cellsociety.view.ButtonSetups;

import cellsociety.model.GameBoard;
import cellsociety.view.Display;
import cellsociety.view.PopUpWindow;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class GridViewButtonSetup extends ButtonSetup {


  private final Display myDisplay;
  private Properties languageProperties;

  public GridViewButtonSetup(Display display) {
    myDisplay = display;
  }


  @Override
  protected void invokeHandlerMethod(String buttonName, Button currentButton,
      Properties textProperties) {
    languageProperties = textProperties;
    try {
      Method method = this.getClass().getDeclaredMethod("check" + buttonName, Button.class);
      method.invoke(this, currentButton);
    } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }


  public void checkStepOnce(Button stepButton) {
    stepButton.setOnAction(e -> myDisplay.nextGen());
  }

  public void checkLoadFile(Button loadFileButton) {
    loadFileButton.setOnAction(e -> {
      myDisplay.pauseGame();
      FileChooser fileChooser = new FileChooser();
      File resourcesFile = new File("resources");
      fileChooser.setInitialDirectory(resourcesFile);
      fileChooser.setTitle("Open Resource File");
      File propertiesFile = fileChooser.showOpenDialog(myDisplay.getStage());

      myDisplay
          .setNewSimulation(propertiesFile.getName());
    });
  }

  public void checkPlay(Button runButton) {
    runButton.setOnAction(e -> myDisplay.play());
  }

  public void checkPause(Button pauseButton) {
    pauseButton.setOnAction(e -> myDisplay.pauseGame());
  }

  public void checkSaveFile(Button fileSaveButton) {
    fileSaveButton.setOnAction(e -> {
      if (myDisplay.getController() != null) {
        GameBoard myGameBoard = myDisplay.getController().getGameBoard();
        PopUpWindow pUp = new PopUpWindow(myDisplay, myGameBoard, languageProperties);
      }
    });
  }

  public void checkImage(Button chooseImageButton) {
    chooseImageButton.setOnAction(e -> myDisplay.changeCellsToImages());
  }

  public void checkGraph(Button graphButton) {
    graphButton.setOnAction(e -> myDisplay.launchGraph());
  }


}
