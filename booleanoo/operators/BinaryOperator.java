package booleanoo.operators;

/**
 * A binary boolean operator.
 */
public interface BinaryOperator {
    /**
     * Apply this operator to the given left and right boolean operands
     */
    Boolean apply(Boolean left, Boolean right);
}
