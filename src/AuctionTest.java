import db.Auction;


public class AuctionTest {
	
	public static void main(String[] args) {
		Auction[] auctions = Auction.find("Alienware");
		for(Auction a : auctions) {
			System.out.println(a);
		}
	}
}
