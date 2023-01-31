package javax.jmi.reflect;

/** Exception thrown when an object operation detects
 * a non-existing (i.e. deleted) object.
 */
public class InvalidObjectException extends JmiException {
    
  private static final long serialVersionUID = 4949876443824782846L;

    /**
     * Constructs an <code>InvalidObjectException</code> without detail message.
     *
     * @elementInError element in error.
     */
    public InvalidObjectException(RefObject elementInError) {
        super(elementInError);
    }

    /**
     * Constructs an <code>InvalidObjectException</code> with the specified 
     * detail message.
     *
     * @elementInError element in error.
     * @param msg the detail message.
     */
    public InvalidObjectException(RefObject elementInError, String msg) {
        super(elementInError, msg);
    }
}


