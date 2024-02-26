package booleanoo.operators;

import booleanoo.Constants;

/**
 * Represents a binary operator "and" used for conjunction.
 * It evaluates to true if and only if both operands are true.
 */

public class And implements BinaryOperator {

  /**
    * Checks if this And operator is equal to another object.
    *
    * @param other the object to compare with.
    * @return true if the objects are equal, false otherwise.
    */
  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(And.class);
  }

  /**
    * Returns the string representation of the And operator.
    *
    * @return the string representation of the And operator.
    */
  @Override
  public String toString() {
    return Constants.AND;
  }

  /**
    * Applies the And operator to the given operands.
    *
    * @param left  the left operand.
    * @param right the right operand.
    * @return the result of applying the And operator to the operands.
    */
  @Override
  public Boolean apply(Boolean left, Boolean right) {
    return left && right;
  }
}

