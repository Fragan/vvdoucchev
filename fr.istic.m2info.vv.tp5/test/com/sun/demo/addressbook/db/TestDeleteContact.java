package com.sun.demo.addressbook.db;

import java.io.FileInputStream;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.locator.JListLocator;

/**
 * To the generated class by WindowTesterPro, you have to override setUp() to
 * establish the connection to the DB in order to test it.
 * 
 * @author Juan
 * 
 */
public class TestDeleteContact extends UITestCaseSwing {

	private FlatXmlDataSet expected;
	private IDatabaseConnection connection;
	private JdbcDatabaseTester tester;
	private IDataSet actual;

	@Override
	protected void setUp() throws Exception {
		
		WT.setLocaleToCurrent();
				
		String dbName = "DefaultAddressBook";
		FlatXmlDataSet initialData = new FlatXmlDataSetBuilder()
				.build(new FileInputStream("data/dataset2addresses.xml"));
		expected = new FlatXmlDataSetBuilder().build(new FileInputStream(
				"data/dataset1address.xml"));
		new AddressDao();
		tester = new JdbcDatabaseTester(
				"org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:" + dbName,
				"addressuser", "addressuser", "APP");
		connection = tester.getConnection();
		DatabaseOperation.CLEAN_INSERT.execute(connection, initialData);
		run();
	}

	/**
	 * Create an Instance
	 */
	public TestDeleteContact() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Test - Un contact est bien supprime dans la BDD apres la selection d'un contact dans la liste puis l'appuie sur le bouton Delete
	 */
	public void testDeleteContact() throws Exception {
		IUIContext ui = getUI();
		
		// Selection d'une personne et edition de son adresse
		ui.click(new JListLocator("LECRIVAIN, Benoit Alexandre"));
		ui.click(new JButtonLocator("Delete"));
		
		actual = connection.createDataSet();
		String tableName = "Address";
		ITable expectedTable = expected.getTable(tableName);
		ITable actualTable = actual.getTable(tableName);
		Column[] filter = expected.getTableMetaData(tableName).getColumns();
		ITable actualFilteredTable = DefaultColumnFilter.includedColumnsTable(actualTable, 
	            filter);
		Assertion.assertEquals(expectedTable, actualFilteredTable);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		connection = tester.getConnection();
		//DatabaseOperation.DELETE_ALL.execute(connection, actual);
		connection.close();
	}

}