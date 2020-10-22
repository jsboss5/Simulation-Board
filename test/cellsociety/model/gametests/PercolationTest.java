package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.Percolation;
import cellsociety.model.games.Simulation;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PercolationTest {

  @Test
  public void percolation0ConfigTest(){
    Simulation percolation = new Percolation("board_config/percolation0.csv,set", "PercolationCell", "Complete", "Finite", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
          {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation1ConfigTest(){
    Simulation percolation = new Percolation("board_config/percolation1.csv,set", "PercolationCell", "Complete", "Finite", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
          {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","2","2","2","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation2ConfigTest(){
    Simulation percolation = new Percolation("board_config/percolation2.csv,set", "PercolationCell", "Complete", "Finite", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation1CardinalNeighborTest(){
    Simulation percolation = new Percolation("board_config/percolation1.csv,set", "PercolationCell", "Cardinal", "Finite", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","1","2","1","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation1OrdinalNeighborTest(){
    Simulation percolation = new Percolation("board_config/percolation1.csv,set", "PercolationCell", "Ordinal", "Finite", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","2","1","2","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation0ToroidalEdgeTest(){
    Simulation percolation = new Percolation("board_config/percolation0.csv,set", "PercolationCell", "Complete", "Toroidal", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void percolation0CrossSurfaceEdgeTest(){
    Simulation percolation = new Percolation("board_config/percolation0.csv,set", "PercolationCell", "Complete", "CrossSurface", new String[]{"0","1", "2"});
    percolation.nextGen();
    String[][] nextStates = percolation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"},
            {"0","0","0","0","0","1","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }



}
