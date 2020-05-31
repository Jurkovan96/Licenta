package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Owen_products;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OwenProductsDao {

@Autowired
private JdbcTemplate jdbcTemplate;

//private Owen_products mapOwP(ResultSet resultSet, int rowNum)throws SQLException {
//    Owen_products op = new Owen_products();
//    op.setOp_id(resultSet.getInt("op_id"));
//    op.se
//
//}
}

