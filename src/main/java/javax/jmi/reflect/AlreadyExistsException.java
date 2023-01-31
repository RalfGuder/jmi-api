package javax.jmi.reflect;

/** Exception thrown by <code>refCreateInstance</code> and <i>create</i> methods
 * when a client attempts to create the second instance of a singleton.
 * 
 * <p>The AlreadyExistsException is raised when a client attempts to create a 
 * second instance of an M2 class whose isSingleton is set to true.
 * 
 * <p><b>I think we should rather return the existing instance of singleton
 * from the create method without throwing this exception. This behaviour is
 * more common for singletons.</b>
 */
public class AlreadyExistsException extends JmiException {

  private static final long serialVersionUID = -7923836320746201352L;
  private final RefObject existing;

  /**
   * Constructs new <code>AlreadyExistsException</code> without detail message.
   * @param existing existing singleton instance
   */
  public AlreadyExistsException(RefObject existing) {
    super(existing.refMetaObject());
    this.existing = existing;
  }


  /**
   * Constructs an <code>AlreadyExistsException</code> with the specified detail message.
   * @param existing existing singleton instance
   * @param msg the detail message.
   */
  public AlreadyExistsException(RefObject existing, String msg) {
    super(existing.refMetaObject(), msg);
    this.existing = existing;
  }

  /**
   * Returns existing instance of singleton.
   * @return existing singleton instance
   */
  public RefObject getExistingInstance() {
    return existing;
  }
}
