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
        return jdbcTemplate.queryForObject("select * from adresses where user_id = ?", this::mapAdress, id);
    }

    public List<Adress> getAdresses(){
        return jdbcTemplate.query("select * from adresses", this::mapAdress);
    }

    private Adress mapAdress(ResultSet resultSet, int rn) throws SQLException {
        Adress adress =  new Adress();
        adress.setAdress_id(resultSet.getInt("adress_id"));
        adress.setCity(resultSet.getString("adr_ct"));
        adress.setStreet(resultSet.getString("adr_st"));
        adress.setCountry(resultSet.getString("adr_cnt"));
        adress.setNumber(resultSet.getInt("adr_num"));
        return adress;
    }

    public void upDateAdress(Adress adress, int user_id){
        jdbcTemplate.update("update adresses set adr_st = (?), set adr_num = (?), set adr_ct = (?), set adr_cnt = (?) where user_id = ?",
                 adress.getStreet(), adress.getNumber(),
                 adress.getCity(), adress.getCountry(), user_id);
    }

}
