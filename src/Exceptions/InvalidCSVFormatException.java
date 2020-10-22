package exceptions;

public class InvalidCSVFormatException extends RuntimeException {

  public InvalidCSVFormatException(String message) {
    super(message);
  }
}
