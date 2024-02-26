package booleanoo.operators;

/**
 * Represents a binary boolean operator.
 * Binary operators are operations that require two operands to perform a computation.
 */

public interface BinaryOperator {
  /**
    * Applies this binary operator to the given left and right boolean operands.
    *
    * @param left  the left boolean operand.
    * @param right the right boolean operand.
    * @return the result of applying this binary operator to the operands.
    */
  Boolean apply(Boolean left, Boolean right);
}

