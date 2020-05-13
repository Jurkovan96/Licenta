package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import siit.model.Auction;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuctionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Auction mapAuctions(ResultSet resultSet, int rowNum) throws SQLException {
        Auction auction = new Auction();
        auction.setAuction_id(resultSet.getInt("id"));
        auction.setStart_date(resultSet.getDate("start_date").toLocalDate());
        auction.setEnd_date(resultSet.getDate("end_date").toLocalDate());

        return auction;
    }

    public Auction getAuctionForProduct(int prod_id){
            return jdbcTemplate.queryForObject("select * from auctions where product_id = ?",
                    this::mapAuctions,prod_id);
    }



}
