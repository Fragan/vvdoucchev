package com.sun.demo.addressbook;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;

public class TestIHMStartupTextFieldsDisable extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestIHMStartupTextFieldsDisable() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Test si les textfields sont desactives lors de la creation de l'IHM
	 */
	public void testIHMStartupTextFieldsDisable() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new LabeledTextLocator("Last Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("First Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Middle Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Address 1").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Address 2").isEnabled(false));		
		ui.assertThat(new LabeledTextLocator("Email").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Phone").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("City").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("State").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("ZIP").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Country").isEnabled(false));
	}

}