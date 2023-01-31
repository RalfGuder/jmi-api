package javax.jmi.reflect;

/** 
 * Exception thrown when a collection passed to an operation parameter with 
 * <code>isUnique</code> set to true contains duplicate values.
 */
public class DuplicateException extends JmiException {

  private static final long serialVersionUID = -5320638027056419573L;

  /**
   * Constructs an <code>DuplicateException</code> without detail message.
   *
   * @param objectInError object that was duplicated.
   * @param elementInError Attribute, Parameter or Association End that defines 
   *        the multiplicity which is being violated.
   */
  public DuplicateException(Object objectInError, RefObject elementInError) {
    super(objectInError, elementInError);
  }

  /**
   * Constructs an <code>DuplicateException</code> with the specified detail message.
   *
   * @param objectInError object that was duplicated.
   * @param elementInError Attribute, Parameter or Association End that defines 
   *        the multiplicity which is being violated.
   * @param msg the detail message.
   */
  public DuplicateException(Object objectInError, RefObject elementInError, String msg) {
    super(objectInError, elementInError, msg);
  }
}
