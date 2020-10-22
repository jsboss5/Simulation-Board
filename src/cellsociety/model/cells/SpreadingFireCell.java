package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public class SpreadingFireCell extends Cell {

  public static final String EMPTY = "0";
  public static final String TREE = "1";
  public static final String BURNING = "2";

  public SpreadingFireCell(String state, Neighborhood neighbors) {
    super(state, neighbors);
  }

  public boolean isBurning() {
    return getState().equals(BURNING);
  }

  public boolean isEmpty() {
    return getState().equals(EMPTY);
  }

  public boolean isTree() {
    return getState().equals(TREE);
  }

//  public enum SpreadingFireState implements CellState {
//    EMPTY("0"),
//    TREE("1"),
//    BURNING("2");
//
//
//    private final String state;
//
//    SpreadingFireState(String inputState) {
//      this.state = inputState;
//    }
//
//    public static SpreadingFireState fromValue(String state) {
//      for (SpreadingFireState value : SpreadingFireState.values()) {
//        if (state.equals(value.getState())) {
//          return value;
//        }
//      }
//      return EMPTY;
//    }
//
//    public String getState() {
//      return state;
//    }
//  }
//

}
