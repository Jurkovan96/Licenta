package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import siit.service.ProductService;

@Controller
@RequestMapping("/vart-home")
public class GuestCotroller {

    @Autowired
    public ProductService productService;


    @GetMapping
    public ModelAndView doArtpage(){
        return new ModelAndView("vart-home");
    }

   @GetMapping("/products")
   public ModelAndView doProductsOffline(){
         ModelAndView mav = new ModelAndView("mainpage-productsv");
         mav.addObject("products", productService.getProducts());
         return mav;
   }

   @GetMapping("/loginf")
   public ModelAndView doLoginUser(){
        return new ModelAndView("/loginf");
   }

}
