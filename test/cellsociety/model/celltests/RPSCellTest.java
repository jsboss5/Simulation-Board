package cellsociety.model.celltests;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.model.Neighborhood;
import cellsociety.model.cells.RPSCell;
import org.junit.jupiter.api.Test;

public class RPSCellTest {

  @Test
  public void isRockTest(){
    RPSCell cell = new RPSCell(RPSCell.ROCK, new Neighborhood());
    assertTrue(cell.isRock());
    assertFalse(cell.isPaper());
    assertFalse(cell.isScissors());
  }

  @Test
  public void isPaperTest(){
    RPSCell cell = new RPSCell(RPSCell.PAPER, new Neighborhood());
    assertTrue(cell.isPaper());
    assertFalse(cell.isScissors());
    assertFalse(cell.isRock());
  }
  @Test
  public void isScissorsTest(){
    RPSCell cell = new RPSCell(RPSCell.SCISSORS, new Neighborhood());
    assertTrue(cell.isScissors());
    assertFalse(cell.isRock());
    assertFalse(cell.isRock());
  }

}
