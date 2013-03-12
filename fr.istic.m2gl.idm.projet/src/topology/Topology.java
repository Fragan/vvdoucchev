/**
 */
package topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link topology.Topology#getNeighborSize <em>Neighbor Size</em>}</li>
 *   <li>{@link topology.Topology#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see topology.TopologyPackage#getTopology()
 * @model
 * @generated
 */
public interface Topology extends EObject {
	/**
	 * Returns the value of the '<em><b>Neighbor Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighbor Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighbor Size</em>' attribute.
	 * @see #setNeighborSize(int)
	 * @see topology.TopologyPackage#getTopology_NeighborSize()
	 * @model
	 * @generated
	 */
	int getNeighborSize();

	/**
	 * Sets the value of the '{@link topology.Topology#getNeighborSize <em>Neighbor Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neighbor Size</em>' attribute.
	 * @see #getNeighborSize()
	 * @generated
	 */
	void setNeighborSize(int value);

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link topology.Dimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see topology.TopologyPackage#getTopology_Dimensions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Dimension> getDimensions();

} // Topology
