package auction.impl;

import auction.Auction;
import auction.ReserveAuction;
import auction.User;

public class AuctionFactory {

	private static AuctionFactory eInstance = new AuctionFactory();

	public Auction createAuction(User seller, String name, String description,
			int startDate, int endDate, int minimumBid) {
		Auction auction = new AuctionImpl(seller, name, description, startDate,
				endDate, minimumBid);
		return auction;
	}

	public ReserveAuction createReservedAuction(User creator, String name,
			String description, int startDate, int endDate, int minimumBid,
			int reservePrice) {
		ReserveAuction reserveAuction = new ReserveAuctionImpl(creator, name,
				description, startDate, endDate, minimumBid, reservePrice);
		return reserveAuction;
	}

	public static AuctionFactory getEInstance() {
		return eInstance;
	}

}
