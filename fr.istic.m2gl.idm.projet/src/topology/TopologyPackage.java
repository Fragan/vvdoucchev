/**
 */
package topology;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see topology.TopologyFactory
 * @model kind="package"
 * @generated
 */
public interface TopologyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "topology";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://topology/1.01.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "topology";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopologyPackage eINSTANCE = topology.impl.TopologyPackageImpl.init();

	/**
	 * The meta object id for the '{@link topology.impl.TopologyImpl <em>Topology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see topology.impl.TopologyImpl
	 * @see topology.impl.TopologyPackageImpl#getTopology()
	 * @generated
	 */
	int TOPOLOGY = 0;

	/**
	 * The feature id for the '<em><b>Neighbor Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__NEIGHBOR_SIZE = 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DIMENSIONS = 1;

	/**
	 * The number of structural features of the '<em>Topology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link topology.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see topology.impl.DimensionImpl
	 * @see topology.impl.TopologyPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__SIZE = 0;

	/**
	 * The feature id for the '<em><b>Is Circular</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__IS_CIRCULAR = 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link topology.Topology <em>Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topology</em>'.
	 * @see topology.Topology
	 * @generated
	 */
	EClass getTopology();

	/**
	 * Returns the meta object for the attribute '{@link topology.Topology#getNeighborSize <em>Neighbor Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Neighbor Size</em>'.
	 * @see topology.Topology#getNeighborSize()
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_NeighborSize();

	/**
	 * Returns the meta object for the containment reference list '{@link topology.Topology#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimensions</em>'.
	 * @see topology.Topology#getDimensions()
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_Dimensions();

	/**
	 * Returns the meta object for class '{@link topology.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see topology.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link topology.Dimension#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see topology.Dimension#getSize()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Size();

	/**
	 * Returns the meta object for the attribute '{@link topology.Dimension#isIsCircular <em>Is Circular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Circular</em>'.
	 * @see topology.Dimension#isIsCircular()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_IsCircular();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TopologyFactory getTopologyFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link topology.impl.TopologyImpl <em>Topology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see topology.impl.TopologyImpl
		 * @see topology.impl.TopologyPackageImpl#getTopology()
		 * @generated
		 */
		EClass TOPOLOGY = eINSTANCE.getTopology();

		/**
		 * The meta object literal for the '<em><b>Neighbor Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__NEIGHBOR_SIZE = eINSTANCE.getTopology_NeighborSize();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__DIMENSIONS = eINSTANCE.getTopology_Dimensions();

		/**
		 * The meta object literal for the '{@link topology.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see topology.impl.DimensionImpl
		 * @see topology.impl.TopologyPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__SIZE = eINSTANCE.getDimension_Size();

		/**
		 * The meta object literal for the '<em><b>Is Circular</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__IS_CIRCULAR = eINSTANCE.getDimension_IsCircular();

	}

} //TopologyPackage
