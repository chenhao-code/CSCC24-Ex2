package booleanoo;

import booleanoo.operators.BinaryOperator;
import booleanoo.operators.And;
import java.util.Map;
/**
 * A binary conjunction of BooleanExpression's.
 */
public class Conjunction extends BinaryExpression {

    private static final BinaryOperator AND_OPERATOR = new And();

    public Conjunction(BooleanExpression left, BooleanExpression right){
        super(AND_OPERATOR, left, right);
    }

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
