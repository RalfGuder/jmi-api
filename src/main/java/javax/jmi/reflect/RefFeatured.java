package javax.jmi.reflect;

import java.util.List;

/**
 * The <tt>RefFeatured</tt> interface provides the metaobject description of instances 
 * and class proxy objects. It provides a range of operations for accessing and updating 
 * the object’s features in a model-independent way.
 * 
 * <p>The model assumed by the interface is that an object has structural features 
 * and operations. The model allows structural features to have single values or 
 * collection values. In the latter case, the collection values may have ordering 
 * or uniqueness semantics. There is provision for creation of new object instances, 
 * and for obtaining the set of objects that exist in a context.
 */
public interface RefFeatured extends RefBaseObject {
  public void refSetValue(RefObject feature, java.lang.Object value) throws JmiException;

  public void refSetValue(String featureName, java.lang.Object value) throws JmiException;

  /**
   * The operations fetch the current value of the attribute or reference 
   * denoted by the <b>feature</b> (or <b>featureName</b>) argument. 
   * If this object is a class proxy, only classifier scoped attributes can be 
   * fetched.
   *
   * @param feature is a RefObject
   * @return a Object
   * @throws InvalidCallException is raised when the <b>feature</b> argument does 
   *         not denote an attribute or reference accessible from this object.
   */
  public java.lang.Object refGetValue(RefObject feature) throws JmiException;

  /**
   * The operations fetch the current value of the attribute or reference 
   * denoted by the <b>feature</b> (or <b>featureName</b>) argument. If this object 
   * is a class proxy, only classifier scoped attributes can be fetched.
   *
   * @param featureName is a String
   * @return a Object
   * @throws InvalidNameException is raised when the <b>featureName</b> does not 
   *         denote a valid feature name.
   */
  public java.lang.Object refGetValue(String featureName) throws JmiException;

  public java.lang.Object refInvokeOperation(RefObject requestedOperation, List<?> args)
      throws JmiException, RefException;

  public java.lang.Object refInvokeOperation(String operationName, List<?> args)
      throws JmiException, RefException;
}
