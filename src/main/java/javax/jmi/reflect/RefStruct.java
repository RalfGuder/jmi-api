package javax.jmi.reflect;

import java.util.List;


/**
 * The RefStruct interface is the reflective interface for struct data types. 
 * It provides generic operations for querying structs.
 *
 * @author Ralf Guder
 */
public interface RefStruct extends java.io.Serializable {

  /**
   * The <tt>refFieldNames</tt> operation returns the list of field names in 
   * this struct.
   *
   * <p>This operation returns the list of (String) field names contained in 
   * this struct.
   *
   * @return java.util.List
   */
  public List<String> refFieldNames();

  /**
   * The <tt>refGetValue</tt> operation returns the value of the specified field. 
   * <i>Specific analog: &lt;AccessorName&gt;</i>
   *
   * @param fieldName java.lang.String
   * @return java.lang.Object
   * @throws JmiException (InvalidNameException)
   */
  public java.lang.Object refGetValue(String fieldName) throws JmiException;

  /**
   * The <tt>refTypeName</tt> operation returns the fully qualified name of the 
   * structs metaobject.
   * 
   * <p>This operation returns the fully qualified name of the struct object’s 
   * metaobject.
   * 
   * <p>The List returned from this operation has copy semantics. That is, it 
   * does not reflect any changes to the source after the operation is executed, 
   * and it cannot be used to update the source.
   *
   * @return List
   */
  public List<?> refTypeName();

  /**
   * The <tt>equals</tt> operation compares the struct object with another object.
   * 
   * <p>The comparison for structs is based on attribute values. If two structs 
   * are of the same type and all attributes have the same value, then they are 
   * equal.
   *
   * @param other Object
   * @return
   */
  public boolean equals(Object other);

  public int hashCode();
}
