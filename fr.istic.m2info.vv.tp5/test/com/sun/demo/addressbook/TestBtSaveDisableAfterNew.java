package com.sun.demo.addressbook;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JButtonLocator;

public class TestBtSaveDisableAfterNew extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestBtSaveDisableAfterNew() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Le bouton « save » doit etre desactive apres avoir clique sur le bouton « new »
	 */
	public void testBtSaveDisableAfterNew() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
	}

}