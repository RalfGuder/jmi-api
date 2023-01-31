package javax.jmi.reflect;

/** 
 * Exception thrown when an instance object is going to become owned by more 
 * than one element (in sense of aggregation semantics).
 * 
 * <p>CompositionViolationException is thrown when an operation attempts to add 
 * a value that is already a component in a composite relation, as a component 
 * of another composite relation.
 */
public class CompositionViolationException extends JmiException {

  private static final long serialVersionUID = 6812525312150345254L;

  /**
   * Constructs a <code>CompositionViolationException</code> without detail message.
   * @param objectInError An instance (component) that caused the composition violation.
   * @param elementInError Attribute, Reference or Association that is being updated to violate the composition.
   */
  public CompositionViolationException(Object objectInError, RefObject elementInError) {
    super(objectInError, elementInError);
  }

  /**
   * Constructs a <code>CompositionViolationException</code> with the specified detail message.
   * @param objectInError An instance (component) that caused the composition voilation.
   * @param elementInError Attribute, Reference or Association that is being updated to violate the composition.
   * @param msg the detail message.
   */
  public CompositionViolationException(Object objectInError, RefObject elementInError, String msg) {
    super(objectInError, elementInError, msg);
  }
}
