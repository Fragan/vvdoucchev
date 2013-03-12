package com.sun.demo.addressbook;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JButtonLocator;

public class TestBtDeleteDisableWithoutSelectedItem extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestBtDeleteDisableWithoutSelectedItem() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Test si le bouton Delete est desactive quand aucune personne de la list n'est selectionnee
	 */
	public void testBtDeleteDisableWithoutSelectedItem() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
	}

}