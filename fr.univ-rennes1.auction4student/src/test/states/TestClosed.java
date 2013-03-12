package test.states;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.UserImpl;
import auction.states.Closed;

public class TestClosed {

	private AuctionState state;
	private Auction auction;
	private User user;

	@Before
	public void setUp() throws Exception {
		state = Closed.instance;

		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new AuctionImpl(seller, "name", "description", 0, 10,
				0);
		user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(999999999);
	}

	// Test : Closed.cancelAuction() : String
	@Test
	public void testCancelAuction() {
		new BidImpl((UserImpl) user, auction, 10);

		auction.setState(state);

		assertEquals("Test : Closed.cancelAuction() : String",
				auction.cancelAuction(user), "ERROR: auction closed");
	}

	// Test : Closed.close() : void
	@Test 
	public void testClose() {
		auction.open();
		auction.close();
		try {
			auction.close();
		} catch (Error error) {
			assertEquals("Test : Closed.close() : void", error.getMessage(), "Cannot close a closed auction.");
		}
	}

	// Test : Closed.getCurrentBid() : String
	@Test 
	public void testGetCurrentBid() {
		new BidImpl((UserImpl) user, auction, 10);
		Bid lastBid = new BidImpl((UserImpl) user, auction, 15);

		auction.setState(state);

		assertEquals("Test : Closed.getCurrentBid() : String", auction.getCurrentBid(), lastBid.toString());
	}

	// Test : Closed.getName() : String
	@Test 
	public void testGetName() {
		auction.setState(state);

		assertEquals("Test : Closed.getName() : String", state.getName(), "CLOSED");
	}

	// Test : Closed.join() : String
	@Test 
	public void testJoin() {
		auction.setState(state);

		assertEquals("Test : Closed.join() : String", auction.join((UserImpl) user), "ERROR: auction closed");
	}

	// Test : Closed.leave() : String
	@Test 
	public void testLeave() {
		auction.setState(state);

		assertEquals("Test : Closed.leave() : String", auction.leave((UserImpl) user), "ERROR: auction closed");
	}

	// Test : Closed.open() : void
	@Test 
	public void testOpen() {
		auction.open();
		auction.close();
		try {
			auction.open();
		} catch (Error error) {
			assertEquals("Test : Closed.open() : void", error.getMessage(), "Cannot open a closed auction.");
		}
	}

	// Test : Closed.placeBid() : String
	@Test 
	public void testPlaceBid() {
		auction.setState(state);

		assertEquals("Test : Closed.placeBid() : String", state.placeBid(auction, (UserImpl) user, 5), "ERROR: auction closed");
	}

	// Test : Closed.postMessage() : String
	@Test 
	public void testPostMessage() {
		auction.setState(state);

		assertEquals("Test : Closed.postMessage() : String", state.postMessage(auction, (UserImpl) user, "message"), "ERROR: auction closed");
	}

	// Test : Closed.setDesc() : String
	@Test 
	public void testSetDesc() {
		auction.setState(state);

		assertEquals("Test : Closed.setDesc() : String", state.setDesc(auction, (UserImpl) user, "desc"), "ERROR: auction closed");
	}

	// Test : Closed.setEndDate() : String
	@Test 
	public void testSetEndDate() {
		auction.setState(state);

		assertEquals("Test : Closed.setEndDate() : String", state.setEndDate(auction, (UserImpl) user, 1), "ERROR: auction closed");
	}

	// Test : Closed.setMinBid() : String
	@Test 
	public void testSetMinBid() {
		auction.setState(state);

		assertEquals("Test : Closed.setMinBid() : String", state.setMinBid(auction, (UserImpl) user, 1), "ERROR: auction closed");
	}

	// Test : Closed.setResPrice() : String
	@Test 
	public void testSetResPrice() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 0);
		
		auction.setState(state);

		assertEquals("Test : Closed.setResPrice() : String", state.setResPrice((ReserveAuction) auction, (UserImpl) user, 1), "ERROR: auction closed");
	}

	// Test : Closed.setStartDate() : String
	@Test 
	public void testSetStartDate() {
		auction.setState(state);

		assertEquals("Test : Closed.setStartDate() : String", state.setStartDate(auction, (UserImpl) user, 1), "ERROR: auction closed");
	}
}
