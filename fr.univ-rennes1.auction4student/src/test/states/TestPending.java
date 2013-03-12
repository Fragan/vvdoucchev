package test.states;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.AuctionState;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.ModeratorImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;
import auction.states.Open;
import auction.states.Pending;

public class TestPending {

	private AuctionState state;
	private Auction auction;
	private User user;
	private User seller;

	@Before
	public void setUp() throws Exception {
		state = Pending.instance;

		seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new AuctionImpl(seller, "name", "description", 0, 10,
				0);
		user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(999999999);
	}

	// Test : Pending.cancelAuction() : String / Ok by modo
	@Test
	public void testCancelAuction1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");
		assertEquals("Test : Pending.cancelAuction() : String / Ok by modo",
				auction.cancelAuction(modo), "OK");
	}

	// Test : Pending.cancelAuction() : String / Ok by seller
	@Test
	public void testCancelAuction2() {
		assertEquals("Test : Pending.cancelAuction() : String/ Ok by seller",
				auction.cancelAuction(seller), "OK");
	}

	// Test : Pending.cancelAuction() : String / Fail
	@Test
	public void testCancelAuction3() {
		assertEquals("Test : Pending.cancelAuction() : String/ Ok by seller",
				auction.cancelAuction(user), "ERROR: you cannot cancel this auction");
	}

	// Test : Pending.close() : void
	@Test 
	public void testClose() {
		try {
			auction.close();
		} catch (Error error) {
			assertEquals("Test : Pending.close() : void", error.getMessage(), "Cannot close a pending auction.");
		}
	}

	// Test : Pending.getCurrentBid() : String
	@Test 
	public void testGetCurrentBid() {
		assertEquals("Test : Pending.getCurrentBid() : String", auction.getCurrentBid(), "ERROR: auction pending");
	}

	// Test : Pending.getName() : String
	@Test 
	public void testGetName() {
		auction.setState(state);

		assertEquals("Test : Pending.getName() : String", state.getName(), "PENDING");
	}

	// Test : Pending.join() : String
	@Test 
	public void testJoin() {
		assertEquals("Test : Pending.join() : String", auction.join((UserImpl) user), "ERROR: auction pending");
	}

	// Test : Pending.leave() : String
	@Test 
	public void testLeave() {
		assertEquals("Test : Pending.leave() : String", auction.leave((UserImpl) user), "ERROR: auction pending");
	}

	// Test : Pending.open() : void
	@Test 
	public void testOpen() {
		auction.open();

		assertEquals("Test : Pending.open() : void", auction.getState(), Open.instance);
	}

	// Test : Pending.placeBid() : String
	@Test 
	public void testPlaceBid() {
		assertEquals("Test : Pending.placeBid() : String", auction.placeBid((UserImpl) user, 5), "ERROR: auction pending");
	}

	// Test : Pending.postMessage() : String
	@Test 
	public void testPostMessage() {
		assertEquals("Test : Pending.postMessage() : String", auction.postMessage((UserImpl) user, "message"), "ERROR: auction pending");
	}

	// Test : Pending.setDesc() : String / Ok by modo
	@Test 
	public void testSetDesc1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");

		assertEquals("Test : Pending.setDesc() : String / Ok by modo", auction.setDesc(modo, "desc"), "OK");
	}

	// Test : Pending.setDesc() : String / Ok by seller
	@Test 
	public void testSetDesc2() {
		assertEquals("Test : Pending.setDesc() : String / Ok by seller", auction.setDesc(seller, "desc"), "OK");
	}

	// Test : Pending.setDesc() : String / Fail
	@Test 
	public void testSetDesc3() {
		assertEquals("Test : Pending.setDesc() : String / Fail", auction.setDesc((UserImpl) user, "desc"), "ERROR: you cannot modify this auction");
	}

	// Test : Pending.setEndDate() : String / Ok by modo
	@Test 
	public void testSetEndDate1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");

		assertEquals("Test : Pending.setEndDate() : String / Ok by modo", auction.setEndD(modo, 1), "OK");
	}

	// Test : Pending.setEndDate() : String / Ok by seller
	@Test 
	public void testSetEndDate2() {
		assertEquals("Test : Pending.setEndDate() : String / Ok by seller", auction.setEndD(seller, 1), "OK");
	}

	// Test : Pending.setEndDate() : String / Fail by user
	@Test 
	public void testSetEndDate3() {
		assertEquals("Test : Pending.setEndDate() : String / Fail by user", auction.setEndD((UserImpl) user, 1), "ERROR: you cannot modify this auction");
	}

	// Test : Pending.setEndDate() : String / Fail by endDate < startDate
	@Test 
	public void testSetEndDate4() {
		auction.setStartD(seller, 2);
		assertEquals("Test : Pending.setEndDate() : String", auction.setEndD(seller, 1), "ERROR: the end date must be greater than the start date");
	}

	// Test : Pending.setMinBid() : String / Ok by modo
	@Test 
	public void testSetMinBid1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");

		assertEquals("Test : Pending.setMinBid() : String / Ok by modo", auction.setMinBid(modo, 1), "OK");
	}

	// Test : Pending.setMinBid() : String / Ok by seller
	@Test 
	public void testSetMinBid2() {
		assertEquals("Test : Pending.setMinBid() : String / Ok by seller", auction.setMinBid(seller, 1), "OK");
	}

	// Test : Pending.setMinBid() : String / Fail by user
	@Test 
	public void testSetMinBid3() {
		assertEquals("Test : Pending.setMinBid() : String / Fail by user", auction.setMinBid((UserImpl) user, 1), "ERROR: you cannot modify this auction");
	}

	// Test : Pending.setMinBid() : String / Fail by minBid < 0
	@Test 
	public void testSetMinBid4() {
		assertEquals("Test : Pending.setMinBid() : String", auction.setMinBid(seller, 0), "ERROR: the minimum bid must be greater than 0");
	}

	// Test : Pending.setMinBid() : String / Fail by minBid > reservePrice
	@Test 
	public void testSetMinBid5() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 1);
		assertEquals("Test : Pending.setMinBid() : String", auction.setMinBid(seller, 1), "ERROR: the minimum bid must be less than the reserve price");
	}

	// Test : Pending.setMinBid() : String / Ok by minBid < reservePrice
	@Test 
	public void testSetMinBid6() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 2);
		assertEquals("Test : Pending.setMinBid() : String", auction.setMinBid(seller, 1), "OK");
	}

	// Test : Pending.setResPrice() : String / Ok by modo
	@Test 
	public void testSetResPrice1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 2);
		assertEquals("Test : Pending.setResPrice() : String / Ok by modo", ((ReserveAuction) auction).setResPrice(modo, 1), "OK");
	}

	// Test : Pending.setResPrice() : String / Ok by seller
	@Test 
	public void testSetResPrice2() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 2);
		assertEquals("Test : Pending.setResPrice() : String / Ok by seller", ((ReserveAuction) auction).setResPrice(seller, 1), "OK");
	}

	// Test : Pending.setResPrice() : String / Fail by user
	@Test 
	public void testSetResPrice3() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				0, 2);
		assertEquals("Test : Pending.setResPrice() : String / Fail by user", ((ReserveAuction) auction).setResPrice((UserImpl) user, 1), "ERROR: you cannot modify this auction");
	}

	// Test : Pending.setResPrice() : String / Fail by reservePrice <= minimumBid
	@Test 
	public void testSetResPrice4() {
		User seller = new UserImpl("firstName", "lastName", "email",
				"password", "address");
		auction = new ReserveAuctionImpl(seller, "name", "description", 0, 10,
				1, 2);
		assertEquals("Test : Pending.setResPrice() : String", ((ReserveAuction) auction).setResPrice(seller, 1), "ERROR: the reserve price must be greater than the minimum bid");
	}

	// Test : Pending.setStartDate() : String / Ok by modo
	@Test 
	public void testSetStartDate1() {
		ModeratorImpl modo = new ModeratorImpl("firstName", "lastName", "email", "password", "address");

		assertEquals("Test : Pending.setStartDate() : String / Ok by modo", auction.setStartD(modo, 1), "OK");
	}

	// Test : Pending.setStartDate() : String / Ok by seller
	@Test 
	public void testSetStartDate2() {
		assertEquals("Test : Pending.setStartDate() : String / Ok by seller", auction.setStartD(seller, 1), "OK");
	}

	// Test : Pending.setStartDate() : String / Fail by user
	@Test 
	public void testSetStartDate3() {
		assertEquals("Test : Pending.setStartDate() : String / Fail by user", auction.setStartD((UserImpl) user, 1), "ERROR: you cannot modify this auction");
	}

	// Test : Pending.setStartDate() : String / Fail by startDate > endDate
	@Test 
	public void testSetStartDate4() {
		assertEquals("Test : Pending.setStartDate() : String", auction.setStartD(seller, 11), "ERROR: the start date must be less than the end date");
	}

	// Test : Pending.setStartDate() : String / Fail by startDate < currentTime (Server)
	@Test 
	public void testSetStartDate5() {
		assertEquals("Test : Pending.setStartDate() : String", auction.setStartD(seller, ServerImpl.instance.getTick()), "ERROR: the start date must be greater than the current time");
	}
}
