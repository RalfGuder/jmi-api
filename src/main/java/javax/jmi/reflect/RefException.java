
package javax.jmi.reflect;

/**
 * Superclass for exceptions modeled in MOF.
 * 
 * <p>The RefException class is the superclass that is extended by instances of 
 * modeled exceptions. That is, all M1 instances of exceptions modeled in the 
 * respective M2 (i.e., instances of RefException), must extend the reflective 
 * RefException class.
 * 
 * <p>RefException is intended to be a checked exception, and as such, it 
 * extends java.lang.Exception.
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
