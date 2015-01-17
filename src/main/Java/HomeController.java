package main.Java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Logger;

/**
 * @author amila
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static final String view = "Home";

    Logger log = Logger.getLogger(HomeController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("firstName", fName);
        modelAndView.addObject("lastName", lName);


        // test begins

        ///String data = getData();
        String data2 = testConnect();

        // test ends
        return modelAndView;
    }

    //this sucks
    private String getData() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myAppDB");

            // This works too
            // Context envCtx = (Context) ctx.lookup("java:comp/env");
            // DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

            conn = ds.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM user");

            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                sb.append("ID: ").append(id).append(", First Name: ").append(firstName).append(", Last Name: ").append(lastName).append("<br/>");
            }
        } catch (Exception ex) {
            log.info("error occurred executing query " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                log.info("sql exception occurred " + e);
            }
        }
        return sb.toString();
    }

    //this works
    public String testConnect() {
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
    }


}
