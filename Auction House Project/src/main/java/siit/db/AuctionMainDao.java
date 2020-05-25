package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.AuctionMain;
import siit.model.Product;
import siit.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuctionMainDao {

 @Autowired
 private JdbcTemplate jdbcTemplate;

 private AuctionMain mapAuctionMain(ResultSet resultSet, int rowNum) throws SQLException {
     AuctionMain auctionMain = new AuctionMain();
     auctionMain.setMain_id(resultSet.getInt("main_id"));
     auctionMain.setAuction_state(resultSet.getString("auctionstate"));
     auctionMain.setAcution_name(resultSet.getString("auctionname"));
     auctionMain.setStart_date(resultSet.getTimestamp("start_date"));
     auctionMain.setEnd_date(resultSet.getTimestamp("end_date"));
     Product product = new Product();
     product.setId(resultSet.getInt("product_id"));
     auctionMain.setProduct(product);
     User user = new User();
     user.setId(resultSet.getInt("user_id"));
     auctionMain.setUser(user);

     return auctionMain;
 }

 public List<AuctionMain> getAuctionsByProducId(int product_id){
     return jdbcTemplate.query("select * from main_auction where product_id = ?", this::mapAuctionMain,
             product_id);
 }

 public AuctionMain getAuctionMainById(int id){
     return jdbcTemplate.queryForObject("select * from main_auction where main_id = ?",
             this::mapAuctionMain, id);
 }



}
