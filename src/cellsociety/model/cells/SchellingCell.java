package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public class SchellingCell extends Cell {

  public static final String VACANT = "0";
  public static final String AGENT_X = "1";
  public static final String AGENT_O = "2";

  public SchellingCell(String state, Neighborhood neighbors) {
    super(state, neighbors);
  }

//  public enum SchellingCellState implements CellState {
//    VACANT("0"),
//    AGENT_X("1"),
//    AGENT_O("2");
//
//
//    private final String state;
//
//    SchellingCellState(String inputState) {
//      this.state = inputState;
//    }
//
//    public static SchellingCellState fromValue(String state) {
//      for (SchellingCellState value : SchellingCellState.values()) {
//        if (state.equals(value.getState())) {
//          return value;
//        }
//      }
//      return VACANT;
//    }
//
//    public String getState() {
//      return state;
//    }
//  }
//

}
