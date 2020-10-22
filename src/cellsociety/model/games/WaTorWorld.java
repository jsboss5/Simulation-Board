package cellsociety.model.games;

import cellsociety.model.GameBoard;
import cellsociety.model.Neighborhood;
import cellsociety.model.cells.WaTorCell;
import java.util.List;
import java.util.Random;

public class WaTorWorld extends Simulation {

  private static final int DEAD_ENERGY = 0;
  public final int REPRODUCTION_TIME = 5;

  private final Random rand;

  public WaTorWorld(String config, String cellType, String neighborPolicy, String edgePolicy,
      String[] possibleStates) {
    super(config, cellType, neighborPolicy, edgePolicy, possibleStates);
    rand = new Random();
  }


  @Override
  public void updateCell(GameBoard gameBoard, int row, int col) {
    WaTorCell currentCell = (WaTorCell) (getGameBoard().getCell(row, col));
    if (!isOcean(row, col)) {
      gameBoard.copyCell(row, col, currentCell);
    }
    if (currentCell.isShark()) {
      sharkMovement(gameBoard, row, col);
    } else if (currentCell.isFish()) {
      fishMovement(gameBoard, row, col);
    }
  }


  public boolean isOcean(int row, int col) {
    return getGameBoard().getState(row, col).equals(WaTorCell.OCEAN);
  }

  public void fishMovement(GameBoard gameBoard, int row, int col) {
    moveToOcean(gameBoard, row, col);
  }

  public void moveToOcean(GameBoard gameBoard, int row, int col) {
    List<List<Integer>> neighboringOcean = getGameBoard()
        .getNeighboringPositionsOfCellState(WaTorCell.OCEAN, row, col);
    if (!neighboringOcean.isEmpty()) {
      List<Integer> oceanCoordinates = getDestinationCoordinates(neighboringOcean);
      int fishRow = oceanCoordinates.get(0);
      int fishCol = oceanCoordinates.get(1);
      gameBoard.swapCells(row, col, fishRow, fishCol);
      WaTorCell movedCell = (WaTorCell) (gameBoard.getCell(fishRow, fishCol));
      movedCell.incrementSurvivalTime();
      movedCell.decrementEnergy();
      checkFishReproduction(gameBoard, row, col, movedCell);
      checkSharkDeath(gameBoard, oceanCoordinates, movedCell);
    }
  }

  private List<Integer> getDestinationCoordinates(List<List<Integer>> neighboringOcean) {
    int oceanIndex = rand.nextInt(neighboringOcean.size());
    return neighboringOcean.get(oceanIndex);
  }

  private void checkSharkDeath(GameBoard gameBoard, List<Integer> oceanCoordinates,
      WaTorCell movedCell) {
    int fishRow = oceanCoordinates.get(0);
    int fishCol = oceanCoordinates.get(1);
    if (movedCell.isShark() && movedCell.getEnergyPoints() <= DEAD_ENERGY) {
      gameBoard.copyCell(fishRow, fishCol, new WaTorCell(WaTorCell.OCEAN,
          new Neighborhood(fishRow, fishCol, getGameBoard(),
              getNeighborPolicy(), getEdgePolicy())));
    }
  }

  private void checkFishReproduction(GameBoard gameBoard, int row, int col, WaTorCell movedCell) {
    if (movedCell.isFish() && movedCell.getSurvivalTime() >= REPRODUCTION_TIME) {
      gameBoard.copyCell(row, col, new WaTorCell(WaTorCell.FISH,
          new Neighborhood(row, col, getGameBoard(), getNeighborPolicy(), getEdgePolicy())));
      movedCell.resetSurvivalTime();
    }
  }

  public void eatFish(GameBoard gameBoard, int row, int col) {
    List<List<Integer>> neighboringFish = getGameBoard()
        .getNeighboringPositionsOfCellState(WaTorCell.FISH, row, col);
    if (!neighboringFish.isEmpty()) {
      List<Integer> fishCoordinates = getDestinationCoordinates(neighboringFish);
      int fishRow = fishCoordinates.get(0);
      int fishCol = fishCoordinates.get(1);
      gameBoard.swapCells(row, col, fishRow, fishCol);
      getGameBoard().copyCell(fishRow, fishCol, new WaTorCell(WaTorCell.OCEAN,
          new Neighborhood(fishRow, fishCol, getGameBoard(), getNeighborPolicy(),
              getEdgePolicy())));
      WaTorCell movedShark = (WaTorCell) (gameBoard.getCell(fishRow, fishCol));
      if (row > fishRow || col > fishCol) {
        movedShark.decrementEnergy();
      }
      movedShark.incrementSurvivalTime();
    }
  }

  public void sharkMovement(GameBoard gameBoard, int row, int col) {
    List<List<Integer>> neighboringFish = getGameBoard()
        .getNeighboringPositionsOfCellState(WaTorCell.FISH, row, col);
    if (!neighboringFish.isEmpty()) {
      eatFish(gameBoard, row, col);
    } else {
      moveToOcean(gameBoard, row, col);
    }
  }

  public void setSeed(long seed) {
    rand.setSeed(seed);
  }
}
