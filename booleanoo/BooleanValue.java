package booleanoo;

import java.util.Map;

/**
 * A boolean value: true or false.
 */
public class BooleanValue extends BooleanExpression {

  // The encapsulated boolean value
  private final Boolean value;

  /**
   * Constructor for a BooleanValue.
   *
   * @param value The boolean value to encapsulate.
   */
  public BooleanValue(Boolean value) {
    this.value = value;
  }

  /**
   * Gets the boolean value encapsulated by this BooleanValue object.
   *
   * @return The boolean value.
   */
  public Boolean getValue() {
    return this.value;
  }

  /**
   * Returns a string representation of the boolean value.
   *
   * @return The string representation of the boolean value.
   */
  @Override
  public String toString() {
    return value.toString();
  }

  /**
   * Evaluates the boolean value.
   *
   * @param context The context containing variable assignments (unused in this case).
   * @return The boolean value.
   */
  @Override
  public Boolean evaluate(Map<String, Boolean> context) {
    return this.value;
  }

  /**
   * Simplifies the boolean value expression.
   *
   * @param context The context containing variable assignments (unused in this case).
   * @return This boolean value expression, as it cannot be simplified further.
   */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    return this;
  }

  /**
   * Checks if the given object is equal to this boolean value expression.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(BooleanValue.class)
        && ((BooleanValue) other).value.equals(value);
  }
}

