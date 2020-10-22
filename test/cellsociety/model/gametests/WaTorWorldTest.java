package cellsociety.model.gametests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.model.games.WaTorWorld;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WaTorWorldTest {

  @Test
  public void wator0ConfigTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator0.csv,set", "WaTorCell", "Complete", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    wator.nextGen();
    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","2","0","0","0","0","0","0","0","0","0"},
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
  public void wator1ConfigTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator1.csv,set", "WaTorCell", "Complete", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    for (int i = 0; i < 100; i++){
      wator.nextGen();
    }
    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
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
  public void wator2ConfigTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator2.csv,set", "WaTorCell", "Complete", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    for (int i = 0; i < 13; i++){
      wator.nextGen();
    }
    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
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
  public void wator3ConfigTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator3.csv,set", "WaTorCell", "Complete", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    for (int i = 0; i < 50; i++){
      wator.nextGen();
    }
    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"},
            {"1","1","1","1","1","1","1","1","1","1","1"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void wator4CardinalNeighborTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator4.csv,set", "WaTorCell", "Cardinal", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    wator.nextGen();

    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","2","0","0","2","0","0","0"},
            {"2","2","0","0","0","2","2","0","0","2","2"},
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
  public void wator4OrdinalNeighborTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator4.csv,set", "WaTorCell", "Ordinal", "Finite", new String[]{"0","1", "2"});
    wator.setSeed(0);
    wator.nextGen();

    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","2","0","0","0","0","2","0","0"},
            {"0","2","2","0","0","0","2","2","0","2","2"},
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
  public void wator4ToroidalEdgeTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator4.csv,set", "WaTorCell", "Complete", "Toroidal", new String[]{"0","1", "2"});
    wator.setSeed(0);
    wator.nextGen();

    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","2","2"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","2","2","0","0","2","2","0","0","2"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }

  @Test
  public void wator4CrossSurfaceEdgeTest(){
    WaTorWorld wator = new WaTorWorld("board_config/wator4.csv,set", "WaTorCell", "Complete", "CrossSurface", new String[]{"0","1", "2"});
    wator.setSeed(0);
    wator.nextGen();

    String[][] nextStates = wator.getGameBoard().getGameBoardStates();
    String[][] correctNextStates =
        {{"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","2","0","0","0","2","2"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","0","0","0","0","0","0","0","0"},
            {"0","0","0","2","2","0","0","2","2","0","2"}};
    assertEquals(Arrays.deepToString(nextStates), Arrays.deepToString(correctNextStates));
  }




}
