package javax.jmi.reflect;

import java.util.Collection;

/**
 * The RefBaseObject interface is extended by all other reflective interfaces. 
 * It provides common operations for testing for object identity, returning 
 * an object's metaobject, and returning its facility container as required for 
 * implementing structural constraints such as the MOF's type closure rule
 * and composition restrictions.
 */
public interface RefBaseObject {
  /**
   * The <tt>refMetaObject</tt> operation returns the RefObject object that 
   * describes this object in its metamodel specification.
   *
   * <p>If the object's metaobject is unavailable, the return value may be a 
   * Java null object reference.
   */
  public RefObject refMetaObject();

  /**
   * The <tt>refImmediatePackage</tt> operation returns the package object 
   * for the package that most immediately contains or aggregates this object.
   *
   * <p>If this object has no containing or aggregating package (i.e. it is the 
   * RefPackage object for an outermost package), then the return value is a 
   * Java null object reference. In complex cases where there is more than 
   * one immediate aggregating package, the return value may be any of them.
   *
   * <p>If the ignoreLifecycle tag (attached to the package containing the 
   * metamodel) is set to true, this method throws the 
   * java.lang.UnsupportedOperationException.
   */
  public RefPackage refImmediatePackage();

  /**
   * The <tt>refOutermostPackage</tt> operation returns the package object 
   * for the package that ultimately contains this object.
   *
   * <p>If this object is the RefPackage object for an outermost package then 
   * the return value is this object.
   *
   * <p>If the ignoreLifecycle tag (attached to the package containing the 
   * metamodel) is set to true, this method throws the 
   * java.lang.UnsupportedOperationException.
   */
  public RefPackage refOutermostPackage();

  /**
   * The <tt>refMofId</tt>-operation returns this object's permanent unique 
   * identifier string.
   *
   * <p>Every MOF object has a permanent, unique MOF identifier associated with 
   * it. This identifier is generated and bound to the object when it is 
   * created and cannot be changed for the lifetime of the object. The 
   * primary purpose of the MOF identifier is to serve as a label that can 
   * be compared to definitively establish an object's identity.
   *
   * <p>A MOF implementation must ensure that no two distinct MOF objects within 
   * the extent of an outermost Package object ever have the same MOF 
   * identifier. This invariant must hold for the lifetime of the extent. 
   * A group of outermost Package extents can only be safely federated if the
   * respective implementations can ensure the above invariant applies across 
   * the entire federation. A federation of extents in which the invariant 
   * does not hold is not MOF compliant.
   */
  public String refMofId() throws JmiException;

  /**
   * The <tt>refVerifyConstraints</tt> operation verifies that an object and 
   * its properties satisfy all constraints defined on it
   *
   * <p>When deepVerify is false (i.e., a shallowVerify), the 
   * refVerifyConstraints method checks all constraints on that object and 
   * its properties.
   *
   * <p>When deepVerify is true, the refVerifyConstraints method carries out a 
   * shallowVerify on that object and a deep verify through its containment 
   * hierarchy. If the object is a extent object (i.e., class proxy, package, 
   * or association object), the containment hierarchy includes all objects 
   * in its extent.
   *
   * <p>If no constraint is violated, the null value is returned; otherwise, a 
   * list of javax.jmi.reflect.JmiException objects (each representing a 
   * constraint violation) is returned.
   *
   * <p>The Collection returned from the refVerifyConstraints operation has 
   * copy semantics. That is, it does not reflect any changes to the source 
   * after the operation is executed, and it cannot be used to update the 
   * source. 
   *
   * @param deepVerify boolean
   */
  public Collection<?> refVerifyConstraints(boolean deepVerify);

  public boolean equals(Object other);

  public int hashCode();
}
