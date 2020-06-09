package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Adress;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdressDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Adress getAdressByUserId(int id){
        return jdbcTemplate.queryForObject("select * from adress where user_id = ?", this::mapAdress, id);
    }

    public List<Adress> getAdresses(){
        return jdbcTemplate.query("select * from adress", this::mapAdress);
    }

    private Adress mapAdress(ResultSet resultSet, int rn) throws SQLException {
        Adress adress =  new Adress();
        adress.setAdress_id(resultSet.getInt("adress_id"));
        adress.setCity(resultSet.getString("city"));
        adress.setStreet(resultSet.getString("street"));
        adress.setCountry(resultSet.getString("country"));
        adress.setNumber(resultSet.getInt("number"));
        return adress;
    }



}
