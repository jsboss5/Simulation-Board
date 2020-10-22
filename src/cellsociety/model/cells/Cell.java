package cellsociety.model.cells;

import cellsociety.model.Neighborhood;

public abstract class Cell {

  // TODO: 2020-10-17 add interface for cell
  private String state;

  private Neighborhood neighbors;

  public Cell(String state, Neighborhood neighbors) {
    this.state = state;
    this.neighbors = neighbors;
  }

  public void setNeighbors(Neighborhood neighbors) {
    this.neighbors = neighbors;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Neighborhood getNeighborhood() {
    return this.neighbors;
  }

  public String toString() {
    return this.getState();
  }

}
