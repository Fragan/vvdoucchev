package selenium;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class UpdateAddress extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testUpdateAddress() throws Exception {
		
		// Ouverture de la page
		selenium.open("/WebAppli/addresses?page=1&size=10");
		selenium.click("link=List all Addresses");
		selenium.waitForPageToLoad("30000");
		
		// Clique sur l'icone "modification"
		selenium.click("css=a[alt=\"Update Address\"] > img.image");
		selenium.waitForPageToLoad("30000");
		
		// Modification d'un champ
		selenium.click("id=_address1_id");
		selenium.type("id=_address1_id", "Addr1 Updated...");
		selenium.click("id=proceed");
		selenium.waitForPageToLoad("30000");
		
		// Verification du contenu de la page retournee
		verifyTrue(selenium.isTextPresent("Address1 : Addr1 Updated..."));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
