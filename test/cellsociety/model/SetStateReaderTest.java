package cellsociety.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.InvalidCSVFormatException;
import org.junit.jupiter.api.Test;

class SetStateReaderTest {

  @Test
  void readFile() {
    SetStateReader setStateReader = new SetStateReader();
    String[][] test = setStateReader.getStatesFromFile("board_config/conway1.csv");
    assertEquals(11, test.length);
    assertEquals(11, test[0].length);
    assertEquals("0", test[0][0]);
    assertEquals("1", test[0][1]);
  }
  @Test
  void testRowColumnDoNotMatch() {
    SetStateReader setStateReader = new SetStateReader();
    assertThrows(InvalidCSVFormatException.class,() -> setStateReader.getStatesFromFile("board_config/badRowColumn.csv"));
  }
}