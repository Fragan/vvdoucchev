package test.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Moderator;
import auction.impl.ModeratorImpl;

public class testModerator {

	private Moderator moderator;
	private String firstName = "firstName";
	private String lastName = "lastName";
	private String email = "email";
	private String password = "password";
	private String address = "adress";

	@Before
	public void setUp() throws Exception {
		moderator = new ModeratorImpl(firstName, lastName, email, password, address);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test : Moderator.getFirstName() : String
	@Test
	public void testGetFirstName() {
		assertEquals("Test : Moderator.getFirstName()", moderator.getFirstName(), firstName);
	}

	// Test : Moderator.getFirstName() : String
	@Test
	public void testGetLastName() {
		assertEquals("Test : Moderator.getLastName()", moderator.getLastName(), lastName);
	}

	// Test : Moderator.getEmail() : String
	@Test
	public void testGetEmail() {
		assertEquals("Test : Moderator.getEmail()", moderator.getEmail(), email);
	}

	// Test : Moderator.testGetPassword() : String
	@Test
	public void testGetPassword() {
		assertEquals("Test : Moderator.getModerator()", moderator.getPassword(), password);
	}

	// Test : Moderator.getAdress() : String
	@Test
	public void testGetAdres() {
		assertEquals("Test : Moderator.getFirstName()", moderator.getAdress(), address);
	}
}
