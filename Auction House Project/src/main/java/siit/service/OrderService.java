package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.BidDao;
import siit.db.OrderDao;
import siit.db.UserDao;
import siit.model.Bid;
import siit.model.Order;
import siit.model.OrderProduct;
import siit.model.User;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BidDao bidDao;

    @Autowired
    private UserDao userDao;



    public User getOrderProductsWithBidsByUser(int user_id){
        User user = userDao.getUserById(user_id);
        user.setOrders(orderDao.getOrdersByUserId(user_id));
        return user;
    }

    public void addOrderForUser(int user_id, Order order){
       orderDao.addOrderForUser(order, user_id);
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
}
