package cellsociety.model.games;

import cellsociety.model.GameBoard;
import cellsociety.model.cells.SpreadingFireCell;
import java.util.List;
import java.util.Random;

public class SpreadingFire extends Simulation {

  public static final double probCatch = 0.5;
  public Random rand;


  public SpreadingFire(String csvConfig, String cellType, String neighborPolicy, String edgePolicy,
      String[] possibleStates) {
    super(csvConfig, cellType, neighborPolicy, edgePolicy, possibleStates);
    rand = new Random();
  }

  @Override
  public void updateCell(GameBoard gameBoard, int row, int col) {
    if (isBurning(row, col)) {
      gameBoard.setPiece(row, col, SpreadingFireCell.EMPTY);
    } else if (burningNextGen(row, col)) {
      gameBoard.setPiece(row, col, SpreadingFireCell.BURNING);
    } else {
      gameBoard.setPiece(row, col, getGameBoard().getState(row, col));
    }
  }

  public boolean isBurning(int row, int col) { //TODO: Move to cell
    return getGameBoard().getCell(row, col).getState().equals(SpreadingFireCell.BURNING);
  }

  public boolean isEmpty(int row, int col) { //TODO: Move to cell
    return getGameBoard().getCell(row, col).getState().equals(SpreadingFireCell.EMPTY);
  }

  public boolean burningNextGen(int currentRow, int currentColumn) {

    List<List<Integer>> neighbors = getGameBoard().getCell(currentRow, currentColumn)
        .getNeighborhood().getNeighbors();
    for (List<Integer> neighbor : neighbors) {
      if (isBurning(neighbor.get(0), neighbor.get(1)) && !isEmpty(currentRow, currentColumn)) {
        double probability = rand.nextDouble();
        return probability > probCatch;
      }
    }
    return false;
  }

  public void setSeed(long seed) {
    rand.setSeed(seed);
  }

}
