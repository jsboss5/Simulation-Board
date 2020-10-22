package cellsociety.view;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.controller.Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

class ImageCellViewTest {

  @Test
  public void testImageButton() throws IOException {
    Properties prop = new Properties();
    prop.load(RectangleCellView.class.getClassLoader()
        .getResourceAsStream("Properties_Files/ConwayGameOfLife.properties"));
    Assertions
        .assertDoesNotThrow(() -> new ImageCellView(50,50,"0",prop));
  }

}