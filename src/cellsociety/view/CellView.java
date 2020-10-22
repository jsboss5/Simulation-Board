package cellsociety.view;

import java.util.Properties;
import javafx.scene.Node;


public interface CellView {

  void updateView(String state, Properties properties);

  void handleClick();

  Node getCell();
}
