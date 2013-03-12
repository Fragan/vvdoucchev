package com.sun.demo.addressbook;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;

public class TestBtSaveEnableWhenTextFieldsNotEmpty extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestBtSaveEnableWhenTextFieldsNotEmpty() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Le bouton « save » doit être active si les champs Lastname, Surname, Middlename et Email ne sont pas vides. 
	 */
	public void testBtSaveEnableWhenTextFieldsNotEmpty() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		
		// Add text on fields Lastname, Firstname, Middlename and Email
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("L");
		ui.click(new LabeledTextLocator("First Name"));
		ui.enterText("F");
		ui.click(new LabeledTextLocator("Middle Name"));
		ui.enterText("M");
		ui.click(new LabeledTextLocator("Email"));
		ui.enterText("E");
		
		ui.assertThat(new JButtonLocator("Save").isEnabled());
	}

}