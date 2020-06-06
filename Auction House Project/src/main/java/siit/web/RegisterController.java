package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import siit.exceptions.ValidationException;
import siit.model.CryptoByte;
import siit.model.User;
import siit.service.UserService;


import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    CryptoByte cryptoByte;

    @GetMapping("/login-register")
    public String doReg(){
        return "/login-register";
    }


    @PostMapping("/login-register")
    public ModelAndView displayRegister(HttpSession session, @RequestParam String newuser, @RequestParam String newpassword,
                                        @RequestParam String newemail){

        ModelAndView mav = new ModelAndView();
        if(userService.checkUserByEmail(newemail)){
        userService.addNewUserService(newuser, cryptoByte.encrypt(newpassword.getBytes()), newemail, "121");
        session.setAttribute("logged", newuser);
        int id = userService.getUserByName(newuser).getId();
        mav.setViewName("redirect:/mainpage/" + id);}

        else {
            mav.setViewName("redirect:/loginf");
        }

        return mav;}



}
