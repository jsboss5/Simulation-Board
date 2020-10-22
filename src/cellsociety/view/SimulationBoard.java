package cellsociety.view;

import cellsociety.controller.Controller;
import cellsociety.model.GameBoard;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SimulationBoard {

  // TODO: 2020-10-10 make this CSS
  public static final double CELL_GRID_WIDTH = 600;
  public static final double CELL_GRID_HEIGHT = 350;

  private final GridPane myGrid = new GridPane();
  private final List<List<CellView>> cells = new ArrayList<>();

  private Controller controller;

  public SimulationBoard(Group root) {
    myGrid.setLayoutX(75);
    myGrid.setLayoutY(75);
    myGrid.setGridLinesVisible(true);
    root.getChildren().add(myGrid);
  }

  public void setUpNewSimulation(Controller controller) {
    this.controller = controller;
    setGridType("Rectangle");
  }

  //works for non square 2D arrays
  // TODO: 2020-10-04 ask about X position for tests
  public void setGridType(String cellType) {
    clear();
    String[][] states = controller.getGameBoard().getGameBoardStates();
    double width = CELL_GRID_WIDTH / maxRowLength(states);
    for (int i = 0; i < states.length; i++) {
      cells.add(new ArrayList<>());
      for (int j = 0; j < states[i].length; j++) {
        addCellToGrid(
            chooseCellType(cellType, width, CELL_GRID_HEIGHT / states.length, states[i][j],
                controller.getProperties()), i, j);
      }
    }
  }

  public void updateMyGrid(GameBoard gameBoard, Properties properties) {

    // TODO: 2020-10-19 change the name of this metod
    gameBoard
        .enactFunctionOnStates((i, j, state) -> cells.get(i).get(j).updateView(state, properties));
  }

  private void clear() {
    myGrid.getChildren().clear();
    cells.clear();
  }

  private void addCellToGrid(CellView cellView, int i, int j) {
    addEventListener(cellView, i, j);
    Node cell = cellView.getCell();
    cell.setId(String.format("cell%d,%d", i, j));
    GridPane.setConstraints(cell, j, i);
    myGrid.getChildren().add(cell);
    cells.get(i).add(cellView);
  }

  private void addEventListener(CellView cellView, int row, int col) {
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {
        controller.handleCellClick(row, col);
        updateMyGrid(controller.getGameBoard(), controller.getProperties());
      }
    };
    cellView.getCell().addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
  }


  private int maxRowLength(String[][] array) {
    int maxRowLength = 0;
    for (String[] row : array) {
      if (row.length > maxRowLength) {
        maxRowLength = row.length;
      }
    }
    return maxRowLength;
  }

  private CellView chooseCellType(String cellType, double width, double height, String state,
      Properties properties) {
    Class operation;
    CellView cell = null;
    try {
      operation = Class.forName("cellsociety.view." + cellType + "CellView");
      cell = (CellView) operation
          .getConstructor(double.class, double.class, String.class, Properties.class)
          .newInstance(width, height, state, properties);
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      // TODO: 2020-10-12 handle this error
      e.printStackTrace();
    }
    return cell;
  }
}
