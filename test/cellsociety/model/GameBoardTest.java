package cellsociety.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exceptions.InvalidCSVFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameBoardTest {

  private GameBoard board;

  @BeforeEach
  void init() {
    board = new GameBoard(5, 5, "ConwayCell", "complete", "finite");
  }


  @Test
  public void inBoundsTest() {
    assertTrue(board.inBounds(4, 4));
    assertTrue(board.inBounds(1, 3));
    assertTrue(board.inBounds(0, 0));
    assertFalse(board.inBounds(-1, 4));
    assertFalse(board.inBounds(5, 4));
    assertFalse(board.inBounds(0, 10));
  }

  @Test
  void invalidCSVStateThrowsException(){
    String[][] initialStates = {{"0","1"},{"1","2"}};
    assertThrows(InvalidCSVFormatException.class,() -> new GameBoard(initialStates, "ConwayCell", "complete", "finite", new String[]{"0", "1"}));
  }

}