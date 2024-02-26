package booleanoo.operators;

import booleanoo.Constants;

/**
 * Binary operator "implies" used for implication.
 */
public class Implies implements BinaryOperator {

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof Implies);
  }

  @Override
  public String toString() {
    return Constants.IMPLIES;
  }

  @Override
  public Boolean apply(Boolean left, Boolean right) {
    return !left || right;
  }
}
