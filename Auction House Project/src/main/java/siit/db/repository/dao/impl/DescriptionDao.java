package siit.db.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.ProductDescription;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DescriptionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public ProductDescription mapProductDescription(ResultSet resultSet, int rowNum)throws SQLException {
        ProductDescription description = new ProductDescription();
        description.setId_desc(resultSet.getInt("id_prod_dec"));
        description.setDesc(resultSet.getString("prod_text"));
        return description;
    }

    public ProductDescription getProductTextByProductId(int prod_id){
        return jdbcTemplate.queryForObject("select * from productdescription where product_id = ?",
                this::mapProductDescription, prod_id);
    }
}
