package siit.db;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import siit.model.Bid;
import siit.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BidDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Bid mapBid(ResultSet resultSet, int rowNum) throws SQLException {
        Bid bid2 = new Bid();
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        bid2.setBid_id(resultSet.getInt("id"));
        bid2.setBid_value(resultSet.getInt("bid_value"));
        bid2.setStart_date(resultSet.getDate("bid_date"));
        bid2.setProduct(product);
        bid2.setState(resultSet.getString("bid_state"));
        return bid2;
    }

    public List<Bid> getBidsForUser(int user_id){
        return jdbcTemplate.query("select * from bids where user_id = ?", this::mapBid, user_id);
    }

    public List<Bid> getWinningBidsForUser(int user_id){
        return jdbcTemplate.query("select * from bids where user_id = ? and bid_state = ?",
                this::mapBid, user_id, "WON");
    }


    public void addANewBid(Product product, int user_id, int val) {
        jdbcTemplate.update("insert into bids (product_id, user_id, bid_value, bid_date," +
                "bid_state) values(?,?,?,?,?)", product.getId(), user_id, val, LocalDate.now(),
                "Pending");
    }

    public List<Bid> getBidsByProductId(int product_id){
        return jdbcTemplate.query("select * from bids where product_id = ?",
                this::mapBid, product_id);
    }

    public void deleteBid(int bidId) {
        jdbcTemplate.update("delete from bids where id = ?", bidId);
    }

    public Bid getBidByValue(int maxVal) {
        return jdbcTemplate.queryForObject("select * from bids where bid_value = ?",
                this::mapBid, maxVal);
    }

    public void upDateBidState(Bid winbid) {
        jdbcTemplate.update("update bids set bid_value = (?) where bid_id = ?",
                "WON", winbid.getBid_id());
    }
}
