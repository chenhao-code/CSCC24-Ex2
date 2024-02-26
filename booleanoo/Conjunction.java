package booleanoo;

import booleanoo.operators.And;
import booleanoo.operators.BinaryOperator;
import java.util.Map;

/**
 * A binary conjunction of BooleanExpressions.
 */

public class Conjunction extends BinaryExpression {
  // The binary AND operator
  private static final BinaryOperator AND_OPERATOR = new And();
  /**
   * Constructs a Conjunction with the given left and right BooleanExpressions.
   *
   * @param left  The left BooleanExpression.
   * @param right The right BooleanExpression.
   */
  
  public Conjunction(BooleanExpression left, BooleanExpression right) {
    super(AND_OPERATOR, left, right);
  }

  /**
    * Simplifies the Conjunction once based on the provided context.
    *
    * @param context The context containing variable assignments.
    * @return The simplified Conjunction.
    */
  
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    BooleanExpression simplifiedLeft = this.getLeft().simplifyOnce(context);
    BooleanExpression simplifiedRight = this.getRight().simplifyOnce(context);

    if (simplifiedLeft instanceof BooleanValue) {
      boolean leftValue = ((BooleanValue) simplifiedLeft).getValue();
      if (leftValue) {
        // true AND x simplifies to x
        return simplifiedRight;
      } else {
        // false AND x simplifies to false
        return simplifiedLeft;
      }
    }
    if (simplifiedRight instanceof BooleanValue) {
      boolean rightValue = ((BooleanValue) simplifiedRight).getValue();
      if (rightValue) {
        return simplifiedLeft;
      } else {
        return simplifiedRight;
      }
    } 
    return new Conjunction(simplifiedLeft, simplifiedRight);
  }
}



