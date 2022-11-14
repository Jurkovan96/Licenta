package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.exception.ValidationException;
import siit.model.CryptoByte;
import siit.model.User;
import siit.service.*;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.Locale;


@Controller
@RequestMapping("/mainpage")
public class MainPageController {

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

//    @Autowired
//    public BidService bidService;

    @Autowired
    public AddressService addressService;

    @Autowired
    public CryptoByte cryptoByte;

    @Autowired
    public ApplicationContext applicationContext;

    @GetMapping("/{id}")
    public ModelAndView doMain(@PathVariable int id) {

        ModelAndView mav = new ModelAndView("mainpage");
        mav.addObject("user", userService.getUserById(id));
        return mav;
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginf";
    }

    @GetMapping("/{id}/settings")
    public ModelAndView viewSettings(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("mainpage-settings");
        modelAndView.addObject("user", userService.getUserById(id));

        return modelAndView;
    }

    @PostMapping("/{id}/settings")
    public ModelAndView editUserAccount(@PathVariable int id, @ModelAttribute User user) {
        try {
            userService.upDateUser(id, user);

        } catch (ValidationException e) {
            ModelAndView mav = new ModelAndView("mainpage-settings");
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
            return mav;
        }

        return new ModelAndView("redirect:/mainpage/" + id);
    }

//    @GetMapping("/{id}/settings/edit-adress")
//    public ModelAndView doViewEditUserAdress(@PathVariable int id) {
//        ModelAndView mav = new ModelAndView("edit-adress");
//        mav.addObject("user", userService.getUserWithAdress(id));
//        mav.addObject("adress", addressService.getAdressForUserId(id));
//        return mav;
//    }
//
//    @PostMapping("/{id}/settings/edit-adress")
//    public ModelAndView doEditUserAdress(@PathVariable int id, @ModelAttribute Address address) {
//
//        Address address1 = userService.getUserWithAdress(id).getAdress();
//        try {
//            addressService.updateAdress(id, address);
//
//        } catch (ValidationException e) {
//            ModelAndView mav = new ModelAndView("edit-adress");
//            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
//            return mav;
//        }
//
//        return new ModelAndView("redirect:/mainpage/" + id);
//    }


//    @GetMapping("/{id}/contact")
//    public ModelAndView viewContacts(@PathVariable int id) {
//        ModelAndView modelAndView = new ModelAndView("mainpage-contact");
//        modelAndView.addObject("user", bidService.getUsersWithBidsById(id));
//        return modelAndView;
//    }

}

