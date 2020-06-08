package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Adress;
import siit.model.CryptoByte;
import siit.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   // private final String password = "password";

    public User getUserById(int id){
        return jdbcTemplate.queryForObject("select * from users where user_id = ?",
                this::getUser, id);
    }

    public User getUserByEmail(String email){
        return jdbcTemplate.queryForObject("select * from users where email = ?",
                this::getUser, email);
    }

    public User getUserByName(String name){
        return jdbcTemplate.queryForObject("select * from users where name = ?",
                this::getUser, name);
    }

    public User getUserByPassword(String password){
        return jdbcTemplate.queryForObject("select * from users where password = ?",
                this::getUser, password);
    }

    public List<User> getUsers() {
        return jdbcTemplate.query(
                "select * from users",
                this::getUser);
    }


    public void updateUser(int user_id, User user){
        jdbcTemplate.update("update users set name = (?), email = (?), phone_number = (?) where user_id = ?", user.getName(),
                 user.getEmail(), user.getPhone_number(), user_id);
    }

    private User getUser(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone_number(resultSet.getString("phone_number"));
    return user;}



    public void addNewUser(String name, String passw, String em, String ph){
        jdbcTemplate.update("insert into users (name, password, email, phone_number) values(?, ?, ?, ?)",
                name, passw, em, ph);
    }

    public void addDefaultAdressForUserId(int user_id) {
        jdbcTemplate.update("insert into adress (street, number, city, country, user_id)" +
                "values(?,?,?,?,?)", "default", 1, "default", "default", user_id);
    }
    public void resetPassword(String email, String password) {
        jdbcTemplate.update("update users set password = (?) where email = ?",
                password, email);
    }

    public void upadateAdress(Adress adress, int id) {
       jdbcTemplate.update("update adress set street = (?), set number = (?), set city = (?), " +
               "set country = (?) where user_id = ?", adress.getStreet(), adress.getNumber(), adress.getCity(),
               adress.getCountry(), id);

    }
}
