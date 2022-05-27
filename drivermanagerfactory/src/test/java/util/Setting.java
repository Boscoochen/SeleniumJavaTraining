package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setting {
	public static String readPropertiesFile(String key) throws IOException {
		InputStream inStream = new FileInputStream(new File("src/test/resources/config.properties"));
		Properties prop = new Properties();
		prop.load(inStream);
		return prop.getProperty(key);
	}
}
