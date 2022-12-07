package javax.jmi.reflect;

import java.util.List;

/**
 * The <tt>RefFeatured</tt> interface provides the metaobject description of instances 
 * and class proxy objects. It provides a range of operations for accessing and updating 
 * the object�s features in a model-independent way.
 * 
 * <p>The model assumed by the interface is that an object has structural features 
 * and operations. The model allows structural features to have single values or 
 * collection values. In the latter case, the collection values may have ordering 
 * or uniqueness semantics. There is provision for creation of new object instances, 
 * and for obtaining the set of objects that exist in a context.
 */
public interface RefFeatured extends RefBaseObject {
  /**
   * The <tt>setRefValue</tt> operations assign a new value to an attribute 
   * or reference for an object. Specific analog: <i>set&lt;ReferenceName&gt;()</i> 
   * or <i>set&ltAttributeName&gt;()</i>
   *
   *
   * @param feature RefObject 
   * @param value java.lang.object value
   * @throws JmiException (<b>InvalidCallException</b> is is raised when the <tt>feature</tt> does 
   * not denote an attribute or reference accessible from this object or the <tt>feature</tt>
   * denotes a multivalued attribute. <b>InvalidNameException</b> is raised when the 
   * <tt>featureName</tt> does not denote a valid feature name. <b>ClosureViolationException</b> 
   * occurs when the Composition Closure or Reference Closure rule has been violated. 
   * <b>CompositionCycleException</b> occurs when the Composition Cycle rule has been 
   * violated. InvalidObjectException, java.lang.NullPointerException)
   */
  public void refSetValue(RefObject feature, java.lang.Object value) throws JmiException;

  public void refSetValue(String featureName, java.lang.Object value) throws JmiException;

  /**
   * The <tt>refGetValue</tt> operations fetch the current value of the attribute 
   * or reference denoted by the "feature" (or featureName) argument. If this object 
   * is a class proxy, only classifier scoped attributes can be fetched. Specific analog:
   * <i>get&lt;ReferenceName&gt;()</i> or <i>get&ltAttributeName&gt;()</i>
   *
   * @param feature is a RefObject
   * @return a Object
   * @throws InvalidCallException is raised when the <b>feature</b> argument does 
   *         not denote an attribute or reference accessible from this object.
   */
  public java.lang.Object refGetValue(RefObject feature) throws JmiException;

  /**
   * The <tt>refGetValue</tt> operations fetch the current value of the attribute 
   * or reference denoted by the "feature" (or featureName) argument. If this object 
   * is a class proxy, only classifier scoped attributes can be fetched. Specific analog:
   * <i>get&lt;ReferenceName&gt;()</i> or <i>get&ltAttributeName&gt;()</i>
   *
   * @param featureName is a String
   * @return a Object
   * @throws InvalidNameException is raised when the <b>featureName</b> does not 
   *         denote a valid feature name.
   */
  public java.lang.Object refGetValue(String featureName) throws JmiException;

  /**
   * The <tt>refInvokeOperation</tt> operations invoke a metamodel defined 
   * operation on the instance or class proxy object with the arguments supplied.
   *
   * <p>The <b>args</b> parameter is used to pass the values of all of the 
   * operation’s parameters. There must be a distinct parameter value (real 
   * or dummy) in the <b>args</b> list for every parameter. WrongSizeException is 
   * raised if this is not so.
   * 
   * <p>The parameter values in <b>args</b> must appear in the order of the 
   * operation’s parameters as defined in the metamodel.
   * 
   * <p>The <b>args</b> member values provided by the caller for parameter 
   * positions must be encoded depending on the parameter’s type and multiplicity 
   * as per the <tt>Generation Rules for Parameters</tt> on page 56. 
   * TypeMismatchException or WrongSizeException is raised if this is not so.
   *
   * <p>If the operation defines a result, the result for a 
   * <tt>refInvokeOperation</tt> call gives the result value.
   *
   * <p>InvalidCallException is raised when the <b>requestedOperation</b> does 
   * not designate an operation that can be invoked.
   * 
   * <p>InvalidNameException is raised when the <b>operationName</b> does 
   * not denote a valid operation name.
   *
   * @param requestedOperation RefObject
   * @param args List
   * @return java.lang.Object
   * @throws JmiException (InvalidCallException, InvalidNameException, 
   *         DuplicateException, WrongSizeException, TypeMismatchException)
   * @throws RefException
   */
  public java.lang.Object refInvokeOperation(RefObject requestedOperation, List<?> args)
      throws JmiException, RefException;

  public java.lang.Object refInvokeOperation(String operationName, List<?> args)
      throws JmiException, RefException;
}
