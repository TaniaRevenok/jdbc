package ua.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.sqlite.core.NativeDB.load;

public class PropertiesUtill {
    private Properties properties = null;
    public PropertiesUtill() throws Exception {
       load();
    }
    public String getHostname(){
        return properties.getProperty("database.hostname");
    }
    public String getSchema(){
        return properties.getProperty("database.schema");
}
    public String getPort() {
        return properties.getProperty("database.port");
    }
    public String getUser() {
        return properties.getProperty("database.user");
    }
    public String getPassword() {
        return properties.getProperty("database.password");
    }
 public void load() {
   this.properties = new Properties();
   try (InputStream is = ClassLoader.getSystemResourceAsStream("application.properties") ){
           properties.load(is);

   } catch (IOException e) {
       e.printStackTrace();
   }

 }
}
