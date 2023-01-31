package javax.jmi.reflect;

/** 
 * Exception which arises when a collection contains fewer or more values than 
 * is required by the corresponding <code>Multiplicity.lower</code> and 
 * <code>Multiplicity.upper</code>.
 * 
 * <p><tt>WrongSizeException</tt> is thrown when the lower bound or upper bound 
 * is violated.
 */
public class WrongSizeException extends JmiException {

  private static final long serialVersionUID = 1L;

  /** 
   * Creates <code>WrongSizeException</code> with a detail message.
   *
   * @param elementInError element in error.
   */
  public WrongSizeException(RefObject elementInError) {
    super(elementInError);
  }

  /** 
   * Creates <code>WrongSizeException</code> with a detail message.
   *
   * @param elementInError element in error.
   * @param msg detail message.
   */
  public WrongSizeException(RefObject elementInError, String msg) {
    super(elementInError, msg);
  }
}
