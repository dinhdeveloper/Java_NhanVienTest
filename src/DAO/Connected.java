package DAO;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Dinh
 */
public class Connected {

    public static String ConnectSQL() {
        String url = null;
        try (FileInputStream stream = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url") + properties.getProperty("serverName") + ":"
                    + properties.getProperty("portNumber") + "; databaseName = " + properties.getProperty("databaseName")
                    + "; user = " + properties.getProperty("user")
                    + "; password = " + properties.getProperty("password")
                    + "; integratedSecurity = " + properties.getProperty("integratedSecurity");
        } catch (Exception ex) {
            ex.printStackTrace();
			url = null;
        }
        return url;
    }
}
