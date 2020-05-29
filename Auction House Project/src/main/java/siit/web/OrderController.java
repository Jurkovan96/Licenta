package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Order;
import siit.service.BidService;
import siit.service.OrderService;
import siit.service.UserService;

@Controller
@RequestMapping("/mainpage/{id}/orders")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BidService bidService;

    @GetMapping
    public ModelAndView doViewOrders(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mainpage-orders");
        mav.addObject("user", orderService.getOrderProductsWithBidsByUser(id));
        return mav;


    }
    @GetMapping("/{ord_id}/delete")
    public String deleteBid(@PathVariable int id, @PathVariable int ord_id) {
        orderService.deleteOrder(ord_id);
        return "redirect:/mainpage/" + id;
    }

    @GetMapping("/{ord_id}/details")
    public ModelAndView doViewAOrder(@PathVariable int id, @PathVariable int ord_id){
       ModelAndView mav = new ModelAndView();
       mav.setViewName("order-view");
       mav.addObject("user", bidService.getUsersWithBidsById(id));
       mav.addObject("order", orderService.getOrderById(ord_id));
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
