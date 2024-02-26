package booleanoo;

import booleanoo.operators.UnaryOperator;
import booleanoo.operators.Not;

import java.util.Map;

/**
 * A unary negation.
 */
public class Negation extends UnaryExpression{

    private static final UnaryOperator NOT_OPERATOR = new Not();
    // Constructor
    public Negation(BooleanExpression operand) {
        super(NOT_OPERATOR, operand);
    }

    @Override
    public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
        BooleanExpression simplifiedOperand = this.getOperand().simplifyOnce(context);

        if (simplifiedOperand instanceof BooleanValue) {
            boolean value = ((BooleanValue) simplifiedOperand).getValue();
            return new BooleanValue(!value);
        }else {
            return new Negation(simplifiedOperand);
        }
    }



}
