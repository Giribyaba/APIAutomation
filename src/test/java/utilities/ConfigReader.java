package utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class ConfigReader {
	
	  static Properties properties;
	public static void loadproperties() throws IOException
	{
		
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\API_Automation\\src\\test\\java\\resources\\Cofig.Properties");
			properties = new Properties();
			properties.load(fis);
}
	
	
	public static String getProperty(String key)
		{
			return properties.getProperty(key);
		}

}
