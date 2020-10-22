package cellsociety.model.games;

import cellsociety.model.GameBoard;
import java.util.List;

public class RPS extends Simulation {

  public static final int THRESHOLD = 3;

  public RPS(String csvConfig, String cellType, String neighborPolicy, String edgePolicy,
      String[] possibleStates) {
    super(csvConfig, cellType, neighborPolicy, edgePolicy, possibleStates);
  }

  @Override
  public void updateCell(GameBoard gameBoard, int row, int col) {
    if (isDefeated(row, col)) {
      gameBoard.setPiece(row, col, getOpponent(row, col));
    } else {
      gameBoard.setPiece(row, col, getGameBoard().getState(row, col));
    }
  }

  private boolean isDefeated(int row, int col) {
    return countNeighboringOpponents(row, col) > THRESHOLD;
  }

  public String getOpponent(int row, int col) {
    int state = Integer.parseInt(getGameBoard().getCell(row, col).getState());
    return Integer.toString((state + 1) % getPossibleStates().length);
  }

  public int countNeighboringOpponents(int row, int col) {
    int opponentCount = 0;
    List<List<Integer>> neighbors = getGameBoard().getCell(row, col).getNeighborhood()
        .getNeighbors();
    for (List<Integer> neighbor : neighbors) {
      if (isOpponent(neighbor.get(0), neighbor.get(1), row, col)) {
        opponentCount++;
      }
    }
    return opponentCount;
  }

  public boolean isOpponent(int x, int y, int currentRow, int currentColumn) {
    String currentState = getGameBoard().getCell(x, y).getState();
    String opponentState = getOpponent(currentRow, currentColumn);
    return currentState.equals(opponentState);
  }
}
