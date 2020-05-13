package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.AuctionDao;
import siit.db.BidDao;
import siit.db.ProductDao;
import siit.model.Auction;
import siit.model.Bid;

import java.util.List;

@Service
public class TimeStampService {

    @Autowired
    private AuctionDao auction;

    @Autowired
    private BidDao bidDao;

    @Autowired
    private ProductDao productDao;



}
