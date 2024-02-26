package booleanoo;

import booleanoo.operators.Or;
import java.util.Map;

/**
 * A binary disjunction of BooleanExpressions.
 */
public class Disjunction extends BinaryExpression {

  /**
    * Constructs a Disjunction with the given left and right BooleanExpressions.
    *
    * @param left  The left BooleanExpression.
    * @param right The right BooleanExpression.
    */
  public Disjunction(BooleanExpression left, BooleanExpression right) {
    super(new Or(), left, right);
  }

  /**
    * Simplifies the Disjunction once based on the provided context.
    *
    * @param context The context containing variable assignments.
    * @return The simplified Disjunction.
    */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    BooleanExpression simplifiedLeft = this.getLeft().simplifyOnce(context);
    BooleanExpression simplifiedRight = this.getRight().simplifyOnce(context);

    if (simplifiedLeft instanceof BooleanValue && ((BooleanValue) simplifiedLeft).getValue()) {
      // true OR x simplifies to true
      return simplifiedLeft;
    }

    if (simplifiedRight instanceof BooleanValue && ((BooleanValue) simplifiedRight).getValue()) {
      // x OR true simplifies to true
      return simplifiedRight;
    }

    if (simplifiedLeft instanceof BooleanValue && !((BooleanValue) simplifiedLeft).getValue()) {
      // false OR x simplifies to x
      return simplifiedRight;
    }
        
    if (simplifiedRight instanceof BooleanValue && !((BooleanValue) simplifiedRight).getValue()) {
      // x OR false simplifies to x
      return simplifiedLeft;
    }

    // No simplification possible, return a new Disjunction
    return new Disjunction(simplifiedLeft, simplifiedRight);
  }
}

