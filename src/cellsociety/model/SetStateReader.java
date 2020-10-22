package cellsociety.model;

import exceptions.InvalidCSVFormatException;
import java.util.List;

public class SetStateReader extends Reader {

  @Override
  public String[][] getStatesFromFile(String fileName) throws InvalidCSVFormatException {
    List<String[]> gridData = readFile(fileName);
    String[] dimensions = gridData.remove(0);
    validateCSV(gridData, dimensions);
    //TODO: add validateStates method    validateCSV(list,dimensions);
    String[][] dataArray = new String[gridData.size()][];
    return gridData.toArray(dataArray);
  }

  private void validateCSV(List<String[]> list, String[] dimensions)
      throws InvalidCSVFormatException {
    if (Integer.parseInt(dimensions[0]) != list.size() ||
        Integer.parseInt(dimensions[1]) != list.get(1).length) {
      throw new InvalidCSVFormatException("Invalid CSV Dimensions");
    }
  }
}

