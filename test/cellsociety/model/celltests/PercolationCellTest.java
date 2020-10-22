package cellsociety.model.celltests;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.model.Neighborhood;
import cellsociety.model.cells.ConwayCell;
import cellsociety.model.cells.PercolationCell;
import org.junit.jupiter.api.Test;

public class PercolationCellTest {

  @Test
  public void isFullTest(){
    PercolationCell cell = new PercolationCell(PercolationCell.FULL, new Neighborhood());
    assertTrue(cell.isFull());
    assertFalse(cell.isOpen());
    assertFalse(cell.isClosed());
  }

  @Test
  public void isOpenTest(){
    PercolationCell cell = new PercolationCell(PercolationCell.OPEN, new Neighborhood());
    assertFalse(cell.isFull());
    assertTrue(cell.isOpen());
    assertFalse(cell.isClosed());
  }

  @Test
  public void isClosedTest(){
    PercolationCell cell = new PercolationCell(PercolationCell.CLOSED, new Neighborhood());
    assertFalse(cell.isFull());
    assertFalse(cell.isOpen());
    assertTrue(cell.isClosed());
  }

  @Test
  public void toStringTest(){
    ConwayCell cell = new ConwayCell(ConwayCell.DEAD, new Neighborhood());
    assertEquals(ConwayCell.DEAD, cell.toString());
  }

}
