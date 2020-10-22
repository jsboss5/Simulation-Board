package cellsociety.view.ButtonSetups;

import cellsociety.view.Display;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class SplashScreenSetup extends ButtonSetup {

  private final Display myDisplay;

  public SplashScreenSetup(Display display) {
    myDisplay = display;
  }


  @Override
  protected void invokeHandlerMethod(String buttonName, Button currentButton,
      Properties languageProperties) {
    currentButton.setOnAction(new SimulationChooserHandler(buttonName, languageProperties));
  }

  class SimulationChooserHandler implements EventHandler<ActionEvent> {

    private final String simulationName;
    private final Properties languageProperties;

    SimulationChooserHandler(String simulationName, Properties languageProperties) {
      this.simulationName = simulationName;
      this.languageProperties = languageProperties;
    }

    @Override
    public void handle(ActionEvent event) {
      myDisplay.chooseSimulation(simulationName, languageProperties);
    }
  }


}

