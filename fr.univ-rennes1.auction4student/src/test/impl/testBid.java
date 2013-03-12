package test.impl;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.Bid;
import auction.impl.BidImpl;
import auction.impl.UserImpl;

public class testBid {

	private Bid bid;
	private UserImpl user;
	private Auction auctionMock;
	private String email;
	private int amount;
	
	@Before
	public void setUp() throws Exception {
		email = "email";
		user = new UserImpl("firstNam", "lastName", email, "password", "address");
		auctionMock = EasyMock.createMock(Auction.class);
		EasyMock.expect(auctionMock.getBids()).andReturn(new java.util.ArrayList<BidImpl>());
		EasyMock.replay(auctionMock);
		amount = 0;
		
		bid = new BidImpl(user, auctionMock, amount);
	}

	@After
	public void tearDown() throws Exception {
		EasyMock.verify(auctionMock);
	}

	// Test : getAmount() : int
	@Test
	public void testGetAmount() {
		assertEquals("Test : getAmount", bid.getAmount(), 0);
	}
	
	// Test : getUser() : User
	@Test
	public void testGetUser() {
		assertEquals("Test : getUser()", bid.getUser(), user);
	}
	
	// Test : getAuction() : Auction
	@Test
	public void testGetAuction() {
		assertEquals("Test : getAuction()", bid.getAuction(), auctionMock);
	}
	
	// Test : toString() : String
	@Test
	public void testToString() {
		String result = email + " " + amount;
		assertEquals("Test : toString()", bid.toString(), result);
	}

}
