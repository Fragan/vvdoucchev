package test.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Moderator;
import auction.ReserveAuction;
import auction.User;
import auction.impl.ModeratorImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.UserImpl;

public class TestReserveAuction {

	User user;
	ReserveAuction reserveAuction;

	@Before
	public void setUp() throws Exception {
		user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		reserveAuction = new ReserveAuctionImpl(user, "name", "description", 0,
				1, 1, 123456789);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test : getReservePrice() : int
	@Test
	public void testGetReservePrice() {
		assertEquals("Test : getReservePrice() : int",
				reserveAuction.getReservePrice(), 123456789);
	}

	// Test : setReservePrice(int) : void
	@Test
	public void testSetReservePrice() {
		reserveAuction.setReservePrice(987654321);
		assertEquals("Test : setReservePrice() : void",
				reserveAuction.getReservePrice(), 987654321);
	}

	// Test : setResPrice(Person, int) : String
	@Test
	public void testSetResPrice() {
		Moderator modo = new ModeratorImpl("firstName", "lastName", "email",
				"password", "address");
		
		reserveAuction.open();
		
		assertEquals("Test : setResPrice(Person, int) : String",
				reserveAuction.setResPrice(modo, 0), "ERROR: auctions is open");
	}

}
