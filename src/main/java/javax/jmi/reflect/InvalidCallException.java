package javax.jmi.reflect;

/** 
 * Thrown by reflection methods when client tries to call them incorrectly.
 * (e.g. when <code>refSetValue</code> is called for attribute which is not
 * changeable).
 * 
 * <p>The InvalidCallException is thrown when an operation is invoked 
 * incorrectly using the reflective API.
 */
public class InvalidCallException extends JmiException {

  private static final long serialVersionUID = -8765165565924466319L;

  /**
   * Constructs an <code>InvalidCallException</code> without detail message.
   *
   * @param objectInError object in error
   * @param elementInError element in error.
   */
  public InvalidCallException(Object objectInError, RefObject elementInError) {
    super(objectInError, elementInError);
  }

  /**
   * Constructs an <code>InvalidCallException</code> with the specified detail message.
   *
   * @param objectInError object in error
   * @param elementInError element in error.
   * @param msg the detail message.
   */
  public InvalidCallException(Object objectInError, RefObject elementInError, String msg) {
    super(objectInError, elementInError, msg);
  }
}
