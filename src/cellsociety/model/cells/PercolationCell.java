package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public class PercolationCell extends Cell {

  public static final String CLOSED = "0";
  public static final String OPEN = "1";
  public static final String FULL = "2";

  public PercolationCell(String state, Neighborhood neighbors) {
    super(state, neighbors);
  }

  public boolean isOpen() {
    return this.getState().equals(OPEN);
  }

  public boolean isClosed() {
    return this.getState().equals(CLOSED);
  }

  public boolean isFull() {
    return this.getState().equals(FULL);
  }
//
//  public enum PercolationState implements CellState {
//    CLOSED("0"),
//    OPEN("1"),
//    FULL("2");
//
//
//    private final String state;
//
//    PercolationState(String inputState) {
//      this.state = inputState;
//    }
//
//    public static PercolationState fromValue(String state) {
//      for (PercolationState value : PercolationState.values()) {
//        if (state.equals(value.getState())) {
//          return value;
//        }
//      }
//      return CLOSED;
//    }
//
//    public String getState() {
//      return state;
//    }
//  }


}
