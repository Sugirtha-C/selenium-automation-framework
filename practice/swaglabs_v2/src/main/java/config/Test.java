package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Test {
	private static Properties properties=new Properties();

	public static String getProperty(String key){
   
	try {

		//String currentUrl=new File(System.getProperty("user.dir")+"/src/main/resources/config.properties").getAbsolutePath();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		//InputStream input=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
		properties.load(fis);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return properties.getProperty(key);
}
	public static void main(String[] args) {
		System.out.println(getProperty("url"));
		System.out.println(System.getProperty("user.dir"));
	}
}
