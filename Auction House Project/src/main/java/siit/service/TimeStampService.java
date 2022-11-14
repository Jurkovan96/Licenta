package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.repository.dao.impl.AuctionDAO;
import siit.db.repository.dao.impl.BidDao;
import siit.db.repository.dao.impl.ProductDao;

@Service
public class TimeStampService {

    @Autowired
    private AuctionDAO auction;

    @Autowired
    private BidDao bidDao;

    @Autowired
    private ProductDao productDao;



}
