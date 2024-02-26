package booleanoo.operators;

/**
 * A unary boolean operator.
 */

public interface UnaryOperator {

  /**
    * Apply this operator to the given operand.
    */

  Boolean apply(Boolean operand);

}
