package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import siit.exception.ValidationException;
import siit.model.CryptoByte;
import siit.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/login-register")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    CryptoByte cryptoByte;

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping
    public ModelAndView doDisplayRegister() {
        ModelAndView mav = new ModelAndView("login-register");
        return mav;
    }


    @PostMapping
    public ModelAndView displayRegister(HttpSession session, @RequestParam String newuser, @RequestParam String newpassword,
                                        @RequestParam String newemail) {

        ModelAndView mav = new ModelAndView();
        try{
        if (userService.checkExistingEmailForRegister(newemail) == true && userService.checkExistingUserName(newuser) == true) {
            userService.addNewUserService(newuser, cryptoByte.encrypt(newpassword.getBytes()), newemail, "12345");
            session.setAttribute("logged", newuser);
            int id = userService.getUserByName(newuser).getId();
            userService.addAdressDefault(id);
            mav.setViewName("redirect:/mainpage/" + id);
        }
        }  catch (ValidationException e){
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
            //mav.setViewName("redirect:/VartLogin");
        }

        return mav;
    }





}
