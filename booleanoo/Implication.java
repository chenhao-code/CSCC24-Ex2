package booleanoo;

import booleanoo.operators.BinaryOperator;
import booleanoo.operators.Iff;
import booleanoo.operators.Implies;
import java.util.Map;

/**
 * A binary implication of BooleanExpression's.
 */
public class Implication extends BinaryExpression {
    private static final BinaryOperator ImplicationOperator = new Implies();

    public Implication(BooleanExpression left, BooleanExpression right) {
        super(ImplicationOperator, left, right);
    }

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
