package cellsociety.view;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.controller.Controller;
import cellsociety.model.GameBoard;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class SaveFilesTest extends DukeApplicationTest {
  private SaveFiles testSaver;
  private GameBoard testConwayBoard;
  @Override
  public void start(Stage stage) {
    testSaver = new SaveFiles();
    String[][] myArrayOfStrings = new String[][]{{"0","1"},{"1","0"}};
    testConwayBoard = new GameBoard(myArrayOfStrings, "ConwayCell", "complete", "finite", new String[]{"0","1"} );
  }

  @Test
  void testSaveFile() throws IOException {
    // TODO: Finish this test

    testSaver.saveState(testConwayBoard, "conwayTest");
    File tmpDir = new File("resources/GAME_CSVS/conwayTest.csv");
    boolean exists = tmpDir.exists();
    assertTrue(exists);
  }



}