package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        order.setNumber(resultSet.getInt("ord_number"));
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
        return jdbcTemplate.query("select * from order_products where order_id = ?",
                this::mapOrderProducts, id);
    }

    private OrderProduct mapOrderProducts(ResultSet resultSet, int i) throws SQLException{
       OrderProduct orderProduct = new OrderProduct();
       orderProduct.setBid_ord_id(resultSet.getInt("ordprod_id"));
       orderProduct.setOrder_id(resultSet.getInt("order_id"));
       orderProduct.setPrice(resultSet.getInt("value_op"));
       return orderProduct;
    }


    public List<OrderProduct> getOrderProducts() {
        return jdbcTemplate.query("select * from order_products",
        this::mapOrderProducts);
    }
//
//    public void addOrderProduct(OrderProduct orderProduct) {
//        jdbcTemplate.update("insert into order_products (, order_id, price) values (?,?,?)",
//                orderProduct.getBid().getBid_id(), orderProduct.getOrder_id(), orderProduct.getBid().getBid_value());
//    }

    public void addOrderForUser(Order order, int user_id) {
        jdbcTemplate.update("insert into orders (user_id, ord_number, ord_value) values(?,?,?)", user_id, order.getNumber(),order.getValue());
    }

    public void deleteOrderProduct(int ord_id){
        jdbcTemplate.update("delete from order_products where order_id = ?", ord_id);
    }

    public void deleteOrderById(int ord_id) {
        jdbcTemplate.update("delete from orders where order_id = ?", ord_id);


    }

    public Order getOrderById(int order_id) {
    return jdbcTemplate.queryForObject("select * from orders where order_id = ?", this::mapOrder,
            order_id);
    }
}
