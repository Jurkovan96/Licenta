package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Product;
import siit.service.BidService;
import siit.service.ProductService;
import siit.service.UserService;

@Controller
@RequestMapping("/mainpage/{id}/products")
public class ProductController {

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

    @Autowired
    public BidService bidService;


    @GetMapping
    public ModelAndView doDisplayProducts(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mainpage-productsv");
        mav.addObject("user", userService.getUserById(id));
        mav.addObject("products", productService.getProductsWithTime());
        mav.addObject("auctionDates", productService.getProductsWithTime());
        return mav;
    }

    @GetMapping("/{proid}&{name}/view")
    public ModelAndView doView(@PathVariable int id, @PathVariable int proid){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view-product");
        mav.addObject("user", bidService.getUsersWithBidsById(id));
        mav.addObject("bids", bidService.getBidsByUserId(id));
        mav.addObject("max_value", bidService.setMaxCurrentMaxValue(proid));
        mav.addObject("product", productService.getProductById(proid));



        return mav;}

    @PostMapping("/{proid}&{name}/view")
    public ModelAndView doAddaProductBid(@PathVariable int id, @PathVariable int proid,
                                         @RequestParam int bidVal) throws Exception {
            Product product1 = productService.getProductById(proid);
            try{bidService.addABid(product1, id, bidVal);
            }
            catch (Exception e){
                System.out.println("NO");
            }
            return new ModelAndView("redirect:/mainpage/" + id + "/products");

    }


    @GetMapping("/{proid}&{name}/details")
    public ModelAndView doViewProduct(@PathVariable int id, @PathVariable int proid){
        ModelAndView mav = new ModelAndView("product-details");
        mav.setViewName("view-product");
        mav.addObject("user", bidService.getUsersWithBidsById(id));
        mav.addObject("product", productService.getProductById(proid));
        return mav;
    }
}
