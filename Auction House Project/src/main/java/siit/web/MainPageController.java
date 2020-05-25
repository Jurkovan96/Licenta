package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.User;
import siit.service.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/mainpage")
public class MainPageController {

   @Autowired
   public UserService userService;

   @Autowired
   public ProductService productService;

   @Autowired
   public BidService bidService;

   @Autowired
   public AdressService adressService;

   @GetMapping("/{id}")
    public ModelAndView doMain(@PathVariable int id){
        ModelAndView mav = new ModelAndView("mainpage");
        mav.addObject("user", userService.getUserById(id));
        return mav;
   }

   @GetMapping("/logout")
   public String doLogout(HttpSession session){
       session.invalidate();
       return "redirect:/loginf";
   }

   @GetMapping("/{id}/settings")
   public ModelAndView viewSettings(@PathVariable int id){
       ModelAndView modelAndView = new ModelAndView("mainpage-settings");
       modelAndView.addObject("user", userService.getUserById(id));

       return modelAndView;
   }

   //Testting!!!!!!
   @PostMapping("/{id}/settings")
    public ModelAndView editUserAccount(@PathVariable int id, @ModelAttribute User user){
        if(user.getId() == id) {
            userService.upDateUser(user);
            //adressService.updateAdress(user.getAdress());
            return new ModelAndView("redirect:/mainpage/{id}");
        }
        else {return new ModelAndView("redirect:/mainpage/" + id);}
    }

     @GetMapping("/{id}/contact")
     public ModelAndView viewContacts(@PathVariable int id){
     ModelAndView modelAndView = new ModelAndView("mainpage-contact");
     modelAndView.addObject("user", bidService.getUsersWithBidsById(id));
     return modelAndView;
}

  }

