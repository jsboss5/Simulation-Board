package cellsociety.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomStateReaderTest {

  RandomStateReader RandomStateReader = new RandomStateReader();
  @Test
  void validateGridSize() {
    String[][] test = RandomStateReader.getStatesFromFile("board_config/randomConway0.csv");
    assertEquals(11, test.length);
    assertEquals(10, test[0].length);
  }

  @Test
  void test0Probability() {
    String[][] test = RandomStateReader.getStatesFromFile("board_config/randomConway0.csv");
    for(int i = 0; i < test.length; i++){
      for(int j = 0; j < test[i].length; j++){
        assertEquals("0", test[i][j]);
      }
    }
  }

  @Test
  void testProbability() {
    String[][] test = RandomStateReader.getStatesFromFile("board_config/randomConway1.csv");
    String[] expected = {"0","0","0","1","0","1","0","1","0","0"};
    for(int i = 0; i < test[0].length; i++){
      assertEquals(expected[i], test[0][i]);
    }
  }
}