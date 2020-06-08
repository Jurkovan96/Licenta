package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.exceptions.ValidationException;
import siit.model.CryptoByte;
import siit.model.User;
import siit.service.UserService;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/loginf")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private CryptoByte cryptoByte;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public ModelAndView displayLogin() {
        ModelAndView mav = new ModelAndView("loginf");
        return mav;
    }

    @PostMapping
    public ModelAndView doLogin(HttpSession session, @RequestParam String user, @RequestParam String password) {
        ModelAndView mav = new ModelAndView();

        try {
            if(userService.checkUserObj(user, password) == true) {
                session.setAttribute("loggedUserId", userService.getUserByName(user).getId());
                mav.addObject("user", userService.getUserByName(user).getId());
                int id = userService.getUserByName(user).getId();
                mav.setViewName("redirect:/mainpage/" + id);
            }
        } catch (ValidationException e) {
           // mav.setViewName("redirect:/VartLogin");
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
        }

        return mav;
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginf";
    }


}
