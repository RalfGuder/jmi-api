
package javax.jmi.reflect;

/** 
 * Ancestor for all JMI exceptions thrown by reflective and generated
 * methods.
 * 
 * <p>At the root of the exception framework is JmiException, which is the
 * superclass of all other JMI exceptions. JmiException is intended to be an 
 * unchecked exception and as such, extends java.lang.RuntimeException.
 * 
 * <p>The JmiException contains two private attributes - <b>elementInError</b> and 
 * <b>objectInError</b>. The <b>elementInError</b> is the ModelElement of the 
 * instance for which the error is being reported. The <b>objectInError</b> is 
 * the object for which the error is being reported.
 *  
 */
public abstract class JmiException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final RefObject elementInError;
    private final Object objectInError;
    
    /**
     * Constructs new <code>JmiException</code> without detail message.
     */
    public JmiException() {
        this(null, (RefObject) null);
    }
    
    /**
     * Constructs an <code>JmiException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public JmiException(String msg) {
        this(null, null, msg);
    }
    
    /**
     * Constructs new <code>JmiException</code> without detail message.
     * @param elementInError JMI object in error.
     */    
    public JmiException(RefObject elementInError) {
        this(null, elementInError);
    }

    /**
     * Constructs an <code>JmiException</code> with the specified detail message.
     * @param elementInError JMI object in error.
     * @param msg the detail message.
     */
    public JmiException(RefObject elementInError, String msg) {
        this(null, elementInError, msg);
    }
    
    /**
     * Constructs new <code>JmiException</code> without detail message.
     * @param objectInError Value that caused the error.
     * @param elementInError JMI object in error.
     */    
    public JmiException(Object objectInError, RefObject elementInError) {
        super();
        this.objectInError = objectInError;
        this.elementInError = elementInError;
    }
    
    /**
     * Constructs an <code>JmiException</code> with the specified detail message.
     * @param objectInError Value that caused the error.
     * @param elementInError JMI object in error.
     * @param msg the detail message.
     */
    public JmiException(Object objectInError, RefObject elementInError, String msg) {
        super(msg);
        this.objectInError = objectInError;
        this.elementInError = elementInError;
    }
    
    /**
     * Returns element in error.
     * @return element in error.
     */
    public RefObject getElementInError() {
        return elementInError;
    }
    
    /**
     * Returns object in error.
     * @return object in error
     */
    public Object getObjectInError() {
        return objectInError;
    }
}