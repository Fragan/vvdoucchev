/**
 */
package topology.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import topology.Dimension;
import topology.TopologyFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DimensionTest extends TestCase {

	/**
	 * The fixture for this Dimension test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Dimension fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DimensionTest.class);
	}

	/**
	 * Constructs a new Dimension test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Dimension test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Dimension fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Dimension test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Dimension getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TopologyFactory.eINSTANCE.createDimension());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //DimensionTest
