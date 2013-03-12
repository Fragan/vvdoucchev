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
		
		// Ouverture de la page
		selenium.open("/WebAppli/");
		selenium.click("link=Create new Address");
		selenium.waitForPageToLoad("30000");
		
		// Remplissage des champs
		selenium.click("id=_firstname_id");
		selenium.type("id=_firstname_id", "Firstname");
		selenium.type("id=_middlename_id", "Middlename");
		selenium.type("id=_lastname_id", "Lastname");
		selenium.type("id=_phone_id", "Phone");
		selenium.type("id=_email_id", "mail@mail.com");
		selenium.type("id=_address1_id", "Addr1");
		selenium.type("id=_address2_id", "Addr2");
		selenium.type("id=_city_id", "Rennes");
		selenium.type("id=_addressState_id", "State");
		selenium.type("id=_postalCode_id", "00000");
		selenium.type("id=_country_id", "CONTRY");
		selenium.click("id=proceed");
		selenium.waitForPageToLoad("30000");
		
		// Verification du contenu de la page retournee
		verifyTrue(selenium.isTextPresent("Firstname : Firstname\n\n\nMiddlename : Middlename\n\n\nLastname : Lastname\n\n\nPhone : Phone\n\n\nEmail : mail@mail.com\n\n\nAddress1 : Addr1\n\n\nAddress2 : Addr2\n\n\nCity : Rennes\n\n\nAddress State : State\n\n\nPostal Code : 00000\n\n\nCountry : CONTRY"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
