package selenium;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class DeleteAddress extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testDeleteAddress() throws Exception {
		selenium.open("/test.roo/addresses?page=1&size=10");
		selenium.click("link=List all Addresses");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input.image");
		assertTrue(selenium.getConfirmation().matches("^Are you sure want to delete this item[\\s\\S]$"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
