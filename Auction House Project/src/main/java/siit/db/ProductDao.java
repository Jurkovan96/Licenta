package siit.db;

import org.eclipse.jdt.internal.compiler.apt.dispatch.IProcessorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Product;
import siit.model.ProductDescription;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Product> getProducts(){
        return jdbcTemplate.query("select * from products",
                this::getProduct);
    }

    public List<Product> getProductsByTehnique(String tehn){
        return jdbcTemplate.query("select * from products where tehniq = ?",
                this::getProduct, tehn);
    }

    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject("select * from products where product_id = ?",
                this::getProduct, id);
    }

    public List<Product> getProductsByYears(int year){
        return jdbcTemplate.query("select * from products where year = ?",
                this::getProduct, year);
    }

    public List<Product> getProductsByArtists(String artist){
        return jdbcTemplate.query("select * from products where artist = ?",
                this::getProduct, artist);
    }

    private Product getProduct(ResultSet resultSet, int rowNum) throws SQLException {
        Product product = new Product();

        product.setName(resultSet.getString("name"));
        product.setId(resultSet.getInt("product_id"));
        product.setArtist(resultSet.getString("artist"));
        product.setLenght(resultSet.getInt("length"));
        product.setWidth(resultSet.getInt("width"));
        product.setTehn(resultSet.getString("tehniq"));
        product.setYear(resultSet.getString("year"));
        product.setValue(resultSet.getInt("minvaluep"));
        product.setUrl(resultSet.getString("b64code"));
        return product;
    }

    public Product getProductForBid(int bid_id) {
        return jdbcTemplate.queryForObject("select * from products where product_id = ?",
                this::getProduct, bid_id);
    }






}
