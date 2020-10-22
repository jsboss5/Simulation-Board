package cellsociety.model;

@FunctionalInterface
public interface TriConsumer<T, T2, T3> {

  void accept(T type1, T2 type2, T3 type3);
}
