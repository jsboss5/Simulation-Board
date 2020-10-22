package cellsociety.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Properties;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

class CellViewTest {

  @Test
  public void setColorTest() throws IOException {
    Properties prop = new Properties();
    prop.load(RectangleCellView.class.getClassLoader()
        .getResourceAsStream("Properties_Files/ConwayGameOfLife.properties"));
    Rectangle testCell = (Rectangle) new RectangleCellView(0, 0, "DEAD", prop).getCell();
    assertEquals(Color.BLUE, testCell.getFill());
    Rectangle testCell2 = (Rectangle) new RectangleCellView(0, 0, "ALIVE", prop).getCell();
    assertEquals(Color.RED, testCell2.getFill());
    Rectangle testCell3 = (Rectangle) new RectangleCellView(0, 0, "FAKESTATE", prop).getCell();
    assertEquals(Color.WHITE, testCell3.getFill());
  }

}