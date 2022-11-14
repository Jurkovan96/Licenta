package siit.db.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import siit.db.repository.mapper.ResultSetMapper;
import siit.db.repository.memento.BidMemento;
import siit.exception.ValidationException;
import siit.model.Bid;
import siit.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class BidDao extends ResultSetMapper<Bid, BidMemento> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public BidDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bid> findAllByUserId(Integer userId) {
        return jdbcTemplate.query("SELECT * FROM BID WHERE USER_ID = ?", this::mapResultSet, userId);
    }

    public void addANewBid(Product product, int user_id, int val) {
        jdbcTemplate.update("insert into bids (product_id, user_id, bid_value, bid_date," +
                        "bid_state) values(?,?,?,?,?)", product.getId(), user_id, val, LocalDate.now(),
                "Pending");
    }

    public List<Bid> findAllByProductId(Integer productId) {
        return jdbcTemplate.query("SELECT * FROM BID WHERE PRODUCT_ID = ?", this::mapResultSet, productId);
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM BID WHERE id = ?", id);
    }

    @Override
    protected Bid mapResultSet(ResultSet resultSet, int rowNumber) throws SQLException {
        return Bid.builder()
                .withId(resultSet.getInt("id"))
                .withUserId(resultSet.getInt("user_id"))
                .withProductId(resultSet.getInt("product_id"))
                .withBidderSum(resultSet.getDouble("bidder_sum"))
                .withPostDate(resultSet.getDate("post_date").toLocalDate())
                .build();
    }

    @Override
    public Optional<Bid> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM BID WHERE ID=?",
                this::mapResultSet, id));
    }

    @Override
    public void update(Integer id, BidMemento memento) {
        if (this.findById(id).isPresent()) {
            //Save the new bid with the status of the memento
            jdbcTemplate.update("UPDATE");
        } else {
            throw new ValidationException("bid.not.found");
        }
    }

    @Override
    public List<Bid> findAll() {
        return jdbcTemplate.query("SELECT * FROM BID", this::mapResultSet);
    }
}
