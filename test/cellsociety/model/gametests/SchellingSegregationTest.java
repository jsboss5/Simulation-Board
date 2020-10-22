package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.SchellingSegregation;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SchellingSegregationTest {

  @Test
  public void segregation0ConfigTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation0.csv,set", "SchellingCell", "Complete", "Finite", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
          {{"0","0","2","2","1","0","1","0","2","1","0"},
            {"2","2","2","0","1","2","1","0","2","2","0"},
            {"2","1","0","0","1","0","2","0","0","0","0"},
            {"1","0","0","1","0","1","0","0","2","2","2"},
            {"0","0","2","2","2","0","1","0","0","0","0"},
            {"2","0","0","0","0","0","0","0","0","0","2"},
            {"2","2","0","1","1","1","0","0","0","0","0"},
            {"0","0","1","0","0","0","0","1","1","1","0"},
            {"0","1","1","1","0","2","0","2","0","0","2"},
            {"0","1","1","1","2","2","2","2","2","1","1"},
            {"0","0","1","2","0","0","0","0","0","1","2"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation1ConfigTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation1.csv,set", "SchellingCell", "Complete", "Finite", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"2","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","0","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation2ConfigTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation2.csv,set", "SchellingCell", "Complete", "Finite", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","1","1","0","0","2","2"},
            {"1","0","0","0","0","0","1","0","2","0","0"},
            {"0","1","1","0","2","2","0","2","2","2","1"},
            {"2","2","1","0","0","0","0","1","2","2","1"},
            {"2","2","1","1","1","0","2","1","0","0","0"},
            {"2","2","1","1","1","1","2","1","1","2","0"},
            {"2","2","0","1","2","2","0","2","0","2","2"},
            {"2","0","1","0","2","0","1","1","0","2","1"},
            {"0","1","0","2","1","2","0","1","2","0","1"},
            {"2","2","1","1","1","1","0","0","2","1","1"},
            {"0","1","0","1","1","1","2","2","2","2","2"}};

    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation2CardinalNeighborTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation2.csv,set", "SchellingCell", "Cardinal", "Finite", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","2","0","0","1","2","2","0","0","0","0"},
            {"0","2","0","2","1","0","0","0","2","0","0"},
            {"0","2","1","0","0","0","1","2","2","1","1"},
            {"2","1","1","1","0","2","2","1","2","1","2"},
            {"2","2","1","1","1","0","0","2","2","1","0"},
            {"2","2","1","1","1","2","2","0","0","1","0"},
            {"0","2","0","0","1","2","0","1","0","2","1"},
            {"2","0","1","0","2","1","0","0","2","1","1"},
            {"0","1","2","0","2","0","0","1","2","0","1"},
            {"2","1","1","1","1","2","0","0","2","2","1"},
            {"2","1","0","1","1","1","2","2","2","1","2"}};

    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation3OrdinalNeighborTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation3.csv,set", "SchellingCell", "Ordinal", "Finite", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","0","2","0","0","0","0","0","0"},
            {"0","1","1","2","0","0","0","0","0","0","0"},
            {"0","0","0","1","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","2","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},};

    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation3ToroidalEdgeTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation3.csv,set", "SchellingCell", "Complete", "Toroidal", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","0","2","0","0","0","0","0","0"},
            {"0","1","1","0","2","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","2","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","1","0","0"},};

    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void segregation3CrossSurfaceEdgeTest(){
    SchellingSegregation segregation = new SchellingSegregation("board_config/segregation3.csv,set", "SchellingCell", "Complete", "CrossSurface", new String[]{"0","1", "2"});
    segregation.setSeed(0);
    segregation.nextGen();
    String[][] nextStates = segregation.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","0","2","0","0","0","0","0","0"},
            {"0","1","1","0","2","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","2","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","1","0","0"},};

    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }



}
