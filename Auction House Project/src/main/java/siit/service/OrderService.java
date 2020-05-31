package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siit.db.BidDao;
import siit.db.OrderDao;
import siit.db.ProductDao;
import siit.db.UserDao;
import siit.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BidDao bidDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private BidService bidService;



    public User getOrderProductsWithBidsByUser(int user_id){

        User user = userDao.getUserById(user_id);
        List<Order> orders = getOrdersWithOrderProducts(user_id);
//        Map<Integer, Bid> bidMap = new HashMap<>();
//        for(Order o: orders){
//           populateOrderProducts(o, bidMap);}
        user.setOrders(orders);


        return user;
    }

    public void addOrderForUser(int user_id, Order order){
       orderDao.addOrderForUser(order, user_id);
    }


    public Order getOrderById(int order_id) {
        Order order = orderDao.getOrderById(order_id);
        populateOrderProducts(order, new HashMap<>());
        return order;
    }




    private void populateOrderProducts(Order order, Map<Integer, Bid> bidMap) {
        order.setOrderProductList(
                orderDao.getOrderProductsForOrderById(order.getOder_id()));
        for (OrderProduct orderProduct : order.getOrderProductList()) {
            Bid bid = bidService.getBidWithProductById(orderProduct.getBid().getBid_id());
                  bidMap.putIfAbsent(orderProduct.getBid().getBid_id(), bid);
                 orderProduct.setBid(bid);
//           Bid bid = bidMap.computeIfAbsent(
//                    orderProduct.getBid().getBid_id(), bidDao::getBidId);
//
//           orderProduct.setBid(bid);
        }
    }


    private List<Order> getOrdersWithOrderProducts(int user_id){
        List<Order> orders = orderDao.getOrdersByUserId(user_id);
        for(Order o: orders){
            o.setOrderProductList(orderDao.getOrderProductsForOrderById(o.getOder_id()));
            for(OrderProduct op: o.getOrderProductList()){
                op.setBid(bidService.getBidWithProductById(op.getBid().getBid_id()));
            }
        }
        return orders;
    }


    public OrderProduct addBidToOrderProduct(OrderProduct orderProduct){
    OrderProduct existingOP = getOrderProductByBidId(orderProduct.getBid().getBid_id(), orderProduct.getOrder_id());
    if(existingOP == null){
          orderDao.addOrderProduct(orderProduct);
        return getOrderProductByBidId(orderProduct.getBid().getBid_id(), orderProduct.getOrder_id());
    }else
        return existingOP;
    }

    private OrderProduct getOrderProductByBidId(int bid_id, int order_id){
      List<OrderProduct> orderProducts = orderDao.getOrderProductsForOrderById(order_id);
      Bid bid = bidDao.getBidId(bid_id);
      for(OrderProduct orderProduct: orderProducts){
          if(orderProduct.getBid().getBid_id() == bid_id && bid.getState().equals("WON")){
            orderProduct.setBid(bidDao.getBidId(orderProduct.getBid().getBid_id()));
          return orderProduct;
          }
      }
      return null;

    }

    public Order getOrderByUserId(int id) {
       return orderDao.getOrderByUserId(id);

    }

    public List<OrderProduct> getOrderProductForOrder(int id) {
       return orderDao.getOrderProductsForOrderById(id);

    }

    @Transactional
    public void deleteOrder(int ord_id) {
        orderDao.deleteOrderProduct(ord_id);
        orderDao.deleteOrderById(ord_id);
    }
}
