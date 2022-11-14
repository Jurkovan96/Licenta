package siit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testing-jsp")
public class DummyController {

    @GetMapping
    public String getTest() {
        return "testing-jsp";
    }
}
