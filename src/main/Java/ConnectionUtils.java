package main.Java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author amila
 */
public class ConnectionUtils {

    private static Logger log = LoggerFactory.getLogger(ConnectionUtils.class.getName());

    public static Connection getConnection() {
        Connection connection = null;
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/myDB");
            connection = ds.getConnection();
        } catch (SQLException e) {
            log.error("Sql exception occur when connecting", e);
        } catch (NamingException e) {
            log.error("Naming exception occur", e);
        }
        return connection;
    }
}
