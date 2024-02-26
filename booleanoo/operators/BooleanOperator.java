package booleanoo.operators;

/**
 * A boolean operator.
 */
public interface BooleanOperator {

    /**
     * Returns a string representation of the boolean operator.
    */
    @Override
    String toString();

    /**
     * Indicates whether some other object is "equal to" this operator.
     */
    @Override
    boolean equals(Object other);
}
