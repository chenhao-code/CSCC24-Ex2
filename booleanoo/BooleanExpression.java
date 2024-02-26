package booleanoo;
import java.util.Map;
/**
 * A boolean expression: the top of our hierarchy.
 */
public abstract class BooleanExpression {
    /**
     * Evaluates the boolean expression based provided context.
     */
    public abstract Boolean evaluate(Map<String, Boolean> context);

    /**
     * Simplifies the boolean expression based on the provided context.
     */
    public BooleanExpression simplify(Map<String, Boolean> context) {
        BooleanExpression simplified = this.simplifyOnce(context);
        BooleanExpression furtherSimplified = simplified.simplifyOnce(context);

        if (simplified.equals(furtherSimplified)) {
            return simplified;
        }

        return simplified.simplify(context); // Recursive call
    }

    /**
     * Simplifies the boolean expression once based on the provided context.
     */

    public abstract BooleanExpression simplifyOnce(Map<String, Boolean> context);


    /**
     * Checks if the given object is equal to this boolean expression.
     */
    @Override
    public abstract boolean equals(Object other);

    /**
     * Returns a string representation of the boolean expression.
     */
    @Override
    public abstract String toString();

}
