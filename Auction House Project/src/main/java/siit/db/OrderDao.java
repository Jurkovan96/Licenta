package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Order;
import siit.model.OrderProduct;
import siit.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getOrders(){
        return jdbcTemplate.query("select * from orders", this::mapOrder);
    }

    private Order mapOrder(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setNumber(resultSet.getInt("number"));
        order.setDate(resultSet.getDate("date"));
        order.setOder_id(resultSet.getInt("order_id"));

        return order;
    }

    public Order getOrderByUserId(int id){
        return jdbcTemplate.queryForObject("select * from orders where user_id = ?",
                this::mapOrder, id);
    }

    public List<Order> getOrdersByUserId(int id){
        return jdbcTemplate.query("select * from orders where user_id = ?",
                this::mapOrder, id);
    }

    public List<OrderProduct> getOrderProductsForOrderById(int id){
        return jdbcTemplate.query("select * from product_orders where ordersorder_id = ?",
                this::mapOrderProducts, id);
    }

    private OrderProduct mapOrderProducts(ResultSet resultSet, int i) throws SQLException{
       OrderProduct orderProduct = new OrderProduct();
       Product product = new Product();
       product.setId(resultSet.getInt("productproduct_id"));
       orderProduct.setProduct(product);
       orderProduct.setOrder_id(resultSet.getInt("ordersorder_id"));
       return orderProduct;
    }




}
