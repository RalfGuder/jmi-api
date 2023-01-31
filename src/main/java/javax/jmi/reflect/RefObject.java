package javax.jmi.reflect;

/**
 * The RefObject interface provides the metaobject description 
 * of an instance object, and a range of operations for accessing 
 * and updating the object’s features.
 *
 *
 * @author RalfGuder
 *
 */
public interface RefObject extends RefFeatured {
	
	/**
	 * This operation tests whether this RefObject is an instance 
	 * of the class described by the <b>objType</b> metaobject. 
	 * If the <b>considerSubtypes</b> argument is true, an object 
	 * whose class is a subclass of the class described by <b>objType</b> 
	 * will be considered as an instance of the class.
	 * 
	 * @param objType
	 * @param considerSubtypes
	 * @return
	 */
    public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes);
    
    /**
     * This operation returns the RefObject's class proxy object.
     * 
     * <p>If the ignoreLifecycle tag (attached to the package containing the 
     * metamodel) is set to true, this method throws the 
     * java.lang.UnsupportedOperationException.
     * 
     * 
     * @return
     */
    public RefClass refClass();
    
    /**
     * The <tt>refImmediateComposite</tt> operation 
     * returns the immediate composite object for this 
     * instance as specified below.
     * 
     * <p>The immediate composite object C returned by this operation 
     * is an instance object such that:
     * <ul>
     * <li>C is related to this object via a relation R defined by an attribute or association.</li>
     * <li>The aggregation semantics of the relation R are "composite".</li>
     * <li>This object fills the role of "component" in its relationship with C.</li>
     * </ul>
     * 
     * <p>If the immediate object C does not exist, or if "this" object is a class proxy 
     * object rather than an instance object, a Java null object reference is returned.
     * 
     * <p>If the composite relationship R corresponds to a "classifier-level" scoped 
     * attribute, the immediate composite object C will be the class proxy object 
     * that holds the attribute value
     *
     * @return
     */
    public RefFeatured refImmediateComposite();
    
    /**
     * The <tt>refOutermostComposite</tt> operation returns the "outermost composite" 
     * for this object as defined below.
     * 
     * <p>The outermost composite object C returned by this operation is an 
     * instance object such that:
     * <ul>
     * <li>There is a chain of <i>zero or more</i> immediate composite 
     * relationships (as described for "refInvokeOperation" above) connecting 
     * "this" object to C, and</li>
     * <li>C does not have an immediate composite.</li>
     * </ul>
     * 
     * <p>The above definition is such that if "this" object is not a 
     * component of any other object, it will be returned.
     * @return
     */
    public RefFeatured refOutermostComposite();
    
    /**
     * The <tt>refDelete</tt> operation destroys this object, including 
     * the objects it contains directly or transitively.
     * 
     * <p>Deletion of an instance object deletes it and its component closure.
     * 
     * <p>If the ignoreLifecycle tag (attached to the package containing 
     * the metamodel) is set to true, this method throws the 
     * java.lang.UnsupportedOperationException.
     */
    public void refDelete() throws JmiException;
}
