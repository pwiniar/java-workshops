package properties.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Pawel on 2017-01-30.
 */
@lombok.Getter
public class PropertiesManager {
    private String oracleUserName;
    private String oraclePassword;
    private String oracleServerName;
    private String oracleBbName;
    private String oracleDbms;
    private String oracleUrl;
    private String oracleDriver;
    private String oraclePort;

    public PropertiesManager() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {

            String filename = "config.properties";
            input = PropertiesManager.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            properties.load(input);
            assertNotNull(this.oracleUserName = properties.getProperty("oracle.userName"));
            this.oraclePassword = properties.getProperty("oracle.password");
            this.oracleServerName = properties.getProperty("oracle.serverName");
            this.oracleBbName = properties.getProperty("oracle.dbName");
            this.oracleDbms = properties.getProperty("oracle.dbms");
            this.oracleUrl = properties.getProperty("oracle.url");
            this.oracleDriver = properties.getProperty("oracle.driver");
            this.oraclePort = properties.getProperty("oracle.port");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}