package fr.istic.vv.tp7.domain.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class TestCreateNewAddress extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testCreateNewAddress() throws Exception {
		selenium.open("/WebAppli/addresses?form");
		selenium.click("link=Create new Address");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=_firstname_id");
		selenium.type("id=_firstname_id", "Marc");
		selenium.type("id=_middlename_id", "Oo");
		selenium.type("id=_lastname_id", "Douchement");
		selenium.type("id=_phone_id", "06 666 666 66");
		selenium.type("id=_email_id", "marc@mail.com");
		selenium.type("id=_address1_id", "Cité U");
		selenium.type("id=_address2_id", "Beaulieu");
		selenium.type("id=_city_id", "Rennes");
		selenium.type("id=_addressState_id", "Bretagne");
		selenium.type("id=_postalCode_id", "35700");
		selenium.type("id=_country_id", "France");
		selenium.click("id=proceed");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
