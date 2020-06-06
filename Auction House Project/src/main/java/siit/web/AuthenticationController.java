package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.CryptoByte;
import siit.model.User;
import siit.service.BidService;
import siit.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

	@Autowired
	private UserService userService;

    @Autowired
	private CryptoByte cryptoByte;

	@GetMapping("/loginf")
	public String displayLogin() {
		return "loginf";
	}

	@PostMapping("/loginf")
	public ModelAndView doLogin(HttpSession session, @RequestParam String user, @RequestParam String password) {

		ModelAndView mav = new ModelAndView();
		if(userService.checkUser(user, password) == true){
			session.setAttribute("loggedUserId", userService.getUserByName(user).getId());
			 mav.addObject("user", userService.getUserByName(user).getId());
             int id = userService.getUserByName(user).getId();
             String stringId = String.valueOf(id);
             String cryptoId = cryptoByte.encrypt(stringId.getBytes());

             mav.setViewName("redirect:/mainpage/" + cryptoId);
		} else {
			mav.addObject("error", "Incorect user or password bitch!");
			mav.setViewName("loginf");
		}

		return mav;
	}

	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect;/loginf";
	}


}
