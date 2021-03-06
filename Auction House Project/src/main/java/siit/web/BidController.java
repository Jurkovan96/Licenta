package siit.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import siit.exceptions.ValidationException;
import siit.service.BidService;
import siit.service.ProductService;
import siit.service.UserService;

@Controller
@RequestMapping("mainpage/{id}/about")
public class BidController {

    @Autowired
    public BidService bidService;

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;


    @GetMapping
    public ModelAndView doAboutPage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("mainpage-about");
        mav.addObject("user", userService.getUserById(id));
        mav.addObject("bids", bidService.getBidsWithProducts(id));

        return mav;
    }

    @GetMapping("/{bidId}/delete")
    public String deleteBid(@PathVariable int id, @PathVariable int bidId) {
        bidService.deleteBid(bidId);
        return "redirect:/mainpage/" + id + "/about";
    }

    @GetMapping("/{bidId}/update")
    public String updateWinBid(@PathVariable int id, @PathVariable int bidId) {
        bidService.calculateByDate(bidId, id);
        //bidService.setBisState(bidId, id);
        return "redirect:/mainpage/" + id + "/about";
    }

    @GetMapping("/{bidId}/update2")
    public String updateWinBids(@PathVariable int id, @PathVariable int bidId) {
        try{
        bidService.calculateBidByDate(id);}
        catch (ValidationException e){
            return "redirect:/mainpage/" + id + "/settings";
        }
        //bidService.setBisState(bidId, id);
        return "redirect:/mainpage/" + id + "/about";
    }


}
