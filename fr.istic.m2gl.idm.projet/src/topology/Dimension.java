/**
 */
package topology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link topology.Dimension#getSize <em>Size</em>}</li>
 *   <li>{@link topology.Dimension#isIsCircular <em>Is Circular</em>}</li>
 * </ul>
 * </p>
 *
 * @see topology.TopologyPackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends EObject {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see topology.TopologyPackage#getDimension_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link topology.Dimension#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Is Circular</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Circular</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Circular</em>' attribute.
	 * @see #setIsCircular(boolean)
	 * @see topology.TopologyPackage#getDimension_IsCircular()
	 * @model
	 * @generated
	 */
	boolean isIsCircular();

	/**
	 * Sets the value of the '{@link topology.Dimension#isIsCircular <em>Is Circular</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Circular</em>' attribute.
	 * @see #isIsCircular()
	 * @generated
	 */
	void setIsCircular(boolean value);

} // Dimension
