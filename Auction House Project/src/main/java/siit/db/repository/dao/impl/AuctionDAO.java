package siit.db.repository.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import siit.db.repository.mapper.ResultSetMapper;
import siit.model.Auction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptySet;

@Component
public class AuctionDAO extends ResultSetMapper<Auction> {

    private final JdbcTemplate jdbcTemplate;

    public AuctionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Auction> findByProductId(Integer productId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from auctions where product_id = ?",
                this::mapResultSet, productId));
    }

    @Override
    protected Auction mapResultSet(ResultSet resultSet, int rowNumber) throws SQLException {
        return Auction.builder()
                .withId(resultSet.getInt("id"))
                .withEndDate(resultSet.getDate("start-date").toLocalDate())
                .withEndDate(resultSet.getDate("end_date").toLocalDate())
                .withUserList(emptySet())
                .withMaximumBet(resultSet.getInt("maximum_bet"))
                .build();
    }

    @Override
    public Optional<Auction> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public List<Auction> findAll() {
        return null;
    }
}
