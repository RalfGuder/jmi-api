package javax.jmi.reflect;

import java.util.Collection;

/**
 * The RefAssociation interface provides the metaobject description of an association. It also 
 * provides generic operations querying and updating the links that belong to the association
 *
 * <p>The model of association supported by this interface is of collection of two ended 
 * asymmetric links between objects. The links may be viewed as ordered on one or other 
 * of the ends, and there may be some form of cardinality constraints on either end.
 * 
 * <p>The RefAssociation interface is designed to be used with associations that contain no 
 * duplicate links, though this is not an absolute requirement. There is no assumption 
 * that different association objects for a given association type are mutually aware. 
 * Links are modeled as having no object identity.
 * 
 * <p>(A data model that required “heavy weight” links with object identity (e.g., so that 
 * attributes could be attached to them) would need to represent them as RefObject instances. 
 * The RefAssociation interface could be used to mange light weight links between the heavy 
 * weight link objects they connect. Similar techniques could be used to represent 
 * n-ary associations. However, in both cases better performance would be achieved using 
 * a purpose built reflective layer.)
 *
 * @author RalfGuder
 *
 */
public interface RefAssociation extends RefBaseObject {
	/**
	 * The <tt>refAllLinks</tt> operation returns all links in the 
	 * link set for this Association object.
	 * 
	 * <p>This operation returns the current link set for the current 
	 * association extent as defined for the specific version of this operation.
	 * 
	 * <p>The Collection returned from this operation is an immutable live 
	 * collection. This is, the collection will reflect any changes to the source, 
	 * however, the operations in the Collection interface cannot be used to 
	 * update the source.
	 *
	 * @return Collection
	 */
    public Collection<?> refAllLinks();
    
    /**
     * The <tt>refLinkExists</tt> operation returns true if and only if 
     * the supplied link is a member of the link set for this association 
     * object.
     *
     * <p>TypeMismatchException is raised if the parameters do not match 
     * the types of the respective association ends.
     *
     * @param firstEnd
     * @param secondEnd
     * @return
     */
    public boolean refLinkExists(RefObject firstEnd, RefObject secondEnd) throws JmiException;
    
    /**
     * The <tt>refQuery</tt> operations return a list containing all 
     * instance objects that are linked to the supplied <b>queryObject</b>
     * by links in the extent of this association object, where the links 
     * all have the <b>queryObject</b> at the <b>queryEnd</b>.
     *
     * <p>The <b>queryEnd</b> (or <b>queryEndName</b>) parameter must 
     * designate an association end for this association object. 
     * InvalidCallException is raised if this is not so.
     * 
     * <p>The <b>queryObject</b> parameter must be an instance object 
     * whose type is compatible with the type of the <b>queryEnd</b> (or 
     * <b>queryEndName</b>) of the association. TypeMismatchException is raised 
     * if this is not so.
     * 
     * <p>InvalidCallException is raised if the <b>queryEnd</b> parameter 
     * does not designate a valid object.
     * 
     * <p>InvalidNameException is raised when the <b>queryEnd</b> does not 
     * denote a valid object name.
     * 
     * <p>InvalidObjectException or NullPointerException is raised if the 
     * <b>queryObject</b> (or <b>queryEndName</b>) is non-existent, null, 
     * or inaccessible.
     *
     * @param queryEnd
     * @param queryObject
     * @return
     */
    public Collection<?> refQuery(RefObject queryEnd, RefObject queryObject) throws JmiException;
    public Collection<?> refQuery(String endName, RefObject queryObject) throws JmiException;
    
    /**
     * The <tt>refAddLink</tt> operation adds <i>newLink</i> into the set of 
     * links in the extent of this association object. If one or other of 
     * the association’s ends is ordered, the link is inserted after the 
     * last link with respect to that ordering.
     * 
     * <p>Both RefObject members of the <i>newLink</i> parameter should be valid 
     * instance objects.
     * 
     * <p>If the new link cannot be added for any reason other than that it 
     * already contains the link, an exception must be thrown (rather than 
     * returning false).
     * 
     * <p>The instance objects must be compatible with the association. 
     * TypeMismatchException is raised otherwise.
     * 
     * <p>Both instance objects must be valid instance objects. 
     * InvalidObjectException, NullPointerException is raised otherwise.
     * 
     * @param firstEnd
     * @param secondEnd
     * @return
     */
    public boolean refAddLink(RefObject firstEnd, RefObject secondEnd) throws JmiException;
    
    /**
     * The <tt>refRemoveLink</tt> operation removes the existing link from the association.
     * 
     * <p>The instance objects passed in must be compatible with the association. 
     * TypeMismatchException is raised otherwise.
     * 
     * <p>Returns true if the link was successfully removed.
     * 
     * <p>WrongSizeException is raised if removing the link causes the 
     * association end to violate the specified multiplicity.
     * 
     * @param firstEnd
     * @param secondEnd
     * @return
     */
    public boolean refRemoveLink(RefObject firstEnd, RefObject secondEnd) throws JmiException;
}
