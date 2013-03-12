package test.impl;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.Bid;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.UserImpl;

public class testUser {

	private User u;

	@Before
	public void steUp() {
		u = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		
//		account = EasyMock.createMock(AccountImpl.class);
//		EasyMock.expect(account.getAuctions()).andReturn(new HashMap<String, Auction>());
//		EasyMock.replay(account);

	}

	// Test : User.getAdress() : String
	@Test
	public void testGetAdress() {
		assertEquals("Test : User.getAdress()", u.getAdress(), "address");
	}

	// Test : User.getEmail() : String
	@Test
	public void testGetEmail() {
		assertEquals("Test : User.getEmail()", u.getEmail(), "email");
	}

	// Test : User.getFirstName() : String
	@Test
	public void testGetFirstName() {
		assertEquals("Test : User.getFirstName()", u.getFirstName(),
				"firstName");
	}

	// Test : User.getLastName() : String
	@Test
	public void testGetLastName() {
		assertEquals("Test : User.getLastName()", u.getLastName(), "lastName");
	}

	// Test : User.getPassword() : String
	@Test
	public void testGetPassword() {
		assertEquals("Test : User.getPassword()", u.getPassword(), "password");
	}

	// Test : User.getAccount() : Account
	@Test
	public void testGetAccount() {
		u.getAccount().incCredit(123456789);
		assertEquals("Test : User.Account()", u.getAccount().getCredit(), 123456789);
	}
	
	// Test : User.getBids() : Collection<Bid>
	@Test
	public void testGetBids() {
		Auction a = new AuctionImpl(u, "name", "description", 0, 1, 1);
		u.getBids().add(new BidImpl((UserImpl) u, a, 0));
		Iterator<Bid> it = u.getBids().iterator();
		assertEquals("Test : User.getBids()", it.next().getUser(), u);
	}
	
	// Test : User.getJoinedAuctions() : Collection<Auction>
	@Test
	public void testGetJoinedAuctions() {
		u.getJoinedAuctions().add(new AuctionImpl((UserImpl) u, "name", "description", 0, 10, 0));
		Iterator<Auction> it = u.getJoinedAuctions().iterator();
		assertEquals("Test : User.getJoinedAuctions()", it.next().getSeller(), u);
	}

}
