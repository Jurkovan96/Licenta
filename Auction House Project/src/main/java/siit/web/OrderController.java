package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Order;
import siit.service.OrderService;
import siit.service.UserService;

@Controller
@RequestMapping("/mainpage/{id}/orders")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ModelAndView doViewOrders(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mainpage-orders");
        mav.addObject("user", orderService.getOrderProductsWithBidsByUser(id));
       // mav.addObject("orders", orderService.getOrderByUserId(id));
        return mav;
    }

    @GetMapping("/{ord_id}/details")
    public ModelAndView doViewAOrder(@PathVariable int id, @PathVariable int ord_id){
       ModelAndView mav = new ModelAndView();
       mav.setViewName("order-view");
       mav.addObject("orders", orderService.getOrderProductsWithBidsByUser(id));
       mav.addObject("user", userService.getUserById(id));
       mav.addObject("orderProducts", orderService.getOrderProductForOrder(id));
       return mav;
    }


//    @PostMapping
//    public ModelAndView doOrders(@PathVariable int id, @RequestParam int ord_num,
//                                 ){
//        ModelAndView modelAndView = new ModelAndView();
//        Order order = orderService.getOrderByUserId(id);
//        orderService.addOrderForUser(id, order);
//
//        modelAndView.setViewName("redirect:/");
//        return modelAndView;
//    }

}
