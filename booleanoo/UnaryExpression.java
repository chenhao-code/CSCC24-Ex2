package booleanoo;

import booleanoo.operators.UnaryOperator;
import java.util.Map;

/**
 * A unary boolean expression.
 */
public abstract class UnaryExpression extends BooleanExpression {

  // Fields
  private final UnaryOperator operator;
  private final BooleanExpression operand;

  /**
    * Constructs a unary boolean expression with the specified operator and operand.
    *
    * @param operator The unary operator applied to the operand.
    * @param operand  The operand of the unary expression.
    */
  public UnaryExpression(UnaryOperator operator, BooleanExpression operand) {
    this.operator = operator;
    this.operand = operand;
  }

  /**
    * Evaluates the unary boolean expression within the given context.
    *
    * @param context The context containing variable assignments.
    * @return The result of evaluating the unary expression.
    * @throws UnassignedVariableException if a variable in the expression 
    is not assigned a value in the context.
    */
  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    // Evaluate the operand within the given context
    Boolean operandValue = operand.evaluate(context);

    // Apply the unary operator to the result of the operand's evaluation
    return operator.apply(operandValue);
  }

  /**
    * Checks whether this unary expression is equal to another object.
    *
    * @param other The object to compare with.
    * @return true if the objects are equal, false otherwise.
    */
  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(this.getClass())
      && ((UnaryExpression) other).operator.equals(operator)
      && ((UnaryExpression) other).operand.equals(operand);
  }

  /**
    * Returns a string representation of this unary expression.
    *
    * @return A string representing this unary expression.
    */
  @Override
  public String toString() {
    return String.format("(%s %s)", operator, operand.toString());
  }

  /**
    * Gets the operand of this unary expression.
    *
    * @return The operand.
    */
  public final BooleanExpression getOperand() {
    return operand;
  }

  /**
    * Gets the operator of this unary expression.
    *
    * @return The operator.
    */
  public final UnaryOperator getOperator() {
    return operator;
  }
}

