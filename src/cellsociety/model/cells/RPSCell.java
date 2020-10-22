package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public class RPSCell extends Cell {

  public static final String ROCK = "0";
  public static final String PAPER = "1";
  public static final String SCISSORS = "2";

  public RPSCell(String state, Neighborhood neighbors) {
    super(state, neighbors);
  }

  public boolean isRock() {
    return getState().equals(ROCK);
  }

  public boolean isPaper() {
    return getState().equals(PAPER);
  }

  public boolean isScissors() {
    return getState().equals(SCISSORS);
  }

//  public enum RPSState implements CellState {
//    ROCK("0"),
//    PAPER("1"),
//    SCISSORS("2");
//
//
//    private final String state;
//
//    RPSState(String inputState) {
//      this.state = inputState;
//    }
//
//    public static RPSState fromValue(String state) {
//      for (RPSState value : RPSState.values()) {
//        if (state.equals(value.getState())) {
//          return value;
//        }
//      }
//      return ROCK;
//    }
//
//    public String getState() {
//      return state;
//    }
//  }


}
