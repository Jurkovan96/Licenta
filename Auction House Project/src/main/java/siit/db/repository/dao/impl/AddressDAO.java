package siit.db.repository.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import siit.db.repository.mapper.ResultSetMapper;
import siit.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AddressDAO extends ResultSetMapper<Address> {

    private final JdbcTemplate jdbcTemplate;

    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected Address mapResultSet(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Address.Builder()
                .withId(resultSet.getInt("id"))
                .withCity(resultSet.getString("city"))
                .withStreetName(resultSet.getString("street"))
                .withCountry(resultSet.getString("country"))
                .withNumber(resultSet.getInt("number"))
                .build();
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM ADDRESS WHERE ID=?", this::mapResultSet, id));
    }

    @Override
    public void update(Integer id) {
        jdbcTemplate.update("call UPDATE_ADDRESS_PROCEDURE", id);
    }

    @Override
    public List<Address> findAll() {
        return jdbcTemplate.query("SELECT * FROM ADDRESS", this::mapResultSet);
    }
}
