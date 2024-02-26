package booleanoo;

import booleanoo.operators.BinaryOperator;
import booleanoo.operators.Implies;
import java.util.Map;

/**
 * A binary implication of BooleanExpressions.
 */
public class Implication extends BinaryExpression {

  // The binary Implication operator
  private static final BinaryOperator IMPLICATION_OPERATOR = new Implies();

  /**
    * Constructs an Implication with the given left and right BooleanExpressions.
    *
    * @param left  The left BooleanExpression.
    * @param right The right BooleanExpression.
    */
  public Implication(BooleanExpression left, BooleanExpression right) {
    super(IMPLICATION_OPERATOR, left, right);
  }

  /**
    * Simplifies the Implication once based on the provided context.
    *
    * @param context The context containing variable assignments.
    * @return The simplified Implication.
    */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    // Simplify both sides once
    BooleanExpression simplifiedLeft = getLeft().simplifyOnce(context);
    BooleanExpression simplifiedRight = getRight().simplifyOnce(context);

    // Apply simplification rules specific to implication here
    // Placeholder logic:
    if (simplifiedLeft instanceof BooleanValue) {
      if (((BooleanValue) simplifiedLeft).getValue()) {
        // true implies X simplifies to X
        return simplifiedRight;
      } else {
        // false implies X simplifies to true
        return new BooleanValue(true);
      }
    }
    if (simplifiedRight instanceof BooleanValue) {
      if (((BooleanValue) simplifiedRight).getValue()) {
        // X implies true simplifies to true
        return new BooleanValue(true);
      } else {
        // X implies false simplifies to not X
        return new Negation(simplifiedLeft);
      }
    }
    // If no simplification can be done, return a new Implication with the simplified operands
    return new Implication(simplifiedLeft, simplifiedRight);
  }
}
