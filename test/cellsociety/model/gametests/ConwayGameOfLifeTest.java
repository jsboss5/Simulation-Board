package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.ConwayGameOfLife;
import cellsociety.model.games.Simulation;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ConwayGameOfLifeTest {



  @Test
  public void conway0ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway0.csv,set",  "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    String[][] currentStates = conway.getGameBoard().getGameBoardStates();
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    assertEquals(Arrays.deepToString(currentStates), Arrays.deepToString(nextStates));
  }

  @Test
  public void conway1ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway1.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway2ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway2.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway3ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway3.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway4ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway4.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }


  @Test
  public void conway5ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway5.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway6ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway6.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"1", "1", "0", "0", "0", "0", "0", "0", "0", "1", "1"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway7ConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway7.csv,set", "ConwayCell", "Complete", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway0CardinalNeighborConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway0.csv,set", "ConwayCell", "Cardinal", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway0OrdinalNeighborConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway0.csv,set", "ConwayCell", "Ordinal", "Finite", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway7ToroidalEdgeConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway7.csv,set", "ConwayCell", "Complete", "Toroidal", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void conway7CrossSurfaceEdgeConfigTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway7.csv,set", "ConwayCell", "Complete", "CrossSurface", new String[]{"0","1"});
    conway.nextGen();
    String[][] nextStates = conway.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void getGraphCountsTest() {
    Simulation conway = new ConwayGameOfLife("board_config/conway2.csv,set", "ConwayCell",
        "Complete", "Finite", new String[]{"0", "1"});
    assertEquals(conway.getGraphCounts(), new ArrayList<>(){{add(115); add (6);}});
  }

}
