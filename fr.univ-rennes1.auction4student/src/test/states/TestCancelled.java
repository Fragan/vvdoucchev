package test.states;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.UserImpl;

public class TestCancelled {

	Auction auction;
	User seller;

	@Before
	public void setUp() throws Exception {
		seller = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction = new AuctionImpl(seller, "name", "description", 0, 10, 1);
		auction.cancelAuction(seller);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test : Cancelled.cancelAuction(Auction, Person) : String
	@Test
	public void testCancelAuction() {
		assertEquals(
				"Test : Cancelled.cancelAuction(Auction, Person) : String",
				auction.cancelAuction(seller),
				"ERROR: auction already cancelled");
	}

	// Test : Cancelled.close(Auction) : void
	@Test(expected = Error.class)
	public void testClose() {
		auction.close();
	}

	// Test : Cancelled.getCurrentBid(Auction) : String
	@Test
	public void testGetCurrentBid() {
		assertEquals("Test : Cancelled.getCurrentBid(Auction) : String",
				auction.getCurrentBid(), "ERROR: auction cancelled");
	}

	// Test : Cancelled.getName() : String
	@Test
	public void testGetName() {
		assertEquals("Test : Cancelled.getName() : String", auction.getState()
				.getName(), "CANCELLED");
	}

	// Test : Cancelled.join(Auction, User) : String
	@Test
	public void testJoin() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		assertEquals("Test : Cancelled.join(Auction, User) : String",
				auction.join((UserImpl) user), "ERROR: auction cancelled");
	}

	// Test : Cancelled.leave(Auction, User) : String
	@Test
	public void testLeave() {
		assertEquals("Test : Cancelled.leave(Auction, User) : String",
				auction.leave(seller), "ERROR: auction cancelled");
	}

	// Test : Cancelled.open(Auction) : String
	@Test(expected = Error.class)
	public void testOpen() {
		auction.open();
	}

	// Test : Cancelled.placeBid(AUction, UserImpl, int) : String
	@Test
	public void testPlaceBid() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		assertEquals(
				"Test : Cancelled.placeBid(AUction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user, 10),
				"ERROR: auction cancelled");
	}

	// Test : Cancelled.postMessage(Auction, Person, String) : String
	@Test
	public void testPostMessage() {
		assertEquals(
				"Test : Cancelled.postMessage(Auction, Person, String) : String",
				auction.postMessage(seller, "message"),
				"ERROR: auction cancelled");
	}

	// Test : Cancelled.setDesc(Auction, Person, String) : String
	@Test
	public void testSetDesc() {
		assertEquals(
				"Test : Cancelled.setDesc(Auction, Person, String) : String",
				auction.setDesc(seller, "value"), "ERROR: auction cancelled");
	}

	// Test : Cancelled.setEndDate(Auction, Person, int) : String
	@Test
	public void testSetEndDate() {
		assertEquals(
				"Test : Cancelled.setEndDate(Auction, Person, int) : String",
				auction.setEndD(seller, 10), "ERROR: auction cancelled");
	}

	// Test : Cancelled.setMinBid(Auction, Person, int) : String
	@Test
	public void testSetMinBid() {
		assertEquals(
				"Test : Cancelled.setMinBid(Auction, Person, int) : String",
				auction.setMinBid(seller, 10), "ERROR: auction cancelled");
	}

	// Test : Cancelled.setResPrice(ReserveAuction, Person, int) : String
	@Test
	public void testSetResPrice() {
		ReserveAuction reserveAuction = new ReserveAuctionImpl(seller, "name",
				"description", 0, 10, 1, 10);
		reserveAuction.cancelAuction(seller);

		assertEquals(
				"Test : Cancelled.setResPrice(ReserveAuction, Person, int) : String",
				reserveAuction.setResPrice(seller, 43),
				"ERROR: auction cancelled");
	}

	// Test : Cancelled.setStartDate(Auction, Person, int) : String
	@Test
	public void testSetStartDate() {
		assertEquals(
				"Test : Cancelled.setStartDate(Auction, Person, int) : String",
				auction.setStartD(seller, 10), "ERROR: auction cancelled");
	}

}
