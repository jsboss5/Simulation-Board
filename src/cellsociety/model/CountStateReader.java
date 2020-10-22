package cellsociety.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountStateReader extends Reader {


  private final List<String> randomStates = new ArrayList<>();
  private final Random random = new Random();

  @Override
  public String[][] getStatesFromFile(String fileName) {
    List<String[]> list = readFile(fileName);
    String[] dimensions = list.remove(0);
    int rows = Integer.parseInt(dimensions[0]);
    int cols = Integer.parseInt(dimensions[1]);
    //TODO: add validateStates method, validateDimensions
    makeRandomStateMap(list);
    String[][] dataArray = new String[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dataArray[i][j] = getRandomState();
      }
    }
    return dataArray;
  }

  private void makeRandomStateMap(List<String[]> probabilities) {
    for (String[] stateProb : probabilities) {
      int prob = Integer.parseInt(stateProb[1]);
      while (prob > 0) {
        randomStates.add(stateProb[0]);
        prob--;
      }
    }
  }

  private String getRandomState() {
    return randomStates.remove(random.nextInt(randomStates.size()));
  }
}
