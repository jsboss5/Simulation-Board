package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public class ConwayCell extends Cell {

  public static final String DEAD = "0";
  public static final String ALIVE = "1";

  public ConwayCell(String state, Neighborhood neighbors) {
    super(state, neighbors);
  }

  public boolean isAlive() {
    return this.getState().equals(ALIVE);
  }

  public boolean isDead() {
    return this.getState().equals(DEAD);
  }

//  public enum ConwayState implements CellState {
//    ALIVE("1"),
//    DEAD("0");
//
//    private final String state;
//
//    ConwayState(String inputState) {
//      this.state = inputState;
//    }
//
//    public static ConwayState fromValue(String state) {
//      for (ConwayState value : ConwayState.values()) {
//        if (state.equals(value.getState())) {
//          return value;
//        }
//      }
//      return DEAD;
//    }
//
//    public String getState() {
//      return state;
//    }
//  }

}
