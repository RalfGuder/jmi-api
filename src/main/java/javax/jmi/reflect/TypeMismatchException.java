package javax.jmi.reflect;

/** 
 * Thrown to indicate that provided parameter or element of collection is
 * is of wrong type.
 * 
 * <p><tt>TypeMismatchException</tt> is thrown when the value has the wrong type 
 * for the context in which it was supplied.
 */
public class TypeMismatchException extends JmiException {

  private static final long serialVersionUID = 6474072169244577584L;
  private final Class<?> expectedType;

  /**
   * Constructs an <code>TypeMismatchException</code> without detail message.
   *
   * @param expectedType class of expected type.
   * @param objectInError value that caused this exception.
   * @param elementInError Attribute, Reference, Parameter or AssociationEnd for 
   *        the value that is in error.
   */
  public TypeMismatchException(Class<?> expectedType, Object objectInError,
      RefObject elementInError) {
    super(objectInError, elementInError);
    this.expectedType = expectedType;
  }

  /**
   * Constructs an <code>TypeMismatchException</code> with the specified detail 
   * message.
   *
   * @param expectedType class of expected type.
   * @param objectInError value that caused this exception.
   * @param elementInError Attribute, Reference, Parameter or AssociationEnd for 
   *        the value that is in error.
   * @param msg the detail message.
   */
  public TypeMismatchException(Class<?> expectedType, Object objectInError,
      RefObject elementInError, String msg) {
    super(objectInError, elementInError, msg);
    this.expectedType = expectedType;
  }

  /**
   * Returns class of expected type.
   *
   * @return expected type.
   */
  public Class<?> getExpectedType() {
    return expectedType;
  }
}


