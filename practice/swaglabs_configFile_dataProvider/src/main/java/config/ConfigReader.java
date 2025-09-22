package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import java.net.*;

public class ConfigReader {

	
	private static Properties properties=new Properties();

	public static String getProperty(String key){   
   
	try {
		
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
	properties.load(fis);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return properties.getProperty(key);
}
}