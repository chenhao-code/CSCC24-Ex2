package booleanoo;

import booleanoo.operators.Or;
import java.util.Map;

import java.util.Map;
/**
 * A binary disjunction of BooleanExpression's.
 */
public class Disjunction extends BinaryExpression{

    public Disjunction(BooleanExpression left, BooleanExpression right){
        super(new Or(), left, right);
    }

    @Override
    public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
        BooleanExpression simplifiedLeft = this.getLeft().simplifyOnce(context);
        BooleanExpression simplifiedRight = this.getRight().simplifyOnce(context);

        if (simplifiedLeft instanceof BooleanValue && ((BooleanValue) simplifiedLeft).getValue()) {
            return simplifiedLeft;
        }

        if (simplifiedRight instanceof BooleanValue && ((BooleanValue) simplifiedRight).getValue()) {
            return simplifiedRight;
        }

        if (simplifiedLeft instanceof BooleanValue && !((BooleanValue) simplifiedLeft).getValue()) {
            return simplifiedRight;
        }
        if (simplifiedRight instanceof BooleanValue && !((BooleanValue) simplifiedRight).getValue()) {
            return simplifiedLeft;
        }

        return new Disjunction(simplifiedLeft, simplifiedRight);
    }
}
