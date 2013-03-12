package test.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.Bid;
import auction.Moderator;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.ModeratorImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.UserImpl;
import auction.states.Closed;

public class TestOpen {

	User seller;
	Auction auction;

	@Before
	public void setUp() throws Exception {
		seller = new UserImpl("firstNameSeller", "lastNameSeller",
				"emailSeller", "passwordSeller", "addressSeller");
		auction = new AuctionImpl(seller, "name", "description", 0, 10, 1);
		auction.open();
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test : Open.getCurrentBid() : String [b == null]
	@Test
	public void testGetCurrent1() {
		assertEquals("Test : Open.getCurrentBid() : String [b == null]",
				auction.getCurrentBid(), "ERROR: no current bid");
	}

	// Test : Open.getCurrentBid() : String [b != null]
	@Test
	public void testGetCurrent2() {
		User user = new UserImpl("firstName", "lastName", "emailUser",
				"password", "address");
		Bid bid = new BidImpl((UserImpl) user, auction, 10);

		auction.getBids().add((BidImpl) bid);

		assertEquals("Test : Open.getCurrentBid() : String [b != null]",
				auction.getCurrentBid(), "emailUser 10");
	}

	// Test : Open.join(Auctoin, User) : String
	@Test
	public void testJoin1() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		assertEquals("Test : Open.join(Auctoin, User) : String",
				auction.join((UserImpl) user), "OK");
	}

	// Test : Open.join(Auctoin, User) : String
	// [auction.getJoinedUsers().contains(user)]
	@Test
	public void testJoin2() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction.join((UserImpl) user);

		assertEquals(
				"Test : Open.join(Auctoin, User) : String [auction.getJoinedUsers().contains(user)]",
				auction.join((UserImpl) user), "ERROR: auction already joined");
	}

	// Test : Open.leave(Auction, User) : String
	@Test
	public void testLeave1() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction.join((UserImpl) user);

		assertEquals("Test : Open.leave(Auction, User) : String",
				auction.leave(user), "OK");
		assertFalse("Test : Open.leave(Auction, User) : String", auction
				.getJoinedUsers().contains(user));
	}

	// Test : Open.leave(Auction, User) : String
	// [!auction.getJoinedUsers().contains(user)]
	@Test
	public void testLeave2() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");

		assertEquals(
				"Test : Open.leave(Auction, User) : String [!auction.getJoinedUsers().contains(user)]",
				auction.leave(user), "ERROR: auction not joined");
	}

	// Test : Open.leave(Auction, User) : String [b!=null && b.getUser()==user]
	@Test
	public void testLeave3() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction.join((UserImpl) user);

		Bid bid = new BidImpl((UserImpl) user, auction, 123);
		auction.getBids().add((BidImpl) bid);

		assertEquals(
				"Test : Open.leave(Auction, User) : String [b.getUser()==user]",
				auction.leave(user),
				"ERROR: you cannot leave an auction when you have the best bid");
	}

	// Test : Open.leave(Auction, User) : String [b!=null && b.getUser()!=user]
	@Test
	public void testLeave4() {
		User user1 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction.join((UserImpl) user1);
		Bid bid1 = new BidImpl((UserImpl) user1, auction, 123);
		auction.getBids().add((BidImpl) bid1);

		User user2 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auction.join((UserImpl) user2);
		Bid bid2 = new BidImpl((UserImpl) user2, auction, 321);
		auction.getBids().add((BidImpl) bid2);

		assertEquals(
				"Test : Open.leave(Auction, User) : StringTest : Open.leave(Auction, User) : String [b!=null && b.getUser()!=user]",
				auction.leave(user1), "OK");
		assertTrue(
				"Test : Open.leave(Auction, User) : StringTest : Open.leave(Auction, User) : String [b!=null && b.getUser()!=user]",
				auction.getJoinedUsers().contains(user2));
	}

	// Test : Open.open(Auction) : void
	@Test(expected = Error.class)
	public void testOpen() {
		auction.open();
	}

	// Test : Open.postMessage(Auction, Person, String) : String
	// [!auction.getJoinedUsers().contains(person)]
	@Test
	public void testPostMessage1() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.postMessage(user, "message"),
				"ERROR: you cannot post on this bulletin board");
	}

	// Test : Open.postMessage(Auction, Person, String) : String
	// [!auction.getJoinedUsers().contains(person)]
	@Test
	public void testPostMessage2() {
		Moderator moderator = new ModeratorImpl("firstName", "lastName",
				"emailModerator", "password", "address");
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.postMessage(moderator, "messageModerator"), "OK");
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.getBulletinBoard().getMess(),
				"1 emailModerator messageModerator");
	}

	// Test : Open.postMessage(Auction, Person, String) : String
	// [auction.getSeller()!=person]
	@Test
	public void testPostMessage3() {
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.postMessage(seller, "messageSeller"), "OK");
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.getBulletinBoard().getMess(),
				"1 emailSeller messageSeller");
	}

	// Test : Open.postMessage(Auction, Person, String) : String
	// [auction.getJoinedUsers().contains(person)]
	@Test
	public void testPostMessage4() {
		User user = new UserImpl("firstName", "lastName", "emailUser",
				"password", "address");
		auction.join((UserImpl) user);

		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.postMessage(user, "messageUser"), "OK");
		assertEquals(
				"Test : Open.postMessage(Auction, Person, String) : String [auction.getSeller()==person]",
				auction.getBulletinBoard().getMess(), "1 emailUser messageUser");
	}

	// Test : Open.placeBid(Auction, UserImpl, int) : String
	@Test
	public void testPlaceBid1() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(999999999);

		assertEquals("Test : Open.placeBid(Auction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user, 123456789), "OK");
	}

	// Test : Open.placeBid(Auction, UserImpl, int) : String
	// [amount<auction.minimumAmount()]
	@Test
	public void testPlaceBid2() {
		User user1 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user1.getAccount().incCredit(999999999);
		auction.join((UserImpl) user1);
		auction.placeBid((UserImpl) user1, 123456789);

		User user2 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user2.getAccount().incCredit(999999999);
		auction.join((UserImpl) user2);

		assertEquals("Test : Open.placeBid(Auction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user2, 11111),
				"ERROR: insufficient amount");
	}

	// Test : Open.placeBid(Auction, UserImpl, int) : String
	// [amount>user.getAccount().getFreeCredit()]
	@Test
	public void testPlaceBid3() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(2);
		auction.join((UserImpl) user);

		assertEquals("Test : Open.placeBid(Auction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user, 123456789),
				"ERROR: insufficient free credit");
	}

	// Test : Open.placeBid(Auction, UserImpl, int) : String
	// [auction.getMaxBid()!=null]
	@Test
	public void testPlaceBid4() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(20);
		auction.join((UserImpl) user);

		auction.placeBid((UserImpl) user, 18);

		assertEquals("Test : Open.placeBid(Auction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user, 39),
				"ERROR: insufficient free credit");
	}

	// Test : Open.placeBid(Auction, UserImpl, int) : String
	// [auction.getMaxBid()!=null]
	@Test
	public void testPlaceBid5() {
		User user1 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user1.getAccount().incCredit(80);
		auction.join((UserImpl) user1);
		auction.placeBid((UserImpl) user1, 20);

		User user2 = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user2.getAccount().incCredit(100);
		auction.join((UserImpl) user2);
		auction.placeBid((UserImpl) user2, 60);

		assertEquals("Test : Open.placeBid(Auction, UserImpl, int) : String",
				auction.placeBid((UserImpl) user1, 82),
				"ERROR: insufficient free credit");
	}

	// Test : Open.close(Auction) : void
	@Test
	public void testClose1() {
		auction.close();
		assertEquals("Test : Open.close(Auction) : void", auction.getState(),
				Closed.instance);
	}

	// Test : Open.close(Auction) : void
	@Test
	public void testClose2() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(10);

		auction.join((UserImpl) user);
		auction.placeBid((UserImpl) user, 6);

		auction.close();
		assertEquals("Test : Open.close(Auction) : void", user.getAccount()
				.getCredit(), 10 - 6);
		assertEquals("Test : Open.close(Auction) : void", seller.getAccount().getCredit(), 6);
	}

	// Test : Open.close(Auction) : void
	@Test
	public void testClose3() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(10);

		ReserveAuction reserveAuction = new ReserveAuctionImpl(seller, "name",
				"description", 0, 10, 1, 4);
		reserveAuction.open();
		reserveAuction.join((UserImpl) user);
		reserveAuction.placeBid((UserImpl) user, 3);

		reserveAuction.close();
		assertEquals("Test : Open.close(Auction) : void", user.getAccount()
				.getCredit(), 10);
		assertEquals("Test : Open.close(Auction) : void", seller.getAccount()
				.getCredit(), 0);
	}

	// Test : Open.close(Auction) : void
	@Test
	public void testClose4() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(10);

		ReserveAuction reserveAuction = new ReserveAuctionImpl(seller, "name",
				"description", 0, 10, 1, 4);
		reserveAuction.open();
		reserveAuction.join((UserImpl) user);
		reserveAuction.placeBid((UserImpl) user, 6);

		reserveAuction.close();
		assertEquals("Test : Open.close(Auction) : void", user.getAccount()
				.getCredit(), 10 - 6);
		assertEquals("Test : Open.close(Auction) : void", seller.getAccount()
				.getCredit(), 6);

	}

	// Test : Open.cancelAuction(Auction, Person) : String
	@Test
	public void testCancelAuction() {
		assertEquals("Test : Open.cancelAuction(Auction, Person) : String",
				auction.cancelAuction(seller), "ERROR: auction open");
	}

	// Test : Open.getName() : String
	@Test
	public void testGetName() {
		assertEquals("Test : Open.getName() : String", auction.getState()
				.getName(), "OPEN");
	}

	// Test : Open.setDesc(Auction, Person, String) : String
	@Test
	public void testSetDesc() {
		assertEquals("Test : Open.setDesc(Auction, Person, String) : String",
				auction.setDesc(seller, "10"), "ERROR: auctions is open");
	}

	// Test : Open.setEndDate(Auction, Person, int) : String
	@Test
	public void testSetEndDate() {
		assertEquals("Test : Open.setEndDate(Auction, Person, int) : String",
				auction.setEndD(seller, 10), "ERROR: auctions is open");
	}

	// Test : Open.setMinBid(Auction, Person, int) : String
	@Test
	public void testSetMinBid() {
		assertEquals("Test : Open.setMinBid(Auction, Person, int) : String",
				auction.setMinBid(seller, 10), "ERROR: auctions is open");
	}

	// Test : Open.setResPrice(Auction, Person, int) : String
	@Test
	public void testResPrice() {
		ReserveAuction reserveAuction = new ReserveAuctionImpl(seller, "name",
				"description", 0, 10, 1, 1);
		reserveAuction.open();
		assertEquals("Test : Open.setResPrice(Auction, Person, int) : String",
				reserveAuction.setResPrice(seller, 10),
				"ERROR: auctions is open");
	}

	// Test : Open.setStartDate(Auction, Person, int) : String
	@Test
	public void testSetStartDate() {
		assertEquals("Test : Open.setStartDate(Auction, Person, int) : String",
				auction.setStartD(seller, 10), "ERROR: auctions is open");
	}
}
