package test.impl;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Account;
import auction.Auction;
import auction.Server;
import auction.User;
import auction.impl.AccountImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;

public class testAccount {

	private User u;
	private Account a;
	private Server serverMock;
	private Auction auctionMock;

	@Before
	public void setUp() throws Exception {
		u = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		a = new AccountImpl(u);

		serverMock = EasyMock.createMock(ServerImpl.class);
		EasyMock.expect(serverMock.getAuctions()).andReturn(
				new HashMap<String, Auction>());
		EasyMock.replay(serverMock);
	}

	// Test : a.getCredit() : int
	@Test
	public void testGetCredit() {
		assertEquals("Test : a.getCredit() : int", a.getCredit(), 0);
	}

	// Test : a.incCredit() : int
	@Test
	public void testIncCredit() {
		assertEquals("Test : a.incCredit() : int", a.incCredit(10), "OK");
		assertEquals("Test : a.incCredit() : int", a.getCredit(), 10);
	}

	// Test : a.decCredit() : int
	@Test
	public void testDecCredit() {
		a.incCredit(10);
		assertEquals("Test : a.decCredit() : int", a.decCredit(6), "OK");
		assertEquals("Test : a.decCredit() : int", a.getCredit(), 4);
	}

	// Test : a.getFreeCredit() : int
	@Test
	public void testGetFreeCredit1() {

		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(99);
				assertEquals("Test : a.getFreeCredit() : int", user.getAccount()
				.getFreeCredit(), 99);
	}

	// Test : a.getFreeCredit() : int
	@Test
	public void testGetFreeCredit2() {
		ServerImpl.instance.createAuction(u, "auction1", "description", 1, 10,
				1);
		ServerImpl.instance.createAuction(u, "auction2", "description", 1, 10,
				1);
		ServerImpl.instance.createAuction(u, "auction3", "description", 1, 10,
				1);

		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		
		user.getAccount().incCredit(99);
		for (Auction a : ServerImpl.instance.getAuctions().values()) {
			a.open();
			a.placeBid((UserImpl) user, 10);
		}

		assertEquals("Test : a.getFreeCredit() : int", user.getAccount()
				.getFreeCredit(), 99-30);
	}
	
	// Test : a.getCredits() : String
	@Test
	public void testGetCredits() {

		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		user.getAccount().incCredit(99);
				assertEquals("Test : a.getCredits() : String", user.getAccount()
				.getCredits(), "99 99");
	}

	@After
	public void tearDown() {
		ServerImpl.instance.reset();
	}

}
