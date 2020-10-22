package cellsociety.view;

import cellsociety.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class StateColorPicker {

  private final HBox colorPickerBox;

  public StateColorPicker(VBox stateConfigBox) {
    colorPickerBox = new HBox();
    colorPickerBox.getStyleClass().add("color-picker-box");
    stateConfigBox.getChildren().add(colorPickerBox);
  }

  private void addColorPicker(String state, Controller controller) {
    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setValue(Color.valueOf(controller.getProperties().getProperty(state)));
    colorPicker.setId(String.format("%scolor", state));
    colorPickerBox.getChildren().add(colorPicker);
    colorPicker.setOnAction((ActionEvent t) -> {
      controller.getProperties().setProperty(state, String.valueOf(colorPicker.getValue()));
      controller.overWriteProperties();
    });
  }

  public void addColorPickers(Controller controller) {
    colorPickerBox.getChildren().clear();
    for (String state : controller.getProperties().getProperty("States").split(",")) {
      addColorPicker(state, controller);
    }
  }
}
