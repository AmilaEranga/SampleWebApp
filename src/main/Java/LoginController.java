package main.Java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author amila
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String view = "Login";

    Logger log = LoggerFactory.getLogger(HomeController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect() {
        log.info("loading login page");
        return new ModelAndView(view);
    }

}
