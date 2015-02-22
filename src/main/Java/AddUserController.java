package main.Java;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author amila
 */

@Controller
@RequestMapping("/addUser")

public class AddUserController {

    private static final String signInFormView = "SignInForm";
    private static final String loginFormView = "Login";

    Logger log = LoggerFactory.getLogger(AddUserController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect() {
        return new ModelAndView(signInFormView);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView redirect(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("cPassword") String cPassword) {
        Statement statement;
        ModelAndView modelAndView;
        Connection connection = ConnectionUtils.getConnection();
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO user " + "(first_name,password,email) " + "VALUES ( '" + name + "','" + password + "','" + email + "' " +
                    ")";
            log.info("query = {}", query);
            statement.executeUpdate(query);

            modelAndView = new ModelAndView(loginFormView);
            modelAndView.addObject("message", "Registering Completed. Login with new user");

        } catch (MySQLIntegrityConstraintViolationException e) {
            log.error("Sql exception occurred", e);
            modelAndView = new ModelAndView(signInFormView);
            modelAndView.addObject("message", "User Name already exists");
        } catch (SQLException e) {
            log.error("Sql exception occurred", e);
            modelAndView = new ModelAndView(signInFormView);
            modelAndView.addObject("message", "Unknown error occurred. Contact System administrator");
        }

        return modelAndView;
    }

}

