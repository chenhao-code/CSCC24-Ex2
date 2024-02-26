package booleanoo;

/**
 * An exception thrown when a variable does not have a value in a truth assignment
 * when this value is needed for evaluation.
 */
public class UnassignedVariableException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
    * Constructs a new UnassignedVariableException with no detail message.
    */
  public UnassignedVariableException() {
  }

  /**
    * Constructs a new UnassignedVariableException with the specified detail message.
    *
    * @param message the detail message.
    */
  public UnassignedVariableException(String message) {
    super(message);
  }
}

