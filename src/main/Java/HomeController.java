package main.Java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author amila
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static final String view = "Home";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect(@RequestParam("firstName")String fName,@RequestParam("lastName")String lName) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("firstName", fName);
        modelAndView.addObject("lastName", lName);
        return modelAndView;
    }




}
