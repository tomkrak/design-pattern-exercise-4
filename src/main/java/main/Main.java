package main;

import model.Auction;
import model.AuctionService;
import model.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Customer seller = new Customer("Jan Kowalski");
//        Auction auction = new Auction(1,"Coffee",null,
//                LocalDateTime.now().plusDays(2L),seller,0,null);
        Auction auction = new Auction.AuctionBuilder()
                .withId(1)
                .withItem("book")
                .withDescription("old book in a good condition")
                .withSeller(null)
                .withBuyer(null)
                .withDueDate(LocalDate.now())
                .withHighestBid(20.5)
                .build();


        AuctionService auctionService = new AuctionService();
        auctionService.bid(auction,new Customer("Anna Kowalik"),20);

        auctionService.bid(auction,new Customer("Krzysztof Adamowicz"),25);


        System.out.println("Auction with id: " + auction.getId()+ " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}
