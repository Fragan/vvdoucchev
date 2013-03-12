package test.impl;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.util.Iterator;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.Person;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.BulletinBoardImpl;
import auction.impl.UserImpl;
import auction.states.Closed;
import auction.states.Open;

public class TestAuction {

	private Auction auction;
	private User seller;
	private String name = "name";
	private String description = "description";
	private int startDate = 0;
	private int endDate = 10;
	private int minimumBid = 0;

	@Before
	public void setUp() throws Exception {
		seller = new UserImpl("firstNam", "lastName", "email", "password",
				"address");
		auction = new AuctionImpl(seller, name, description, startDate,
				endDate, minimumBid);
	}

	// Test : Auction.getSeller() : User
	@Test
	public void TestGetSeller() {
		assertEquals("Test : Auction.getSeller()", auction.getSeller(), seller);
	}

	// Test : Auction.getName() : String
	@Test
	public void TestGetName() {
		assertEquals("Test : Auction.getName()", auction.getName(), name);
	}

	// Test : Auction.getDescription() : String
	@Test
	public void TestGetDescription() {
		assertEquals("Test : Auction.getDescription()",
				auction.getDescription(), description);
	}

	// Test : Auction.setDescription()
	@Test
	public void TestSetDescription() {
		String desc = "newDesc";
		auction.setDescription(desc);
		assertEquals("Test : Auction.setDescription()",
				auction.getDescription(), desc);
	}

	// Test : Auction.getStartDate() : int
	@Test
	public void TestGetStartDate() {
		assertEquals("Test : Auction.getStartDate()", auction.getStartDate(),
				startDate);
	}

	// Test : Auction.setStartDate()
	@Test
	public void TestSetStartDate() {
		int newDate = 1;
		auction.setStartDate(newDate);
		assertEquals("Test : Auction.setStartDate()", auction.getStartDate(),
				newDate);
	}

	// Test : Auction.getStartD() : String
	@Test
	public void TestGetStartD() {
		assertEquals("Test : Auction.getStartD()", auction.getStartD(),
				Integer.toString(startDate));
	}

	// Test : Auction.getEndDate() : int
	@Test
	public void TestGetEndDate() {
		assertEquals("Test : Auction.getEndDate()", auction.getEndDate(),
				endDate);
	}

	// Test : Auction.setEndDate()
	@Test
	public void TestSetEndDate() {
		int newDate = 9;
		auction.setEndDate(newDate);
		assertEquals("Test : Auction.setEndDate()", auction.getEndDate(),
				newDate);
	}

	// Test : Auction.getEndD() : String
	@Test
	public void TestGetEndD() {
		assertEquals("Test : Auction.getEndD()", auction.getEndD(),
				Integer.toString(endDate));
	}

	// Test : Auction.getState() : State
	@Test
	public void TestGetState() {
		AuctionState state = new Open();
		auction.setState(state);
		assertEquals("Test : Auction.getState()", auction.getState(), state);
	}

	// Test : Auction.getBulletinBoard() : BulletinBoard
	@Test
	public void TestGetBulletinBoard() {
		assertTrue("Test : Auction.getBulletionBoard()",
				auction.getBulletinBoard() instanceof BulletinBoardImpl);
	}

	// Test : Auction.getMinimumBid() : int
	@Test
	public void TestGetMinimumBid() {
		assertEquals("Test : Auction.getMinimumBid()", auction.getMinimumBid(),
				minimumBid);
	}

	// Test : Auction.setMinimumBid()
	@Test
	public void TestSetMinimumBid() {
		int newMin = 1;
		auction.setMinimumBid(newMin);
		assertEquals("Test : Auction.setMinimumBid()", auction.getMinimumBid(),
				newMin);
	}

	// Test : Auction.getMinBid() : String
	@Test
	public void TestGetMinBid() {
		assertEquals("Test : Auction.getMinBid()", auction.getMinBid(),
				Integer.toString(minimumBid));
	}

	// Test : Auction.close()
	@Test
	public void TestClose() {
		AuctionState state = new Open();
		auction.setState(state);
		auction.close();
		assertTrue("Test : Auction.close()",
				auction.getState() instanceof Closed);
	}

	// Test : Auction.getMaxBid() : Bid
	@Test
	public void TestGetMaxBid() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(500);

		AuctionState state = new Open();
		// Bid n�1
		state.placeBid(auction, (UserImpl) user, 5);
		// Bid n�2
		state.placeBid(auction, (UserImpl) user, 6);
		// Bid n�3
		state.placeBid(auction, (UserImpl) user, 3);

		assertEquals("Test : Auction.getMaxBid() : Bid", auction.getMaxBid()
				.getAmount(), 6);
	}

	// Test : Auction.getBidHistory() : String
	@Test
	public void TestGetBidHistory1() {
		assertEquals("Test : Auction.getBidHistory() : String",
				auction.getBidHistory(),
				"");
	}

	// Test : Auction.getBidHistory2() : String
	@Test
	public void TestGetBidHistory2() {
		AuctionState state = new Open();

		// Bid n�1
		User user1 = new UserImpl("firstName", "lastName", "email1",
				"password", "address");
		user1.getAccount().incCredit(500);

		state.placeBid(auction, (UserImpl) user1, 5);

		// Bid n�2
		User user2 = new UserImpl("firstName", "lastName", "email2",
				"password", "address");
		user2.getAccount().incCredit(500);

		state.placeBid(auction, (UserImpl) user2, 6);

		assertEquals("Test : Auction.getBidHistory() : String",
				auction.getBidHistory(),
				"email1 5" + System.getProperty("line.separator") + "email2 6");
	}

	// Test : Auction.toString() : String
	@Test
	public void testToString() {
		assertEquals("Test : Auction.toString() : String", auction.toString(), "name description PENDING 10");
	}
}