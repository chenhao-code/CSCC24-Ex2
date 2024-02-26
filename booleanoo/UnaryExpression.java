package booleanoo;

import booleanoo.operators.UnaryOperator;
import java.util.Map;
/**
 * A unary boolean expression.
 */
public abstract class UnaryExpression extends BooleanExpression {

  //Fields
  private final UnaryOperator operator;
  private final BooleanExpression operand;

  /**
   * Constructor for a unary boolean expression.
   */

  public UnaryExpression(UnaryOperator operator, BooleanExpression operand){
    this.operator = operator;
    this.operand = operand;
  }

  // Abstract method to evaluate the unary expression.
  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    // Evaluate the operand within the given context
    Boolean operandValue = operand.evaluate(context);

    // Apply the unary operator to the result of the operand's evaluation
    return operator.apply(operandValue);
  }

  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(this.getClass())
        && ((UnaryExpression) other).operator.equals(operator)
        && ((UnaryExpression) other).operand.equals(operand);
  }

  @Override
  public String toString() {
    return String.format("(%s %s)", operator, operand.toString());
  }

  /**
   * Gets the operand of this unary expression.
   */
  public final BooleanExpression getOperand() {
    return operand;
  }

  /**
   * Gets the operator of this unary expression
   */

  public final UnaryOperator getOperator() {
    return operator;
  }
}
