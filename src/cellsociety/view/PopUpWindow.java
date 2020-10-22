package cellsociety.view;

import cellsociety.model.GameBoard;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PopUpWindow {

  // TODO: 2020-10-19 this needs to be in side of text properties
  private static final String HEADER_TITLE = "Fill Out Required Information";
  private static final String DIALOG_TITLE = "Save Current Simulation State";
  private static final String BUTTON_TITLE = "Save";

  private static final String TITLE = "Title";
  private static final String AUTHOR = "Author";
  private static final String DESCRIPTION = "Description";

  private final GameBoard myGameBoard;
  private final Properties properties;
  private final Properties languageProperties;
  private final String pupTitle;
  private final String pupAuthor;
  private final String pupDescription;
  private GridPane myGrid;


  public PopUpWindow(Display display, GameBoard gameBoard, Properties textProperties) {
    myGameBoard = gameBoard;
    properties = display.getController().getProperties();
    languageProperties = textProperties;

    pupTitle = languageProperties.getProperty("pupTitleField");
    pupAuthor = languageProperties.getProperty("pupAuthorField");
    pupDescription = languageProperties.getProperty("pupDescriptionField");

    Dialog<String[]> dialog = createDialog();
    createGridPane();

    TextField title = createTextFeild(pupTitle);
    TextField author = createTextFeild(pupAuthor);
    TextField description = createTextFeild(pupDescription);

    addToGrid(title, pupTitle, 0);
    addToGrid(author, pupAuthor, 1);
    addToGrid(description, pupDescription, 2);

    dialog.getDialogPane().setContent(myGrid);
    //Optional<ButtonType> result = dialog.getButtonType().showAndWait();

    dialog.setResultConverter(dialogButton -> {
      String[] retArray = new String[]{title.getText(), author.getText(), description.getText()};
      System.out.println(retArray[0]);
      storeInPropertiesFile(retArray);
      return retArray;
    });

    dialog.show();
  }

  private void createGridPane() {
    //found this ish online
    myGrid = new GridPane();
    myGrid.setId("popupWindow");
    myGrid.setHgap(10);
    myGrid.setVgap(10);
    myGrid.setPadding(new Insets(20, 150, 10, 10));
  }

  private void addToGrid(TextField title, String title2, int row) {
    myGrid.add(new Label(title2 + ":"), 0, row);
    myGrid.add(title, 1, row);
  }

  private TextField createTextFeild(String fieldText) {
    TextField title = new TextField();
    title.setPromptText(fieldText);
    return title;
  }

  private Dialog<String[]> createDialog() {
    Dialog<String[]> dialog = new Dialog<>();
    dialog.setTitle(languageProperties.getProperty("pupDialogTitle"));
    dialog.setHeaderText(languageProperties.getProperty("pupHeaderTitle"));
    ButtonType save = new ButtonType(languageProperties.getProperty("pupButtonTitle"));
    dialog.getDialogPane().getButtonTypes().add(save);
    return dialog;
  }

  public void storeInPropertiesFile(String[] inputs) {
    try {
      properties.setProperty(pupTitle, inputs[0]);
      properties.setProperty(pupAuthor, inputs[1]);
      properties.setProperty(pupDescription, inputs[2]);

      SaveFiles saveFileObject = new SaveFiles();
      saveFileObject.saveState(myGameBoard, inputs[0]);

      properties.setProperty("CSVSource", "GAME_CSVS/" + inputs[0] + ".csv,set");
      properties
          .store(new FileOutputStream("resources/Properties_Files/" + inputs[0] + ".properties"),
              null);

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
