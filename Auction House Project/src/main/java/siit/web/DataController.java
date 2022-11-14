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
import java.util.Locale;

import siit.model.CryptoByte;
import siit.service.*;

@Controller
@RequestMapping("/password-reset")
public class DataController {

    @Autowired
    private DoSentEmails doSentEmails;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CryptoByte cryptoByte;

    @GetMapping
    public ModelAndView doReserPasswordView() {
        ModelAndView mav = new ModelAndView("password-reset");
        return mav;
    }


    @PostMapping
    public ModelAndView doResetPassword(@RequestParam String email) {
        ModelAndView mav = new ModelAndView();
        String password = "password".concat(cryptoByte.encrypt(email.getBytes()));
        try {
            if (userService.checkExistingEmailForPasswordChange(email) == true)
                userService.resetPassword(email, password);
                doSentEmails.getMailReady(email, password);
            mav.setViewName("redirect:/loginf");

        } catch (ValidationException e) {
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
        }
        return mav;
    }
}
