package booleanoo;

import booleanoo.operators.BinaryOperator;
import booleanoo.operators.Iff;
import java.util.Map;

/**
 * A binary if and only if of BooleanExpressions.
 */
public class IffExpression extends BinaryExpression {

  // The binary IFF operator
  private static final BinaryOperator IFF_OPERATOR = new Iff();

  /**
    * Constructs an IffExpression with the given left and right BooleanExpressions.
    *
    * @param left  The left BooleanExpression.
    * @param right The right BooleanExpression.
    */
  public IffExpression(BooleanExpression left, BooleanExpression right) {
    super(IFF_OPERATOR, left, right);
  }

  /**
    * Simplifies the IffExpression once based on the provided context.
    *
    * @param context The context containing variable assignments.
    * @return The simplified IffExpression.
    */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    BooleanExpression simplifiedLeft = this.getLeft().simplifyOnce(context);
    BooleanExpression simplifiedRight = this.getRight().simplifyOnce(context);

    // Check if the left side is a BooleanValue and simplify
    // according to the logical equivalent rules
    if (simplifiedLeft instanceof BooleanValue) {
      boolean leftValue = ((BooleanValue) simplifiedLeft).getValue();
      if (leftValue) {
        // true iff X simplifies to X
        return simplifiedRight;
      } else {
        // false iff X simplifies to not X
        return new Negation(simplifiedRight);
      }
    }

    // Check if the right side is a BooleanValue and simplified 
    //according to the logical equivalence rules
    if (simplifiedRight instanceof BooleanValue) {
      boolean rightValue = ((BooleanValue) simplifiedRight).getValue();
      if (rightValue) {
        // X iff true simplifies to X
        return simplifiedLeft;
      } else {
        // X iff false simplifies to not X
        return new Negation(simplifiedLeft);
      }
    }

    // If neither side is a BooleanValue, return a new IffExpression
    return new IffExpression(simplifiedLeft, simplifiedRight);
  }
}

