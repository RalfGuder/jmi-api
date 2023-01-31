package javax.jmi.reflect;

import java.util.*;

/**
 * The RefPackage interface is an abstraction for accessing a collection of objects and their 
 * associations. The interface provides an operation to access the metaobject description for the 
 * package, and operations to access the package instance's class proxy objects and its association
 * objects.
 *
 * @author RalfGuder
 */
public interface RefPackage extends RefBaseObject {
	
	/**
	 * The <tt>refClass</tt> operations return the class proxy object for a given class. Specific 
	 * analog: <i>get&lt;ClassName&gt;()</i>
	 *
	 * <p>The <b>type</b> (or <b>className</b>) parameter should designate the class 
	 * whose class proxy object is to be returned.
	 *
	 * <p>InvalidCallException is raised if the <b>type</b> parameter does not designate a valid class.
	 * 
	 * <p>InvalidNameException is raised when the <b>className</b> does not denote a valid class name.
	 * 
	 * @param type
	 * @return
	 */
    public RefClass refClass(RefObject type) throws JmiException;
    public RefClass refClass(String typeName) throws JmiException;
    
    /**
     * The <tt>refPackage</tt> operations return a package object for a nested 
     * or clustered package. Specific analog: <i>get&lt;PackageName&gt;()</i>
     * 
     * <p>The <b>nestedPackage</b> (or <b>nestedPackageName</b>) parameter should 
     * designate the package whose package object is to be returned. It must 
     * either be nested within the package for this package object, or imported 
     * with â€œisClusterâ€� set to true.
     * 
     * <p>InvalidCallException is raised if the <b>nestedPackage</b> parameter 
     * does not designate a valid package.
     * 
     * <p>InvalidNameException is raised when the <b>nestedPackageName</b> 
     * does not denote a valid nested package name.
     * 
     * @param nestedPackage
     * @return
     */
    public RefPackage refPackage(RefObject nestedPackage) throws JmiException;
    public RefPackage refPackage(String nestedPackageName) throws JmiException;
    
    /**
     * The <tt>refAssociation</tt> operations return an association object for a 
     * given association. Specific analog: <i>get&lt;AssociationName&gt;()</i>
     * 
     * <p>The <b>association</b> (or <b>associationName</b>) parameter should 
     * designate the (M2) association whose association object is to be returned.
     * 
     * <p>InvalidCallException is raised if the <b>association</b> parameter 
     * does not designate a valid association.
     * 
     * <p>InvalidNameException is raised when the <b>associationName</b> does
     *  not denote a valid association name.
     * 
     * @param association
     * @return
     */
    public RefAssociation refAssociation(RefObject association) throws JmiException;
    public RefAssociation refAssociation(String associationName) throws JmiException;
    
    /**
     * The <tt>refAllPackages</tt> operation returns all packages directly 
     * contained or clustered by this package.
     * 
     * <p>Returns a (possible empty) collection of RefPackages directly 
     * contained by this package.
     * 
     * <p>The Collection returned from this operation is an immutable 
     * live collection. This is, the collection will reflect any changes 
     * to the source, however, the operations in the Collection interface cannot 
     * be used to update the source.
     *
     * @return
     */
    public Collection<RefPackage> refAllPackages() throws JmiException;
    
    /**
     * The <tt>refAllClasses</tt> operation returns all class proxies 
     * directly contained by this package.
     * 
     * <p>Returns a (possible empty) collection of RefClasses directly 
     * contained by this package.
     * 
     * <p>The Collection returned from this operation is an immutable 
     * live collection. This is, the collection will reflect any changes 
     * to the source, however, the operations in the Collection interface 
     * cannot be used to update the source.
     * 
     * @return
     */
    public Collection<RefClass> refAllClasses() throws JmiException;
    
    /**
     * The <tt>refAllAssociation</tt> operation returns all associations 
     * directly contained by this package.
     * 
     * <p>Returns a (possible empty) collection of RefAssociations 
     * directly contained by this package.
     * 
     * <p>The Collection returned from this operation is an immutable 
     * live collection. This is, the collection will reflect any changes 
     * to the source, however, the operations in the Collection interface cannot
     * be used to update the source.
     * 
     * @return
     */
    public Collection<RefAssociation> refAllAssociations() throws JmiException;
    
    /**
     * This <tt>refCreateStruct</tt> operations create a new instance of 
     * a struct data type.
     * 
     * <p>The <tt>refCreateStruct</tt> operation creates an instance 
     * of a struct data type defined by the metaobject <b>struct</b> (or 
     * <b>structName</b>) whose attribute values are specified by the 
     * ordered collection <b>args</b>.
     * 
     * <p>The members of the <b>args</b> list correspond 1-to-1 to the
     * parameters for the specific create operation. They must be encoded 
     * as per â€œGeneration Rules for Parametersâ€� on page 56.
     * 
     * <p>InvalidCallException is raised if the <b>structType</b> parameter 
     * does not designate a struct type.
     * 
     * <p>InvalidNameException is raised when the <b>structName</b> 
     * does not denote a valid struct name.
     * 
     * @param struct
     * @param params
     * @return
     */
    public RefStruct refCreateStruct(RefObject struct, List<?> params) throws JmiException;
    public RefStruct refCreateStruct(String structName, List<?> params) throws JmiException;
    
    /**
     * This <tt>refGetEnum</tt> returns the enumeration object representing 
     * the enumeration literal.
     * 
     * <p>The <tt>refGetEnum</tt> operation returns the instance of an enumeration 
     * (i.e., an enumeration literal)whose value is described by the value of 
     * â€œliteralNameâ€�. Note that the type of enumeration is defined by the metamobject 
     * that owns the metaLiteral object.
     * 
     * <p>InvalidCallException is raised if the <b>enumObject</b> parameter does not 
     * designate a valid enumeration.
     * 
     * <p>InvalidNameException is raised when the <b>enumName</b> does not 
     * denote a valid enum name.
     * 
     * @param enumObject
     * @param name
     * @return
     */
    public RefEnum refGetEnum(RefObject enumObject, String name) throws JmiException;
    public RefEnum refGetEnum(String enumName, String name) throws JmiException;
    
    /**
     * The <tt>refDelete</tt> operation destroys this package, including the 
     * objects it contains directly or transitively.
     * 
     * <p>Deletion of an outermost package causes all objects within its 
     * extent to be deleted.
     */
    public void refDelete();
} 
