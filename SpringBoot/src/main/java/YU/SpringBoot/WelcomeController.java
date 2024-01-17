package YU.SpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name", required = false, defaultValue = "all of you") String name, Model model) {
        logger.info("request with /welcome ....");
        model.addAttribute("name", name);
        String result_msg = "Welcome " + name + " to ThymeLeaf world !!!";
        return result_msg;
    }
}
