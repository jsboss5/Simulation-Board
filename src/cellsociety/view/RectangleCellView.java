package cellsociety.view;

import java.util.Properties;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleCellView extends Group implements CellView {

  String state;
  Rectangle rectangle;

  public RectangleCellView(double width, double height, String state, Properties properties) {
    rectangle = new Rectangle(width, height);
    setState(state);
    this.getChildren().add(rectangle);
    rectangle.setStroke(Color.BLACK);
    updateView(state, properties);
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void updateView(String state, Properties properties) {
    // TODO: 2020-10-10 better error handling
    if (properties.getProperty(state) == null) {
      rectangle.setFill(Color.WHITE);
    } else {
      rectangle.setFill(Color.web(properties.getProperty(state)));
    }
  }

  @Override
  public void handleClick() {
    rectangle.setFill(Color.PURPLE);
  }

  @Override
  public Node getCell() {
    return rectangle;
  }


}

