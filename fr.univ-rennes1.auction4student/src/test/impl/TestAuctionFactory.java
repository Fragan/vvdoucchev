package test.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import auction.Auction;
import auction.ReserveAuction;
import auction.User;
import auction.impl.AuctionFactory;
import auction.impl.UserImpl;

public class TestAuctionFactory {

	private AuctionFactory auctionFactory;

	// Test : AuctionFactory.getEInstance() : AuctionFactory
	@Test
	public void testGetEInstance() {
		assertTrue("Test : AuctionFactory.getEInstance() : AuctionFactory",
				AuctionFactory.getEInstance() instanceof AuctionFactory);
	}

	// Test : AuctionFactory.createAuction() : Auction
	@Test
	public void testCreateAuction() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auctionFactory = AuctionFactory.getEInstance();
		Auction auction = auctionFactory.createAuction(user, "name",
				"description", 0, 1, 1);
		assertEquals("Test : AuctionFactory.createAuction() : Auction",
				auction.getSeller(), user);
	}

	// Test : AuctionFactory.createReservedAuction() : Auction
	@Test
	public void testCreateReservedAuction() {
		User user = new UserImpl("firstName", "lastName", "email", "password",
				"address");
		auctionFactory = AuctionFactory.getEInstance();
		ReserveAuction reserveAuction = auctionFactory.createReservedAuction(
				user, "name", "description", 0, 1, 1, 9742);
		assertEquals("Test : AuctionFactory.createReservedAuction() : Auction",
				reserveAuction.getSeller(), user);
		assertEquals("Test : AuctionFactory.createReservedAuction() : Auction",
				reserveAuction.getReservePrice(), 9742);

	}
}
