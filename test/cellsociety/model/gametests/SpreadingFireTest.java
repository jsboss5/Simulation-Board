package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.Simulation;
import cellsociety.model.games.SpreadingFire;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SpreadingFireTest {

  @Test
  public void SpreadingFire0ConfigTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire0.csv,set", "SpreadingFireCell", "Complete", "Finite", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","2","1","2","1","1","1","0"},
            {"0","1","1","1","2","0","2","1","1","1","0"},
            {"0","1","1","1","1","1","2","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire1ConfigTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire1.csv,set", "SpreadingFireCell", "Complete", "Finite", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","1","0","2","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire2ConfigTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire2.csv,set", "SpreadingFireCell", "Complete", "Finite", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","2","1","2","1","0"},
            {"0","1","1","1","1","1","2","0","2","1","0"},
            {"0","1","1","1","2","2","2","1","1","1","0"},
            {"0","1","1","0","1","0","2","1","1","1","0"},
            {"0","1","2","1","2","1","2","1","1","1","0"},
            {"0","1","1","1","1","1","1","1","1","1","0"},
            {"0","1","1","1","1","1","1","2","1","2","0"},
            {"0","1","1","1","1","1","1","2","0","2","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire3CardinalNeighborsTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire3.csv,set", "SpreadingFireCell", "Cardinal", "Finite", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"2","0","1","1","1","1","1","2","0","2","1"},
            {"1","2","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire3OrdinalNeighborsTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire3.csv,set", "SpreadingFireCell", "Ordinal", "Finite", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        { {"1","0","1","1","1","1","1","1","0","1","1"},
            {"2","1","1","1","1","1","1","2","1","2","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire3ToroidalEdgeTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire3.csv,set", "SpreadingFireCell", "Complete", "Toroidal", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        { {"2","0","1","1","1","1","1","2","0","2","1"},
            {"2","1","1","1","1","1","1","2","2","2","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","2","2","1"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void SpreadingFire4CrossSurfaceEdgeTest(){
    SpreadingFire spreadingFire = new SpreadingFire("board_config/spreadingfire4.csv,set", "SpreadingFireCell", "Complete", "CrossSurface", new String[]{"0","1", "2"});
    spreadingFire.setSeed(0);
    spreadingFire.nextGen();
    String[][] nextStates = spreadingFire.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        { {"0","0","0","0","0","0","0","0","0","0","0"},
            {"2","1","2","2","2","1","1","2","2","2","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","2"}
        };
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

}
