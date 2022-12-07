package javax.jmi.reflect;

import java.util.*;

/**
 * The RefClass interface provides the metaobject description of a 
 * class proxy object, and a range of operations for accessing and 
 * updating an object’s classifier scoped features.
 * 
 * @author RalfGuder
 *
 */
public interface RefClass extends RefFeatured {
	
	/**
	 * This <tt>refCreateInstance</tt> operation creates a new 
	 * instance of the class for the class proxy’s most derived 
	 * interface. The <b>args</b> list gives the initial values 
	 * for the new instance object’s instance scoped, non-derived 
	 * attributes. Specific analog: <i>create&lt;ClassName&gt;(...)</i>
	 * 
	 * <p>The value of the <b>args</b> parameter must be either null, 
	 * or a list such that: 1 - the list of arguments correspond 
	 * 1-to-1 to the parameters for the specific create operation; 
	 * and 2 - each argument must be encoded as per the section 
	 * “Generation Rules for Parameters” on page 56. If <b>args</b> is 
	 * null, then the operation corresponds to the default constructor 
	 * that takes no arguments
	 * 
	 * @param args
	 * @return
	 */
    public RefObject refCreateInstance(List args) throws JmiException;
    
    /**
     * The <tt>refAllOfType</tt> operation returns the set of 
     * all instances in the current extent whose type is given 
     * by this object’s class or one of its sub-classes.
     * 
     * <p>The Collection returned from this operation is an 
     * immutable live collection. This is, the collection will reflect 
     * any changes to the source, however, the operations in the 
     * Collection interface cannot be used to update the source.
     * 
     * @return Collection (unique; unordered)
     */
    public Collection<?> refAllOfType();
    
    /**
     * The <tt>refAllOfClass</tt> operation returns the set of 
     * all instances in the current extent whose type is given 
     * by this object’s class (instances of sub classes are not 
     * included).
     * 
     * <p>The Collection returned from this operation is an 
     * immutable live collection. This is, the collection will 
     * reflect any changes to the source, however, the operations 
     * in the Collection interface cannot be used to update the source.
     * 
     * @return Collection (unique; unordered)
     */
    public Collection<?> refAllOfClass();
    
    /**
     * The <tt>refCreateStruct</tt> operations create a new instance
     * of a struct data type. Specific analog: <i>create&lt;Struct&gt;(...)</i>
     * 
     * <p>The <tt>refCreateStruct</tt> operation creates an instance of a 
     * struct data type defined by the metaobject <b>structType</b> (or 
     * <b>structName</b>) whose attribute values are specified by the ordered 
     * collection <b>params</b>.
     * 
     * <p>The members of the <b>params</b> list correspond 1-to-1 to the 
     * parameters for the specific create operation. They must be 
     * encoded as per the section titled “Generation Rules for Parameters” 
     * on page 56.
     * 
     * <p>InvalidCallException is raised if the <b>structType</b> parameter 
     * does not designate a valid struct type.
     * 
     * <p>InvalidNameException is raised when the <b>structName</b> does 
     * not denote a valid struct name.
     * 
     * @param structType
     * @param params
     * @return
     */
    public RefStruct refCreateStruct(RefObject structType, List<?> params) throws JmiException;
    public RefStruct refCreateStruct(String structName, List<?> params) throws JmiException;
    
    /**
     * This <tt>refGetEnum</tt> returns the enumeration object representing 
     * the enumeration literal.
     * 
     * <p>The <tt>refGetEnum</tt> operation returns an instance of an 
     * enumeration (i.e., an enumeration literal) whose value is described 
     * by the value of “literalName”. Note that the type of enumeration is defined 
     * by the metamobject that owns the metaLiteral object.
     * 
     * <p>InvalidCallException is raised if the <b>enumType</b> parameter does 
     * not designate a valid enumeration.
     * 
     * <p>InvalidNameException is raised when the <b>enumName</b> does not 
     * denote a valid enumeration name.
     * 
     * @param enumType
     * @param name
     * @return
     */
    public RefEnum refGetEnum(RefObject enumType, String name) throws JmiException;
    public RefEnum refGetEnum(String enumName, String name) throws JmiException;
}