package cellsociety.view.ButtonSetups;

import cellsociety.view.Display;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public abstract class ButtonSetup {


  public List<String> parseButtonsFromProperties(int NUMBER_POSSIBLE_BUTTONS,
      Properties myProperties) {
    List<String> buttonNameList = new ArrayList<>();
    for (int buttonNum = 1; buttonNum <= NUMBER_POSSIBLE_BUTTONS; buttonNum++) {
      if (!(myProperties.get("Button" + buttonNum)).equals("")) {
        buttonNameList.add((String) myProperties.get("Button" + buttonNum));
      }
    }
    return buttonNameList;
  }

  public void buttonPipeline(List<String> buttonNames, Group root, String cssClass,
      double yOffset, Properties languageProperties) {
    List<Button> buttonList = new ArrayList<>();
    HBox myHbox = createHBox(cssClass, yOffset);
    for (String buttonName : buttonNames) {
      //TODO - get the button name from the text resources file
      Button currentButton = makeButton(languageProperties.getProperty(buttonName));
      buttonList.add(currentButton);
      myHbox.getChildren().add(currentButton);
      invokeHandlerMethod(buttonName, currentButton, languageProperties);
    }
    root.getChildren().add(myHbox);
  }

  public Button makeButton(String buttonName) {
    Button currentButton = new Button(buttonName);
    currentButton.setId(buttonName);
    return currentButton;
  }

  public HBox createHBox(String cssClass, double yOffsetFactor) {
    HBox buttonBox = new HBox();
    buttonBox.setPrefWidth(Display.WIDTH);
    buttonBox.setPrefHeight(Display.HEIGHT / 4);
    buttonBox.getStyleClass().add(cssClass);
    buttonBox.setLayoutY(Display.HEIGHT * yOffsetFactor);

    return buttonBox;
  }

  protected abstract void invokeHandlerMethod(String buttonName, Button currentButton,
      Properties languageProperties);


}
