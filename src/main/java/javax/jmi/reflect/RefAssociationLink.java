package javax.jmi.reflect;

/**
 * The RefAssociationLink interface is the reflective interface implemented by 
 * all association links, i.e., instances of RefAssociation. It provides generic 
 * operations for querying the association link.
 *
 * @author Ralf Guder
 */
public interface RefAssociationLink {

  /**
   * The <tt>refFirstEnd</tt> operation returns object at the first end of the 
   * link.
   *
   * @return RefObject
   */
  public RefObject refFirstEnd();

  /**
   * The <tt>refSecondEnd</tt> operation returns object at the second end of the 
   * link.
   * 
   * @return RefObject
   */
  public RefObject refSecondEnd();

  public boolean equals(Object other);

  public int hashCode();
}

