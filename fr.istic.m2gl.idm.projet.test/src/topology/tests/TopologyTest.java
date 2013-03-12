/**
 */
package topology.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import topology.Topology;
import topology.TopologyFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopologyTest extends TestCase {

	/**
	 * The fixture for this Topology test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Topology fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TopologyTest.class);
	}

	/**
	 * Constructs a new Topology test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Topology test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Topology fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Topology test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Topology getFixture() {
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
		setFixture(TopologyFactory.eINSTANCE.createTopology());
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

} //TopologyTest
