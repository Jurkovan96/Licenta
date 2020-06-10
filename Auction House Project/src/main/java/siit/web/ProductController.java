package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.exceptions.ValidationException;
import siit.model.Product;
import siit.service.*;

import java.util.Locale;

@Controller
@RequestMapping("/mainpage/{id}/products")
public class ProductController {

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

    @Autowired
    public BidService bidService;

    @Autowired
    public OwenProductsService owenProductsService;

    @Autowired
    public OrderService orderService;

    @Autowired
    public ApplicationContext applicationContext;


    @GetMapping
    public ModelAndView doDisplayProducts(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mainpage-products");
        mav.addObject("user", userService.getUserById(id));
        mav.addObject("products", productService.getProductsWithTime());
        mav.addObject("auctionDates", productService.getProductsWithTime());
        return mav;
    }

    @GetMapping("/{proid}&{name}/view")
    public ModelAndView doView(@PathVariable int id, @PathVariable int proid) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view-product");
        mav.addObject("user", bidService.getUsersWithBidsById(id));
        mav.addObject("bids", bidService.getBidsByUserId(id));
        mav.addObject("max_value", bidService.setMaxCurrentMaxValue(proid));
        mav.addObject("product", productService.getProductWithDescriptionById(proid));
        //mav.addObject("product", productService.getProductById(proid));
        return mav;
    }

    @PostMapping("/{proid}&{name}/view")
    public ModelAndView doAddaProductBid(@PathVariable int id, @PathVariable int proid,
                                         @RequestParam int bidVal) throws Exception {
        Product product1 = productService.getProductWithDescriptionById(proid);
        try {
            bidService.addABid(product1, id, bidVal);
        } catch (Exception e) {
            System.out.println("NO");
        }
        return new ModelAndView("redirect:/mainpage/" + id + "/products");

    }


    @GetMapping("/{proid}&{name}/details")
    public ModelAndView doViewProduct(@PathVariable int id, @PathVariable int proid) {
        ModelAndView mav = new ModelAndView("product-details");
        mav.setViewName("view-product");
        mav.addObject("user", bidService.getUsersWithBidsById(id));
        mav.addObject("product", productService.getProductById(proid));
        return mav;
    }

    @GetMapping("/viewProducts")
    public ModelAndView doViewOwnedProducts(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("add-products");
        mav.addObject("user", userService.getUserById(id));
        mav.addObject("owneProducts", owenProductsService.getUserProductsByUserId(id));
        mav.addObject("ownedBids", bidService.getWonBidsByUserId(id));
        return mav;
    }

    //De implementat!
    @GetMapping("/viewProducts/{product_id}/addtoOrder")
    public ModelAndView doAddProductToOrder(@PathVariable int id, @PathVariable int product_id) {
        ModelAndView mav = new ModelAndView();
        try {
//            orderService.addProductForOrder(id, product_id);
//            mav.addObject("");
        } catch (ValidationException e) {
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
            mav.setViewName("redirect:/viewProducts");
        }
    return mav;
    }

}
