package booleanoo;

import booleanoo.operators.Not;
import booleanoo.operators.UnaryOperator;
import java.util.Map;

/**
 * A unary negation.
 */
public class Negation extends UnaryExpression {

  // The unary NOT operator
  private static final UnaryOperator NOT_OPERATOR = new Not();

  /**
    * Constructs a Negation with the given operand.
    *
    * @param operand The operand to negate.
    */
  public Negation(BooleanExpression operand) {
    super(NOT_OPERATOR, operand);
  }

  /**
    * Simplifies the Negation once based on the provided context.
    *
    * @param context The context containing variable assignments.
    * @return The simplified Negation.
    */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    BooleanExpression simplifiedOperand = this.getOperand().simplifyOnce(context);

    // If the operand is a BooleanValue, negate its value and return
    if (simplifiedOperand instanceof BooleanValue) {
      boolean value = ((BooleanValue) simplifiedOperand).getValue();
      return new BooleanValue(!value);
    } else {
      // If the operand is not a BooleanValue, return a new Negation with the simplified operand
      return new Negation(simplifiedOperand);
    }
  }
}

