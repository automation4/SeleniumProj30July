package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static String getProperty(String whatdoyoudowant) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\RahulshettyTestdata.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(whatdoyoudowant);
    }

}
