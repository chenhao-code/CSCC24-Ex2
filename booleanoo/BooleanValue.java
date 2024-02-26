package booleanoo;

import java.util.Map;
/**
 * A boolean value: true or false.
 */
public class BooleanValue extends BooleanExpression {

  // The encapsulated boolean value
  private final Boolean value;

  // Constructor for a BooleanValue.
  public BooleanValue(Boolean value){
    this.value = value;
  }

  public Boolean getValue() {
    return this.value;
  }
  @Override
  public String toString() {
    return value.toString();
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) {
    return this.value;
  }

  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    return this;
  }

  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(BooleanValue.class)
        && ((BooleanValue) other).value.equals(value);
  }
}
