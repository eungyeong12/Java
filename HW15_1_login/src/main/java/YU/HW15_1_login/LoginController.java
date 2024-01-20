package YU.HW15_1_login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(Hw151LoginApplication.class);

    @GetMapping("/")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id")String id, @RequestParam("password")String password) {
        logger.info("id : " + id + ", password = " + password);
        return "redirect:/";
    }

}
