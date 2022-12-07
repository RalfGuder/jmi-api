package javax.jmi.reflect;

import java.util.Collection;
import java.util.List;

/**
 * The interface provides the metaobject description of a class proxy object, 
 * and a range of operations for accessing and updating an object’s classifier 
 * scoped features.
 */
public interface RefClass extends RefFeatured {
  /**
   * This operation creates a new instance of the class for the class proxy’s 
   * most derived interface. The <b>args</b> list gives the initial values for 
   * the new instance object’s instance scoped, non-derived attributes.
   * 
   * <p>The members of the <b>args</b> list correspond 1-to-1 to the parameters 
   * for the specific create operation.
   *
   * @param args List
   * @return RefObject
   * @throws JmiException (WrongSizeException, DuplicateException, 
   *         ClosureViolationException, AlreadyExistsException, 
   *         TypeMismatchException)
   */
  public RefObject refCreateInstance(List<?> args) throws JmiException;

  /**
   * The operation returns the set of all instances in the current extent 
   * whose type is given by this object’s class or one of its sub-classes.
   *
   * <p>The Collection returned from this operation is an immutable live 
   * collection. This is, the collection will reflect any changes to the 
   * source, however, the operations in the Collection interface cannot be used 
   * to update the source.
   *
   * @return Collection (unique; unordered)
   */
  public Collection<?> refAllOfType();

  /**
   * The operation returns the set of all instances in the current extent whose 
   * type is given by this object’s class (instances of sub classes are not 
   * included).
   * 
   * <p>The Collection returned from this operation is an immutable live 
   * collection. This is, the collection will reflect any changes to the 
   * source, however, the operations in the Collection interface cannot be used 
   * to update the source.
   *
   * @return Collection (unique; unordered)
   */
  public Collection<?> refAllOfClass();

  /**
   * The operations create a new instance of a struct data type.
   * 
   * <p>The operation creates an instance of a struct data type defined by the 
   * metaobject <b>structType</b> whose attribute values are specified by the 
   * ordered collection <b>args</b>.
   * 
   * <p>The members of the <b>args</b> list correspond 1-to-1 to the parameters 
   * for the specific create operation.
   *
   * @param structType RefObject structType
   * @param args List args
   * @return RefStruct
   * @throws JmiException (WrongSizeException, TypeMismatchException, 
   *         InvalidObjectException, java.lang.NullPointerException)
   */
  public RefStruct refCreateStruct(RefObject structType, List<?> args) throws JmiException;

  /**
   * The operations create a new instance of a struct data type.
   * 
   * <p>The operation creates an instance of a struct data type defined by the 
   * metaobject <b>structName</b> whose attribute values are specified by the 
   * ordered collection <b>args</b>.
   * 
   * <p>The members of the <b>args</b> list correspond 1-to-1 to the parameters 
   * for the specific create operation.
   *
   * @param structName  String structName
   * @param args List args
   * @return RefStruct
   */
  public RefStruct refCreateStruct(String structName, List<?> args);

  /**
   * The operations create a new instance of the enumeration.
   * 
   * <p>The operation creates an instance of an enumeration (i.e., an enumeration 
   * literal) whose value is described by the value of <b>literalName</b>. 
   * Note that the type of enumeration is defined by the metamobject that owns 
   * the metaLiteral object.
   *
   * @param enumObject RefObject
   * @param literalName String
   * @return RefEnum
   */
  public RefEnum refGetEnum(RefObject enumObject, String literalName);

  /**
   * The operations create a new instance of the enumeration.
   * 
   * <p>The operation creates an instance of an enumeration (i.e., an enumeration 
   * literal) whose value is described by the value of <b>literalName</b>. 
   * Note that the type of enumeration is defined by the metamobject that owns 
   * the metaLiteral object.
   *
   * @param enumName String
   * @param literalName String
   * @return RefEnum
   */
  public RefEnum refGetEnum(String enumName, String literalName);
}
