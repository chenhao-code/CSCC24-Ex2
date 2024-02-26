package booleanoo;

import booleanoo.operators.BinaryOperator;
import java.util.Map;

/**
 * A binary boolean expression.
 */
public abstract class BinaryExpression extends BooleanExpression {

  // Fields
  private final BinaryOperator operator;
  private final BooleanExpression left;
  private final BooleanExpression right;

  /**
   * Constructor for a binary boolean expression.
   *
   * @param operator The binary operator for this expression.
   * @param left     The left-side boolean expression.
   * @param right    The right-side boolean expression.
   */
  public BinaryExpression(BinaryOperator operator, BooleanExpression left, 
      BooleanExpression right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  /**
   * Evaluates the binary boolean expression.
   *
   * @param context The context containing variable assignments.
   * @return The result of evaluating the expression.
   * @throws UnassignedVariableException If a variable is not assigned in the context.
   */
  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    // Evaluate the left and right expressions
    Boolean leftValue = left.evaluate(context);
    Boolean rightValue = right.evaluate(context);

    // Apply the operator to the results
    return operator.apply(leftValue, rightValue);
  }

  /**
   * Checks if this binary expression is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(this.getClass())
        && ((BinaryExpression) other).operator.equals(operator)
        && ((BinaryExpression) other).left.equals(left)
        && ((BinaryExpression) other).right.equals(right);
  }

  /**
   * Returns a string representation of this binary expression.
   *
   * @return The string representation of this expression.
   */
  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, operator, right);
  }

  /**
   * Gets the left-side boolean expression.
   *
   * @return The left-side boolean expression.
   */
  public final BooleanExpression getLeft() {
    return left;
  }

  /**
   * Gets the right-side boolean expression.
   *
   * @return The right-side boolean expression.
   */
  public final BooleanExpression getRight() {
    return right;
  }

  /**
   * Gets the binary operator of this expression.
   *
   * @return The binary operator of this expression.
   */
  public final BinaryOperator getOperator() {
    return operator;
  }
}

