package booleanoo;

import booleanoo.operators.BinaryOperator;
import java.util.Map;
/**
 * A binary boolean expression.
 */
public abstract class BinaryExpression extends BooleanExpression{

  //Fields
  private final BinaryOperator operator;
  private final BooleanExpression left;
  private final BooleanExpression right;

  /**
   * Constructor for a binary boolean expression.
   */
  public BinaryExpression(BinaryOperator operator, BooleanExpression left, BooleanExpression right){
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  // The evaluate method is abstract will be implemented by subclasses.
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    // Evaluate the left and right expressions
    Boolean leftValue = left.evaluate(context);
    Boolean rightValue = right.evaluate(context);

    // Apply the operator to the results
    return operator.apply(leftValue, rightValue);
  }


  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(this.getClass())
        && ((BinaryExpression) other).operator.equals(operator)
        && ((BinaryExpression) other).left.equals(left)
        && ((BinaryExpression) other).right.equals(right);
  }

  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, operator, right);
  }


  /**
   * Gets the left-side boolean expression
   */
  public final BooleanExpression getLeft() {
    return left;
  }


  /**
   * Gets the  right-side boolean expression
   */
  public final BooleanExpression getRight(){
    return right;
  }

  /**
   * Gets the binary operator of this expression
   */

  public final BinaryOperator getOperator(){
    return operator;
  }


}
