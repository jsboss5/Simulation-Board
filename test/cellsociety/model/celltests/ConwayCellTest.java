package cellsociety.model.celltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cellsociety.model.Neighborhood;
import cellsociety.model.cells.ConwayCell;
import org.junit.jupiter.api.Test;

public class ConwayCellTest {

  @Test
  public void isAliveTest() {
    ConwayCell cell = new ConwayCell(ConwayCell.ALIVE, new Neighborhood());
    assertTrue(cell.isAlive());
    assertFalse(cell.isDead());
  }

  @Test
  public void isDeadTest() {
    ConwayCell cell = new ConwayCell(ConwayCell.DEAD, new Neighborhood());
    assertTrue(cell.isDead());
    assertFalse(cell.isAlive());
  }

  @Test
  public void toStringTest() {
    ConwayCell cell = new ConwayCell(ConwayCell.DEAD, new Neighborhood());
    assertEquals(ConwayCell.DEAD, cell.toString());
  }

}
