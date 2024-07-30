package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties = new Properties();

	static {
		try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
