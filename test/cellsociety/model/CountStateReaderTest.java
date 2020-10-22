package cellsociety.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountStateReaderTest {

  CountStateReader countStateReader = new CountStateReader();
  @Test
  void validateGridSize() {
    String[][] test = countStateReader.getStatesFromFile("board_config/countConway0.csv");
    assertEquals(5, test.length);
    assertEquals(6, test[0].length);
  }
  @Test
  void testCorrectNumberCellsGenerated() {
    String[][] test = countStateReader.getStatesFromFile("board_config/countConway0.csv");
    int dead = 0;
    int alive = 0;
    for(int i = 0; i < test.length; i++){
      for(int j = 0; j < test[i].length; j++){
        if(test[i][j].equals("0")){
          dead++;
        }
        else{
          alive++;
        }
      }
    }
    assertEquals(dead,23);
    assertEquals(alive,7);
  }

}