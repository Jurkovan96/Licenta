package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siit.db.AuctionDao;
import siit.db.BidDao;
import siit.db.ProductDao;
import siit.db.UserDao;
import siit.model.Auction;
import siit.model.Bid;
import siit.model.Product;
import siit.model.User;

import java.time.LocalDate;
import java.util.List;

@Service
public class BidService {

   @Autowired
    private BidDao bidDao;

   @Autowired
    private UserDao userDao;

   @Autowired
    private ProductDao productDao;

   @Autowired
   private AuctionDao auctionDao;


   public User getUsersWithBidsById(int id){
       User user = userDao.getUserById(id);
       user.setBidsList(getBidsWithProducts(id));
       return user;
   }

   public void addABid(Product product, int user_id, int val) throws Exception {
       Auction auction = auctionDao.getAuctionForProduct(product.getId());
       if(checkBidForDuplicates(user_id, product.getId()) && val > setMaxCurrentMaxValue(product.getId())
       && (checkTimeForBid(product.getId()) == true)){

           bidDao.addANewBid(product, user_id, val);}

           else {
           throw new Exception("No way");
       }
   }

   public int setMaxCurrentMaxValue (int product_id){
    int valMax = 0;
       List<Bid> bids = bidDao.getBidsByProductId(product_id);
    for(Bid bid : bids){
        if(bid.getBid_value() > valMax){
            valMax = bid.getBid_value();
        }
    }
       return valMax;

   }

   public boolean checkTimeForBid(int product_id){
       LocalDate date1 = LocalDate.now().plusDays(1);
       Auction auction = auctionDao.getAuctionForProduct(product_id);
       if(date1.isBefore(auction.getStart_date()) || (date1.isAfter(auction.getEnd_date()))){
   return false;}
   else return true;}


   public boolean checkBidForDuplicates(int user_id, int product_id){
       int dupVal = 0;
       List<Bid> bids = getBidsWithProducts(user_id);
       for(Bid bid : bids){
           if(bid.getProduct().getId() == product_id ){
               dupVal++; }
       }
       if(dupVal == 0)return true;
       else return false;
   }

   public void setWinningBidsByDate(int product_id){
       LocalDate date = LocalDate.now();
       int maxVal = 0;
       List<Bid> bids = bidDao.getBidsByProductId(product_id);
       for(Bid bid : bids){
           if(bid.getBid_value() > maxVal){
               maxVal = bid.getBid_value();
           }
       }
       Bid winBid = bidDao.getBidByValue(maxVal);
         bidDao.upDateBidState(winBid);
   }




    public List<Bid> getBidsByUserId(int id){
       return bidDao.getBidsForUser(id);
    }

    public List<Bid> getBidsWithProducts(int user_id){
       List<Bid> bids = getBidsByUserId(user_id);
       for(Bid bidd: bids){
           Product product = productDao.getProductForBid(bidd.getProduct().getId());
           Auction auction = auctionDao.getAuctionForProduct(product.getId());
           product.setAuction(auction);
           bidd.setProduct(product);

       }
       return bids;
    }

//    public List<Bid> getBidsWithProductsByProductIds(int user_id){
//        List<Bid> bids = getBidsByUserId(user_id);
//        for(Bid bidd: bids){
//            Product product = productDao.getProductForBid(bidd.getProduct().getId());
//            Auction auction = auctionDao.getAuctionForProduct(product.getId());
//            product.setAuction(auction);
//            bidd.setProduct(product);
//
//        }
//        return bids;
//    }




    @Transactional
    public void deleteBid(int bidId) {
       bidDao.deleteBid(bidId);
    }


}
