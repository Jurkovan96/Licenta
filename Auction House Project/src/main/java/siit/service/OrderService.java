package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.OrderDao;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
}
