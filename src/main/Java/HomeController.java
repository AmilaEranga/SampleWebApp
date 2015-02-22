package main.Java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


/**
 * @author amila
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static final String view = "Home";

    Logger log = LoggerFactory.getLogger(HomeController.class.getName());

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView redirect(@RequestParam("userName") String userName, @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView(view);

        Map<String, String> userData = getData();
        if (userData.get(userName) != null && userData.get(userName).equals(password)) {
            modelAndView.addObject("firstName", userName);
        } else {
            modelAndView.addObject("error", "login error, invalid username password combination");
        }
        return modelAndView;
    }

    private Map<String, String> getData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Map<String, String> resultMap = new HashMap<String, String>();
        try {

            connection = ConnectionUtils.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String password = resultSet.getString("password");

                resultMap.put(firstName, password);
            }
        } catch (Exception ex) {
            log.error("error occurred executing query ", ex);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                log.error("Sql exception getting user data occurred", e);
            }
        }
        return resultMap;
    }

/*    public String testConnect() {
        String dbUrl = "jdbc:mysql://localhost/myAppDB";
        String dbClass = "com.mysql.jdbc.Driver";
        String query = "Select * from user";
        String username = "db_user";
        String password = "db_password";
        String fName = "";
        String lName = "";
        StringBuilder output = new StringBuilder();
        try {

            Class.forName(dbClass);
            Connection connection = DriverManager.getConnection(dbUrl,
                    username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                fName = resultSet.getString("first_name");
                lName = resultSet.getString("last_name");
            }
            output.append(fName).append(" ").append(lName);
            connection.close();
        } catch (ClassNotFoundException e) {
            log.info("class not found");
        } catch (SQLException e) {
            log.info("sql exception occurs");
        }
        return output.toString();
    }*/
}
