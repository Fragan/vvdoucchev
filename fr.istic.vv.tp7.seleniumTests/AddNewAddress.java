package selenium;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class AddNewAddress extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testAddNewAddress() throws Exception {
		selenium.open("/test.roo/");
		selenium.click("link=Create new Address");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=_firstname_id");
		selenium.type("id=_firstname_id", "Raphael");
		selenium.type("id=_middlename_id", "Middle");
		selenium.type("id=_lastname_id", "Chevallier");
		selenium.type("id=_phone_id", "0666666666");
		selenium.type("id=_email_id", "raph@mail.com");
		selenium.type("id=_address1_id", "Addr1");
		selenium.type("id=_address2_id", "Addr2");
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
