package core;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();
    static {
        try(InputStream is = ConfigReader.class.getResourceAsStream("/config/qa.properties")){
            props.load(is);
        }catch(Exception e){ throw new RuntimeException("Cannot load properties", e); }
    }
    public static String get(String key){ return props.getProperty(key); }
}