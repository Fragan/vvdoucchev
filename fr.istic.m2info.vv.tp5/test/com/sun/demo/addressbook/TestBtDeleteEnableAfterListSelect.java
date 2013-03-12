package com.sun.demo.addressbook;
import java.io.FileInputStream;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.locator.JListLocator;

public class TestBtDeleteEnableAfterListSelect extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestBtDeleteEnableAfterListSelect() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		
		WT.setLocaleToCurrent();
				
		String dbName = "DefaultAddressBook";
		FlatXmlDataSet initialData = new FlatXmlDataSetBuilder()
				.build(new FileInputStream("data/dataset1address.xml"));
		JdbcDatabaseTester tester = new JdbcDatabaseTester(
				"org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:" + dbName,
				"addressuser", "addressuser", "APP");
		IDatabaseConnection connection = tester.getConnection();
		DatabaseOperation.CLEAN_INSERT.execute(connection, initialData);
		run();
	}

	/**
	 * Test si le bouton Delete est actif apres selection d'une personne de la list
	 */
	public void testTestBtDeleteEnableAfterListSelect() throws Exception {
		IUIContext ui = getUI();
		
		// Test si le bouton Delete est actif apres selection d'une personne de la list
		ui.click(new JListLocator("CADAVID, Juan Jose"));
		ui.assertThat(new JButtonLocator("Delete").isEnabled());
	}

}