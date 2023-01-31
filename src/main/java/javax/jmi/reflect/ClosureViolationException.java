package javax.jmi.reflect;

/** 
 * Exception thrown when Composition Closure or Reference Closure rules are
 * violated. (Supertype Closure rule can never be violated in JMI).
 * 
 * <p>The ClosureViolationException is thrown when Composition Closure or 
 * Reference Closure rules are violated. Note that the Supertype Closure rule 
 * can never be violated in JMI.
 */
public class ClosureViolationException extends JmiException {


  private static final long serialVersionUID = -1904902434547675123L;

  /**
   * Constructs an <code>ClosureViolationException</code> without detail message.
   * @param objectInError An instance that violated the closure rule.
   * @param elementInError Reference, Attribute or Association for which the closure rule is violated.
   */
  public ClosureViolationException(Object objectInError, RefObject elementInError) {
    super(objectInError, elementInError);
  }

  /**
   * Constructs an <code>ClosureViolationException</code> with the specified detail message.
   * @param objectInError An instance that violated the closure rule.
   * @param elementInError Reference, Attribute or Association for which the closure rule is violated.
   * @param msg the detail message.
   */
  public ClosureViolationException(Object objectInError, RefObject elementInError, String msg) {
    super(objectInError, elementInError, msg);
  }
}
