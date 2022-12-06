
package javax.jmi.reflect;

/**
 * Superclass for exceptions modeled in MOF.
 */
public class RefException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RefException() {
    }
    
    public RefException(String msg) {
        super(msg);
    }
}
