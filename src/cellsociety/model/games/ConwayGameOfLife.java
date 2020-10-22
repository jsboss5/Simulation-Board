package cellsociety.model.games;


import cellsociety.model.GameBoard;
import cellsociety.model.cells.ConwayCell;
import java.util.List;

public class ConwayGameOfLife extends Simulation {

  public final int ALIVE_THRESHOLD = 3;
  public final int DEAD_THRESHOLD = 2;

  public ConwayGameOfLife(String csvConfig, String cellType, String neighborPolicy,
      String edgePolicy, String[] possibleStates) {
    super(csvConfig, cellType, neighborPolicy, edgePolicy, possibleStates);
  }

  public boolean aliveNextGen(int row, int col) {
    if (isAlive(row, col)) {
      return countLivingNeighbors(row, col) >= DEAD_THRESHOLD
          && countLivingNeighbors(row, col) <= ALIVE_THRESHOLD;
    }
    return countLivingNeighbors(row, col) == ALIVE_THRESHOLD;
  }

  public boolean isAlive(int row, int col) {
    return getGameBoard().getCell(row, col).getState().equals(ConwayCell.ALIVE);
  }

  @Override
  public void updateCell(GameBoard nextBoard, int row, int col) {
    if (aliveNextGen(row, col)) {
      nextBoard.setPiece(row, col, ConwayCell.ALIVE);
    } else {
      nextBoard.setPiece(row, col, ConwayCell.DEAD);
    }
  }

  public int countLivingNeighbors(int row, int col) {
    int aliveCount = 0;

    List<List<Integer>> neighbors = getGameBoard().getCell(row, col).getNeighborhood()
        .getNeighbors();
    for (List<Integer> neighbor : neighbors) {
      if (isAlive(neighbor.get(0), neighbor.get(1))) {
        aliveCount++;
      }
    }
    return aliveCount;
  }
}