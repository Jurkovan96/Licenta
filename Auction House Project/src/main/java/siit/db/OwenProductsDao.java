package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Owen_products;
import siit.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OwenProductsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Owen_products mapOwP(ResultSet resultSet, int rowNum) throws SQLException {
        Owen_products op = new Owen_products();
        op.setOp_id(resultSet.getInt("op_id"));
        op.setProduct_id(resultSet.getInt("product_id"));
        op.setName(resultSet.getString("name"));
        op.setArtist(resultSet.getString("artist"));
        op.setLenght(resultSet.getInt("length"));
        op.setWidth(resultSet.getInt("witdth"));
        op.setTehn(resultSet.getString("tehniq"));
        op.setYear(resultSet.getInt("year"));
        op.setUrl(resultSet.getString("url"));
        op.setPay_value(resultSet.getInt("pay_value"));
        op.setUser_id(resultSet.getInt("user_id"));
        return op;
    }

    public Owen_products getOwenProductsByUserId(int user_id) {
        return jdbcTemplate.queryForObject("select * from owen_product where user_id = ?",
                this::mapOwP, user_id);
    }

    public Owen_products getOwenProductsByProductId(int prod_id) {
        return jdbcTemplate.queryForObject("select * from owen_product where product_id = ?",
                this::mapOwP, prod_id);
    }

    public List<Owen_products> getOwenProductsForUser(int user_id) {
        return jdbcTemplate.query("select * from owen_product where user_id = ?",
                this::mapOwP, user_id);
    }

    public void addProductToUser(int user_id, Product product, int maxV) {
        jdbcTemplate.update("insert into owen_product(product_id, name, length, witdth, year, artist, tehniq, url, pay_value, user_id)" +
                        "values(?,?,?,?,?,?,?,?,?,?)", product.getId(), product.getName(), product.getLenght(),
                product.getWidth(), Integer.valueOf(product.getYear()), product.getArtist(), product.getTehn(), product.getUrl(), maxV, user_id);
    }

    public List<Owen_products> getOwenProductsForOrderProduct(int op_id) {
        return jdbcTemplate.query("select * from owen_product where op_id = ?", this::mapOwP, op_id);
    }

    public Owen_products getOwenProductForOrderProduct(int op_id) {
        return jdbcTemplate.queryForObject("select * from owen_product where op_id = ?", this::mapOwP, op_id);
    }
}

