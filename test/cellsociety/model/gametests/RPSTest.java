package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.RPS;
import cellsociety.model.games.Simulation;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RPSTest {

  @Test
  public void RPS0ConfigTest(){
    Simulation rps = new RPS("board_config/rps0.csv,set", "RPSCell", "Complete", "Finite", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
           {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","1","1","0","0"},
            {"0","0","0","0","0","0","0","1","1","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","2","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void RPS1ConfigTest(){
    Simulation rps = new RPS("board_config/rps1.csv,set", "RPSCell", "Complete", "Finite", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
          {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","1","1","0","0","0","0","0"},
            {"0","0","0","0","1","1","0","0","0","0","0"},
            {"0","0","0","0","1","1","0","0","0","0","0"},
            {"0","0","0","0","1","1","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void RPS2ConfigTest(){
    Simulation rps = new RPS("board_config/rps2.csv,set", "RPSCell", "Complete", "Finite", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
          {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
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
  public void RPS0CardinalNeighborTest(){
    Simulation rps = new RPS("board_config/rps0.csv,set", "RPSCell", "Cardinal", "Finite", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","1","1","0","0"},
            {"0","0","0","0","0","0","0","1","0","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","2","2","2","0","0","0","0","0","0"},
            {"0","0","0","1","2","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void RPS0OrdinalNeighborTest(){
    Simulation rps = new RPS("board_config/rps0.csv,set", "RPSCell", "Ordinal", "Finite", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","1","1","0","0"},
            {"0","0","0","0","0","0","0","1","0","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","2","2","2","0","0","0","0","0","0"},
            {"0","0","0","1","2","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void RPS3ToroidalEdgeTest(){
    Simulation rps = new RPS("board_config/rps3.csv,set", "RPSCell", "Complete", "Toroidal", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"1","1","1","1","1","1","1","1","1","1","1"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"2","2","2","2","2","2","2","2","2","2","2"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void RPS3CrossSurfaceEdgeTest(){
    Simulation rps = new RPS("board_config/rps3.csv,set", "RPSCell", "Complete", "CrossSurface", new String[]{"0","1", "2"});
    rps.nextGen();
    String[][] nextStates = rps.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"1","1","1","1","1","1","1","1","1","1","1"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"2","2","2","2","2","2","2","2","2","2","2"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

}
