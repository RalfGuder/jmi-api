package javax.jmi.reflect;

import java.io.Serializable;
import java.util.List;

/**
 * The RefEnum interface is the reflective interface for enumerations. It 
 * provides generic operations for querying the enumeration.
 *
 * @author Ralf Guder
 *
 */
public interface RefEnum extends Serializable {
  
  /**
   * The <tt>toString</tt> operation returns the enumeration literal.
   *
   * @return String
   */
  public String toString();

  /**
   * The <tt>refTypeName</tt> operation returns the fully qualified name of the 
   * enumerations metaobject.
   * 
   * <p>This operation returns the fully qualified name of the enumeration 
   * object’s metaobject.
   * 
   * <p>The Collection returned from this operation has copy semantics. That is, 
   * it does not reflect any changes to the source after the operation is 
   * executed, and it cannot be used to update the source.
   *
   * @return List&lt;String&gt;
   */
  public List<String> refTypeName();

  /**
   * The <tt>equals</tt> operation compares the enumeration object with another 
   * object.
   * 
   * <p>The comparison for enumerations is based on literal value. If two 
   * enumerations are of the same type and represent the same literal, then 
   * they are equal.
   *
   * @param other java.lang.Object
   * @return boolean
   */
  public boolean equals(java.lang.Object other);

  public int hashCode();
}
