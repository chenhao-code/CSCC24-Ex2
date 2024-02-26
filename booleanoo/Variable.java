package booleanoo;

import java.util.Map;

/**
 * A boolean variable representing a boolean value in a truth assignment.
 * The value of this variable is determined by its assignment in the provided context.
 */
public class Variable extends BooleanExpression {

  // Private field to store the identifier of the variable
  private String id;

  /**
    * Constructs a new Variable with the specified identifier.
    *
    * @param id the identifier of the variable.
    */
  public Variable(String id) {
    this.id = id;
  }

  /**
    * Evaluates the value of the variable based on the given truth assignment context.
    *
    * @param context the truth assignment context containing variable assignments.
    * @return the value of the variable in the context.
    * @throws UnassignedVariableException if the variable is not assigned in the context.
    */
  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    // Check if the variable is present in the context
    if (context.containsKey(id)) {
      // If present, return its value from the context
      return context.get(id);
    } else {
      // If not present, throw UnassignedVariableException
      throw new UnassignedVariableException("Variable " + id + " is not assigned in the context");
    }
  }

  /**
    * Simplifies the variable expression once based on the provided truth assignment context.
    *
    * @param context the truth assignment context containing variable assignments.
    * @return a BooleanValue representing the value of the variable if 
              it is assigned in the context, or this variable unchanged if 
              it is not assigned.
    */
  @Override
  public BooleanExpression simplifyOnce(Map<String, Boolean> context) {
    // Check if the variable is present in the context
    if (context.containsKey(id)) {
      // If present, return a BooleanValue with its value from the context
      return new BooleanValue(context.get(id));
    } else {
      // If not present, return this variable unchanged
      return this;
    }
  }

  /**
    * Checks if this Variable is equal to another object.
    *
    * @param other the object to compare with.
    * @return true if the objects are equal, false otherwise.
    */
  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(Variable.class)
      && id.equals(((Variable) other).id);
  }

  /**
    * Returns the string representation of the variable.
    *
    * @return the string representation of the variable (its identifier).
    */
  @Override
  public String toString() {
    return id;
  }
}

